package com.vinsguru.sec02;

import com.vinsguru.common.Util;
import com.vinsguru.sec02.client.ExternalServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Lec11NonBlockingIO {
    private static final Logger log = LoggerFactory.getLogger(Lec11NonBlockingIO.class);

    public static void main(String[] args) {

        var client = new ExternalServiceClient();
        log.info("Started");
        for (int i = 0; i < 5; i++) {
            client.getProductName(i)
                    .subscribe(Util.subscriber());
        }


        Util.sleepSeconds(2);

    }

}
