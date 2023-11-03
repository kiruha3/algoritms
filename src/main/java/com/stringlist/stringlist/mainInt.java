package com.stringlist.stringlist;

import com.stringlist.stringlist.integerlist.IntegerList;
import com.stringlist.stringlist.integerlist.IntegerListImpl;
import com.stringlist.stringlist.integerlist.SortedIntegerListImpl;

import java.util.Arrays;

public class mainInt {
    public static void main(String[] args) {
        IntegerList integerList = new SortedIntegerListImpl(5);
        integerList.add(7);
        integerList.add(6);
        integerList.add(10);
        integerList.add(103);
        integerList.add(12);
        integerList.add(12);
        System.out.println(integerList.size());
        System.out.println(integerList.get(4));

//        findFastedSortMethod();
    }
    private static void findFastedSortMethod() {
        IntegerList integerList = new SortedIntegerListImpl(5);
        integerList.add(7);
        integerList.add(6);
        integerList.add(10);
        integerList.add(103);
        integerList.add(12);
        System.out.println("Bubble sort");

        long start = System.currentTimeMillis();
        System.out.println(Arrays.toString(SortUtils.bubbleSort(Arrays.copyOf(integerList.toArray(), integerList.size()))));
        System.out.println(System.currentTimeMillis() - start + " ms.");
        IntegerList integerList2 = new SortedIntegerListImpl(5);
        integerList2.add(7);
        integerList2.add(6);
        integerList2.add(210);
        integerList2.add(103);
        integerList2.add(12);
        System.out.println("Selection sort");

        start = System.currentTimeMillis();
        System.out.println(Arrays.toString(SortUtils.selectionSort(Arrays.copyOf(integerList2.toArray(), integerList2.size()))));
        System.out.println(System.currentTimeMillis() - start + " ms.");
        IntegerList integerList3 = new SortedIntegerListImpl(5);
        integerList3.add(7);
        integerList3.add(62);
        integerList3.add(10);
        integerList3.add(1203);
        integerList3.add(12);
        System.out.println("Insertion sort");

        start = System.currentTimeMillis();
        System.out.println(Arrays.toString(SortUtils.insertionSort(Arrays.copyOf(integerList3.toArray(), integerList3.size()))));
        System.out.println(System.currentTimeMillis() - start + " ms.");
    }
}
