package com.vinsguru.sec03;

import com.vinsguru.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;


public class Lec02MultipleSubscribers {
    private static final Logger log = LoggerFactory.getLogger(Lec02MultipleSubscribers.class);

    public static void main(String[] args) {


    }

    private static Mono<String> getProductName(int productid){
        if(productid==1){
            return Mono.fromSupplier(()->Util.faker().commerce().productName());
        }
        return Mono.fromRunnable(()->notifyBusiness(productid));
    }
    private static  void notifyBusiness(int productid){
        log.info("notifying business on unavailable product {}",productid);
    }
}
