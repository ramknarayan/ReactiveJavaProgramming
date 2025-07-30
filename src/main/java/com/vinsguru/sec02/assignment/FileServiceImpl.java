package com.vinsguru.sec02.assignment;

import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileServiceImpl implements FileService{
    private static final Path PATH = Path.of("src/main/resources/sec02");
    @Override
    public Mono<String> read(String fileName) {
        return Mono.fromCallable(()->Files.readString(PATH.resolve(fileName)));
    }

    @Override
    public Mono<String> write(String fileName, String content) {
        return Mono.fromRunnable(()-> this.writeFile(fileName,content));
    }

    @Override
    public Mono<String> delete(String fileName) {
        return Mono.fromRunnable(()->this.deleteFile(fileName));
    }
    private void writeFile(String filename,String content){
        try {
            Files.writeString(PATH.resolve(filename),content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void deleteFile(String filename){
        try {
            Files.delete(PATH.resolve(filename));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
