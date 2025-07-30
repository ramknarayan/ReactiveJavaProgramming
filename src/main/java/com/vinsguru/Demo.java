package com.vinsguru;

import com.vinsguru.publisher.PublisherImpl;
import com.vinsguru.subscriber.SubscriberImpl;

import java.time.Duration;

public class Demo {
    public static void main(String[] args) throws InterruptedException {

        demo3();
        System.out.println("Hello, World!");
    }
    private static  void demo1(){
        var publisher = new PublisherImpl();
        var subscriber = new SubscriberImpl();

        publisher.subscribe(subscriber);

    }
    private static  void demo2() throws InterruptedException {
        var publisher = new PublisherImpl();
        var subscriber = new SubscriberImpl();

        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));


    }
    private static  void demo3() throws InterruptedException {
        var publisher = new PublisherImpl();
        var subscriber = new SubscriberImpl();

        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().cancel();
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));



    }

}