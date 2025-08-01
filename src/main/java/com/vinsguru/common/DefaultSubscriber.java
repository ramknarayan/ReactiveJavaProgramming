package com.vinsguru.common;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultSubscriber<T> implements Subscriber {
    private static final Logger log = LoggerFactory.getLogger(DefaultSubscriber.class);
    private final String name;

    public DefaultSubscriber(String name){
        this.name = name;
    }
    @Override
    public void onSubscribe(Subscription subscription) {
        subscription.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(Object o) {
        log.info("{} received : {}",this.name,o);
    }

    @Override
    public void onError(Throwable throwable) {
        log.error("{} error",this.name,throwable);
    }

    @Override
    public void onComplete() {
        log.info("{} received completed!",this.name);
    }
}
