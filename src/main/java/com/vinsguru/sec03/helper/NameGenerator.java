package com.vinsguru.sec03.helper;

import com.vinsguru.common.Util;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.IntStream;

public class NameGenerator {

    public static Flux<String> getNameFlux(int count){

        return Flux.range(1, count)
                .map(i -> generateName());
    }


    public static List<String> getNameList(int count){

        return IntStream.rangeClosed(1, count)
                .mapToObj(i -> generateName())
                .toList();
    }

    private static String generateName() {
        Util.sleepSeconds(1);
        return Util.faker().name().firstName();
    }

}
