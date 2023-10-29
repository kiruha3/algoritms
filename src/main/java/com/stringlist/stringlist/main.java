package com.stringlist.stringlist;


import com.stringlist.stringlist.stringlist.StringList;
import com.stringlist.stringlist.stringlist.StringListImpl;

public class main {
    public static void main(String[] args) {
        StringList stringlist = new StringListImpl(5);
        stringlist.add("5");
        stringlist.add("6!");
//        System.out.println(stringlist.get(0));
        stringlist.add("10!");
        System.out.println(stringlist.size());
//
////        System.out.println(stringlist.size());
//        stringlist.add(2, "112!");
//        System.out.println(stringlist.set(2, "8!"));
////        System.out.println(stringlist.lastIndexOf("5")+"____________");
//        System.out.println(stringlist.remove(0));
//        System.out.println(stringlist.get(0));
//        stringlist.clear();
//        System.out.println(stringlist.get(0));
//        stringlist.add("112!");
//        System.out.println(stringlist.contains("112!"));
//        System.out.println(stringlist.remove(0));
//        System.out.println(stringlist.remove(0));
//        System.out.println(stringlist.size());
        StringList stringlist2 = new StringListImpl(5);
        stringlist2.add("5");
        stringlist2.add("6!");
        stringlist2.add("10!");
        System.out.println(stringlist.equals(stringlist2));
//        System.out.println(stringlist.isEmpty());
//        stringlist2.clear();
//        System.out.println(stringlist2.get(0));
//        System.out.println(Arrays.toString(stringlist.toArray()));

    }
}
