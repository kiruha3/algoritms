package com.stringlist.stringlist;

import java.util.Arrays;
import java.util.Random;

import static com.stringlist.stringlist.SortUtils.SortedArrayRecurse;
import static com.stringlist.stringlist.SortUtils.bubbleSort21;

public class algoritm3 {
    public static int coun = 0;
    public static void main(String[] args) {

        Random rand = new Random();
        Integer[] sortArrayRecurse = new Integer[50];
        for (int i11 = 0; i11 < sortArrayRecurse.length; i11++) {
            sortArrayRecurse[i11] = rand.nextInt(100);
        }
        System.out.println(Arrays.toString(Arrays.stream(sortArrayRecurse).toArray()));
        System.out.println(Arrays.toString(SortedArrayRecurse(sortArrayRecurse, 0, 0)));
//        System.out.println(Arrays.toString(bubbleSort21(sortArrayRecurse, sortArrayRecurse.length)));
        System.out.println("-");

    }
}
