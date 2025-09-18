package com.vinsguru.sec11;

import com.vinsguru.common.Util;
import reactor.core.publisher.Mono;

public class Lec01Repeat {
    public static void main(String[] args) {
        var mono = Mono.fromSupplier(()-> Util.faker().country().name());
        var subscriber = Util.subscriber();
        mono.repeat().subscribe(subscriber);
    }
    private static Mono<String> getCountryName(){
        return  Mono.fromSupplier(()-> Util.faker().country().name());
    }
}
