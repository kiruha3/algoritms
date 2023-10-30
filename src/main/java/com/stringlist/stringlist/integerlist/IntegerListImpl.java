package com.stringlist.stringlist.integerlist;

import com.stringlist.stringlist.selfexeption.FulllistExeption;
import com.stringlist.stringlist.selfexeption.ItemofExeption;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class IntegerListImpl implements IntegerList {
    protected Integer[] IntegerList;
    private int size;

    public IntegerListImpl() {
        this.IntegerList = new Integer[size];
    }

    public IntegerListImpl(int size) {
        IntegerList = new Integer[size];
    }


    @Override
    public Integer add(Integer item) {
        validateSize();
        validateItem(item);

        IntegerList[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        validateSize();
        validateItem(item);
        validateIndex(index);
        if (index == size) {
            IntegerList[size++] = item;
            return item;
        }
        for (int i = IntegerList.length - 1; i > index; i--) {
            IntegerList[i] = IntegerList[i - 1];
        }
        IntegerList[index] = item;
        size++;
        return item;
    }

    @Override
    public Integer set(Integer index, Integer item) {
        validateIndex(index);
        validateItem(item);
        IntegerList[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        validateItem(item);
        int index = indexOf(item);
        if (index == -1) {
            throw new ItemofExeption("нет такого");
        }
        if (index != size) {
            System.arraycopy(IntegerList, index + 1, IntegerList, index, size - index - 1);
        }
        size--;
        return item;
    }

    @Override
    public Integer remove(int index) {
        validateIndex(index);
        Integer item = IntegerList[index];
        if (index != size) {
            System.arraycopy(IntegerList, index + 1, IntegerList, index, size - (index + 1));
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(Integer item) {
//        int counter = 0;
//        for (Integer s : IntegerList) {
//            if (Objects.equals(s, item)) {
//                return counter;
//            }
//            counter++;
//        }
//        return -1;
        if (item == null) {
            throw new NullPointerException("Параметр item не должен равняться null");
        }

        return Collections.binarySearch(Arrays.asList(IntegerList), item);
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = IntegerList.length - 1; i >= 0; i--) {
            if (Objects.equals(IntegerList[i], item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        validateIndex(index);
        return IntegerList[index];
    }

//    @Override
//    public Integer toString() {
//        String stroka = "";
//
//        for (String s : IntegerList) {
//            stroka += s;
//        }
//        return stroka;
//    }

    @Override
    public boolean equals(IntegerList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < IntegerList.length; i++) {
            if (IntegerList[i] != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void clear() {
        size = 0;
        IntegerList[1] = null;

    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(IntegerList, size);
    }

    public void validateItem(Integer item) {
        if (item == null) {
            throw new ItemofExeption("Введенный item не существует");
        }
    }

    public void validateSize() {
        if (size == IntegerList.length) {
            throw new FulllistExeption("Введенный index вне диапазона");
        }
    }

    public void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new ItemofExeption("Введенный index не существует");
        }
    }

    void compress() {
        for (int i = 0; i < IntegerList.length; i++) {
            if (IntegerList[i] != null) {
                continue;
            }

            for (int j = i; j < IntegerList.length; j++) {
                if (IntegerList[j] != null) {
                    IntegerList[i] = IntegerList[j];
                    IntegerList[j] = null;
                    break;
                }
            }
        }
    }


}
