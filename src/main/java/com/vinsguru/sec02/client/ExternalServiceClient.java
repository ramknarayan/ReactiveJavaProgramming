package com.vinsguru.sec02.client;

import com.vinsguru.common.AbstractHttPClient;
import reactor.core.publisher.Mono;

public class ExternalServiceClient extends AbstractHttPClient {

    public Mono<String> getProductName(int productId){
        return this.httpClient.get()
                .uri("/demo01/product/"+productId)
                .responseContent()
                .asString()
                .next();

    }
}
