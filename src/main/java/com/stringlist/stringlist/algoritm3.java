package com.stringlist.stringlist;

import java.util.Arrays;
import java.util.Random;

import static com.stringlist.stringlist.SortUtils.SortedArrayRecurse;

public class algoritm3 {
    public static void main(String[] args) {

            Random rand = new Random();
            int[] sortArrayRecurse = new int[94];
            int i = 0;
            int j = 0;
            for (int i11 = 0; i11 < sortArrayRecurse.length; i11++) {
                sortArrayRecurse[i11] = rand.nextInt(100);
            }

            System.out.println(Arrays.toString(SortedArrayRecurse(sortArrayRecurse, i, j)));
            System.out.println(Arrays.toString(Arrays.stream(sortArrayRecurse).toArray()));
            System.out.println("-");

    }
}
