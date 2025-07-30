package com.vinsguru.sec02;

import com.vinsguru.subscriber.SubscriberImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;


public class Lec01MonoJust {
    private static final Logger log = LoggerFactory.getLogger(Lec01MonoJust.class);

    public static void main(String[] args) {
        Mono<String> mono = Mono.just("vins");
        System.out.println(mono);
        var subscriber = new SubscriberImpl();
        mono.subscribe(subscriber);
        subscriber.getSubscription().request(10);
        subscriber.getSubscription().request(10);
        subscriber.getSubscription().cancel();

    }
}
