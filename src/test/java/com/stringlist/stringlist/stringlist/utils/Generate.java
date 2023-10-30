package com.stringlist.stringlist.stringlist.utils;

import java.util.Objects;

public class Generate {
    public int indexOf(String item,String[] StringList) {
        int counter = 0;
        for (String s : StringList) {
            if (Objects.equals(s, item)) {
                return counter;
            }
            counter++;
        }
        return -1;
    }
    public int indexOfInt(Integer item, Integer[] StringList) {
        int counter = 0;
        for (Integer s : StringList) {
            if (Objects.equals(s, item)) {
                return counter;
            }
            counter++;
        }
        return -1;
    }
}
