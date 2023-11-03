package com.stringlist.stringlist;

public class SortUtils {
    public static Integer[] bubbleSort(Integer[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swapElements(array, j, j + 1);
                }
            }
        }
        return array;
    }

    public static Integer[] selectionSort(Integer[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(array, i, minElementIndex);
        }
        return array;
    }

    public static Integer[] insertionSort(Integer[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i;
            while (j > 0 && array[j - 1] >= temp) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }
        return array;
    }

    private static void swapElements(Object[] array, int indexA, int indexB) {
        Object buffer = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = buffer;
    }
    public static Integer[] SortedArrayRecurse(Integer[] array, int i, int j) {
        if (j != array.length) {
            if ((i + 1) != array.length) {
                if (array[i] > array[i + 1]) {
                    array = swapElements(array, i, i + 1);
                }
            }
            if ((i + 1) == array.length) {
                i = 0;
                return SortedArrayRecurse(array, i, j);
            } else {
                i++;
            }
            if (i == array.length - 1) j++;
//            System.out.println(Arrays.toString(array));
            return SortedArrayRecurse(array, i, j);
        } else {
            return array;
        }
    }

    private static Integer[] swapElements(Integer[] array, int indexA, int indexB) {
        int buffer = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = buffer;
        return array;
    }
}
