package com.vinsguru.sec02;

import com.vinsguru.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.List;


public class Lec05MonoFromSupplier {
    private static final Logger log = LoggerFactory.getLogger(Lec05MonoFromSupplier.class);

    public static void main(String[] args) {

        var list =List.of(1,2,3);
        Mono.fromSupplier(()->sum(list))
                .subscribe(Util.subscriber());
    }
    private static int sum(List<Integer> list){
        log.info("Finding the sum of {}",list);
        return list.stream().mapToInt(a->a).sum();
    }
}
