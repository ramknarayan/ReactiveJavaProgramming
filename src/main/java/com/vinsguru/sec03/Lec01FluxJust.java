package com.vinsguru.sec03;

import com.vinsguru.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public class Lec01FluxJust {
    private static final Logger log = LoggerFactory.getLogger(Lec01FluxJust.class);

    public static void main(String[] args) {
      Flux.just("TEsting")
                .subscribe(Util.subscriber());

    }


}
