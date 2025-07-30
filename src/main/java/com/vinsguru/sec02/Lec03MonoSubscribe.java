package com.vinsguru.sec02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;


public class Lec03MonoSubscribe {
    private static final Logger log = LoggerFactory.getLogger(Lec03MonoSubscribe.class);

    public static void main(String[] args) {
        Mono<Integer> mono = Mono.just(1);
        mono.subscribe(i->log.info("received:{}",i),
                    err->log.error("error",err),
                ()->log.info("completed")
                ,subscription -> subscription.request(1)
        );

    }
}
