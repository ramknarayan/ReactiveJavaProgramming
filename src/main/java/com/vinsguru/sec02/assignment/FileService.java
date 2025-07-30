package com.vinsguru.sec02.assignment;

import reactor.core.publisher.Mono;

public interface FileService  {
    public abstract  Mono<String> read(String fileName);
    public abstract  Mono<String> write(String fileName,String content);
    public abstract  Mono<String> delete(String fileName);


}
