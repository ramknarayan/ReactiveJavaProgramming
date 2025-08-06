package com.vinsguru.sec03;

import com.vinsguru.common.Util;
import com.vinsguru.sec03.helper.NameGenerator;

public class Lec07FluxVsList {

    public static void main(String[] args) {

        /*var list = NameGenerator.getNameList(10);
        System.out.println(list);*/

        NameGenerator.getNameFlux(10).subscribe(Util.subscriber());

    }

}
