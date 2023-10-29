package com.stringlist.stringlist.integerlist;

import com.stringlist.stringlist.selfexeption.FulllistExeption;
import com.stringlist.stringlist.selfexeption.ItemofExeption;

import java.util.Arrays;
import java.util.Objects;

public class IntegerListImpl implements IntegerList {
    private Integer[] IntegerList;
    private int size;

    public IntegerListImpl() {
        Integer[] IntegerList = this.IntegerList;
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
        int counter = 0;
        for (Integer s : IntegerList) {
            if (Objects.equals(s, item)) {
                return counter;
            }
            counter++;
        }
        return -1;
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

    @Override
    public boolean equals(IntegerList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
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

    private Integer[] swapElements(Integer indexA, Integer indexB) {
        Integer[] arr = new Integer[size];
//        arr = toArray();
        System.arraycopy(toArray(), 0, arr, 0, toArray().length);
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
        return arr;
    }

    @Override
    public Integer[] sortBubble() {
        Integer[] arr = new Integer[size];
        System.arraycopy(toArray(), 0, arr, 0, toArray().length);
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    arr = swapElements(j, j + 1);
                    System.out.println(Arrays.toString(Arrays.copyOf(arr, arr.length)));
                }
            }
        }
        clear();
        for (Integer i : arr) {
            add(i);
        }
        return toArray();
    }

    @Override
    public Integer[] sortSelection() {
        Integer[] arr = new Integer[size];
        System.arraycopy(toArray(), 0, arr, 0, toArray().length);
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            arr = swapElements(i, minElementIndex);
            System.out.println(Arrays.toString(Arrays.copyOf(arr, arr.length)));
        }
        return toArray();
    }

    @Override
    public Integer[] sortInsertion() {
        Integer[] arr = new Integer[size];
        arr = toArray();
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
        return toArray();
    }


}
