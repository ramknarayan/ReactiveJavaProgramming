package com.vinsguru.sec05;

import com.vinsguru.common.Util;
import com.vinsguru.sec05.assignment.ExternalServiceClient;

public class Lec11Assignment {
    public static void main(String[] args) {
        var client = new ExternalServiceClient();

        for(int i=1;i<5;i++){
            client.getProductName(i).subscribe(Util.subscriber());
        }
        Util.sleepSeconds(3);
    }
}
