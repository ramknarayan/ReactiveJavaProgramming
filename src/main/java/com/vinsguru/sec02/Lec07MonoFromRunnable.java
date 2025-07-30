package com.vinsguru.sec02;

import com.vinsguru.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;


public class Lec07MonoFromRunnable {
    private static final Logger log = LoggerFactory.getLogger(Lec07MonoFromRunnable.class);

    public static void main(String[] args) {

        getProductName(1).subscribe(Util.subscriber());
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
