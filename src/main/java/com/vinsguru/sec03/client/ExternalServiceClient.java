package com.vinsguru.sec03.client;

import com.vinsguru.common.AbstractHttPClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ExternalServiceClient extends AbstractHttPClient {

    public Mono<String> getProductName(int productId){
        return this.httpClient.get()
                .uri("/demo01/product/"+ productId)
                .responseContent()
                .asString()
                .next();

    }

    public Flux<String> getNames(){
        return this.httpClient.get()
                .uri("/demo02/name/stream")
                .responseContent()
                .asString();
//                .next();

    }
}
