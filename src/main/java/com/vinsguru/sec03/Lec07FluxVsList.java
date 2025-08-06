package com.vinsguru.sec03;

import com.vinsguru.sec03.helper.NameGenerator;
import com.vinsguru.subscriber.SubscriberImpl;

public class Lec07FluxVsList {
    public static void main(String[] args) {
        var list = NameGenerator.getNamesList(10);
//        System.out.println(list);

        var subscriber = new SubscriberImpl();
        NameGenerator.getNamesFlux(10)
                .subscribe(subscriber);

        subscriber.getSubscription().request(3);
        subscriber.getSubscription().cancel();

    }
}
