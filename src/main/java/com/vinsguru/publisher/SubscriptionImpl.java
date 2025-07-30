package com.vinsguru.publisher;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubscriptionImpl implements Subscription {
    private static final Logger log = LoggerFactory.getLogger(SubscriptionImpl.class);
    private final Subscriber<? super String> subscriber;
    private boolean iscancelled;
    private final Faker faker;
    private static final int MAX_ITEMS = 10;
    private int count =0;


    public SubscriptionImpl(Subscriber<? super String> subscriber) {
        this.subscriber= subscriber;
        this.faker = Faker.instance();
    }

    @Override
    public void request(long requested) {
        if(iscancelled){
            return;
        }
        log.info("subscriber has requested{} items",requested);
        for(int i=0;i<requested && count<MAX_ITEMS;i++){
            count++;
            this.subscriber.onNext(this.faker.internet().emailAddress());
        }
        if(count==MAX_ITEMS){
            log.info("no more data to produce");
            this.subscriber.onComplete();
            this.iscancelled=true;
        }
    }

    @Override
    public void cancel() {
        log.info("subscriber has cancelled");
        this.iscancelled=true;
    }
}
