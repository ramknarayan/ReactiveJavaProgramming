package com.vinsguru.subscriber;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubscriberImpl implements Subscriber<String> {
    private static final Logger log = LoggerFactory.getLogger(SubscriberImpl.class);

    public Subscription getSubscription() {
        return subscription;
    }

    private Subscription subscription;

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
    }

    @Override
    public void onNext(String email) {
        log.info("received:{}", email);
    }

    @Override
    public void onError(Throwable throwable) {
        log.info("throwable:{}", throwable);
    }

    @Override
    public void onComplete() {
        log.info("onComplete:");
    }
}
