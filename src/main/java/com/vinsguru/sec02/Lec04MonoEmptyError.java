package com.vinsguru.sec02;

import com.vinsguru.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;


public class Lec04MonoEmptyError {
    private static final Logger log = LoggerFactory.getLogger(Lec04MonoEmptyError.class);

    public static void main(String[] args) {

        getUsername(22)
                .subscribe(Util.subscriber());
    }
    private static Mono<String> getUsername(int userId){
        return switch (userId){
          case 1 -> Mono.just("sam");
          case 2 -> Mono.empty();
          default -> Mono.error(new RuntimeException("invalid input"));

        };
    }
}
