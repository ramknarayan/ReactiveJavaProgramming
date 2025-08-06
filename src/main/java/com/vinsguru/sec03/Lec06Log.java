package com.vinsguru.sec03;

import com.vinsguru.common.Util;
import reactor.core.publisher.Flux;

public class Lec06Log {

    public static void main(String[] args) {
        Flux.range(1,5)
                .log("range-log : ")
                .map(i -> Util.faker().name().firstName())
                .log("map Log : ")
                .subscribe(Util.subscriber());
    }
}
