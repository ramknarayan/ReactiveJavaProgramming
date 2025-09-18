package com.vinsguru.sec10.assignment;

import com.vinsguru.common.Util;

public record BookOrder(String genre, String Title, Integer price) {

    public static  BookOrder create(){
        var book = Util.faker().book();
        return new BookOrder(
                book.genre(),
                book.title(),
                Util.faker().random().nextInt(10,100)
        );
    }

}
