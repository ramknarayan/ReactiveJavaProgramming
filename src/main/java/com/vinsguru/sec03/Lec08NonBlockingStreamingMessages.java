package com.vinsguru.sec03;

import com.vinsguru.common.Util;
import com.vinsguru.sec03.client.ExternalServiceClient;

public class Lec08NonBlockingStreamingMessages {

    public static void main(String[] args) {
        var client = new ExternalServiceClient();
                client.getNames().subscribe(Util.subscriber());

    }
}
