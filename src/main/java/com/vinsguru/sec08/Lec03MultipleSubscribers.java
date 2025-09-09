package com.vinsguru.sec08;

import com.vinsguru.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec03MultipleSubscribers {

    public static final Logger log = LoggerFactory.getLogger(Lec03MultipleSubscribers.class);

    public static void main(String[] args) {
        System.setProperty("reactor.bufferSize.small","16");
        var producer = Flux.generate(
                ()->1,
                (state,sink)->{
                    log.info("generating {}",state);
                    sink.next(state);
                    return ++state;
                }
        ).cast(Integer.class);
        producer
                .limitRate(5)
                .publishOn(Schedulers.boundedElastic())
                .map(Lec03MultipleSubscribers::timeConsumingTask)
                .subscribe(Util.subscriber());
        producer
                .take(100)
                .publishOn(Schedulers.boundedElastic())
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }
    private static int timeConsumingTask(int i){
        Util.sleepSeconds((i));
        return i;
    }
}
