package com.stringlist.stringlist;

import com.stringlist.stringlist.integerlist.IntegerList;
import com.stringlist.stringlist.integerlist.IntegerListImpl;

import java.util.Arrays;

public class mainInt {
    public static void main(String[] args) {
        IntegerList integerList = new IntegerListImpl(5);
        integerList.add(7);
        integerList.add(6);
        integerList.add(10);
        integerList.add(103);
        integerList.add(12);
        System.out.println(integerList.size());
        IntegerList integerList1 = new IntegerListImpl(5);
        integerList1.add(5);
        integerList1.add(6);
        integerList1.add(10);
        integerList1.add(62);
        integerList1.add(101);
        System.out.println(integerList.equals(integerList1));
        long start = System.currentTimeMillis();
//        System.out.println(Arrays.toString(integerList.sortBubble()));
        System.out.println(System.currentTimeMillis() - start);
        long start1 = System.currentTimeMillis();
        System.out.println(Arrays.toString(integerList.sortSelection()));
        System.out.println(System.currentTimeMillis() - start1);
        long start2 = System.currentTimeMillis();
        integerList.sortInsertion();
        System.out.println(System.currentTimeMillis() - start2);

    }
}
