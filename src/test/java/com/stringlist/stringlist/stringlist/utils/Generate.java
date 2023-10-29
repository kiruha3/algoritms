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
}
