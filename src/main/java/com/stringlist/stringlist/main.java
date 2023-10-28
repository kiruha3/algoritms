package com.stringlist.stringlist;


import com.stringlist.stringlist.stringlist.StringList;
import com.stringlist.stringlist.stringlist.StringListRealisation;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        StringList stringlist = new StringListRealisation();
        stringlist.add("5");
        stringlist.add("6!");
        stringlist.add("10!");
        System.out.println(stringlist.size());
        stringlist.add(2,"112!");
//        System.out.println(stringlist.set(2,"8!");
        System.out.println(stringlist.lastIndexOf("5")+"____________");
        System.out.println(stringlist.remove(0));
        System.out.println(stringlist.remove("6!"));
        stringlist.add("112!");
        System.out.println(stringlist.contains("112!"));
        System.out.println(stringlist.remove(0));
        System.out.println(stringlist.remove(0));
        System.out.println(stringlist.size());



    }
}
