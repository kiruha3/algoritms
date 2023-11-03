package com.stringlist.stringlist;

import java.util.Arrays;

import static com.stringlist.stringlist.SortUtils.SortedArrayRecurse;

public class algoritm3 {
    public static void main(String[] args) {
        Integer[] sortArrayRecurse = new Integer[]{1,2,9,7,5,6,7,82,2,4,65,3,2,4,56,7,54,3};
        int i = 0;
        int j = 0;
        System.out.println(Arrays.toString(SortedArrayRecurse(sortArrayRecurse, i, j)));
        System.out.println(Arrays.toString(Arrays.stream(sortArrayRecurse).toArray()));
    }
}
