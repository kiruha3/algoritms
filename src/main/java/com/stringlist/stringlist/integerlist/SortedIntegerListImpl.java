package com.stringlist.stringlist.integerlist;

import com.stringlist.stringlist.SortUtils;

import java.util.Arrays;
import java.util.Collections;

public class SortedIntegerListImpl extends IntegerListImpl {


    public SortedIntegerListImpl() {
    }

    public SortedIntegerListImpl(int size) {
        super(size);
    }

    @Override
    public int indexOf(Integer item) {
        if (item == null) {
            throw new NullPointerException("Параметр item не должен равняться null");
        }

        return Collections.binarySearch(Arrays.asList(IntegerList), item);
    }

    private void sort() {
        SortUtils.selectionSort(IntegerList);
    }

    @Override
    protected void compress() {
        sort();
        super.compress();
    }
}
