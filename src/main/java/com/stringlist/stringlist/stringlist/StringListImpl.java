package com.stringlist.stringlist.stringlist;

import com.stringlist.stringlist.selfexeption.IndexOfExeption;
import com.stringlist.stringlist.selfexeption.ItemofExeption;

import java.util.Arrays;
import java.util.Objects;

public class StringListImpl implements StringList {
    private String[] StringList;
    private int size;

    public StringListImpl() {
        this.StringList = new String[size];
    }

    public StringListImpl(int size) {
        StringList = new String[10];
    }


    @Override
    public String add(String item) {
        validateSize();
        validateItem(item)
        StringList[size++]=item;
        if (StringList[StringList.length - 1] == null) {
            StringList[0] = item;
            return StringList[0];
        } else {
            String[] bufArray = new String[StringList.length + 1];
            System.arraycopy(StringList, 0, bufArray, 0, bufArray.length - 1);
            bufArray[StringList.length] = item;
            StringList = new String[bufArray.length];
            System.arraycopy(bufArray, 0, StringList, 0, StringList.length);
            return StringList[StringList.length - 1];
        }
    }

    @Override
    public String add(int index, String item) {
        if (StringList.length - 1 < index) {
            throw new IndexOfExeption("Введенный index вне диапазона");
        } else {
            String[] bufArray = new String[StringList.length + 1];
            if (index >= 0) System.arraycopy(StringList, 0, bufArray, 0, index);
            bufArray[index] = item;
            if (bufArray.length - 1 - (index + 1) >= 0)
                System.arraycopy(StringList, index + 1, bufArray, index + 1, bufArray.length - 1 - (index + 1));
            StringList = new String[bufArray.length - 1];
            System.arraycopy(bufArray, 0, StringList, 0, StringList.length);
            return StringList[index];
        }
    }

    @Override
    public String set(int index, String item) {
        validateIndex(index);
        validateItem(item);
        StringList[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        boolean catcher = false;
        int counter = 0;
        for (String s : StringList) {
            if (Objects.equals(s, item)) {
                catcher = true;
                break;
            }
            counter++;
        }
        if (catcher) {

            String[] bufArray = new String[StringList.length - 1];

            if (counter >= 0) System.arraycopy(StringList, 0, bufArray, 0, counter);

            if (bufArray.length - counter >= 0)
                System.arraycopy(StringList, counter + 1, bufArray, counter, bufArray.length - counter);

            if (bufArray.length == 0) StringList = new String[bufArray.length + 1];
            else StringList = new String[bufArray.length];

            for (int i = 0; i < StringList.length; i++) {
                if (bufArray.length == 0) {
                    break;
                } else {
                    StringList[i] = bufArray[i];
                }
            }
            return item;
        } else {
            throw new ItemofExeption("Введенный item не существует");
        }
    }

    @Override
    public String remove(int index) {
        if (StringList.length > index && index > -1) {
            String[] bufArray = new String[StringList.length - 1];
            String itemIndex = StringList[index];

            if (index >= 0) System.arraycopy(StringList, 0, bufArray, 0, index);

            if (bufArray.length - index >= 0)
                System.arraycopy(StringList, index + 1, bufArray, index, bufArray.length - index);

            if (bufArray.length == 0) StringList = new String[bufArray.length + 1];
            else StringList = new String[bufArray.length];

            for (int i = 0; i < StringList.length; i++) {
                if (bufArray.length == 0) {
                    break;
                } else {
                    StringList[i] = bufArray[i];
                }
            }
            return itemIndex;
        } else {
            throw new ItemofExeption("Введенный index не существует");
        }
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        int counter = 0;
        for (String s : StringList) {
            if (Objects.equals(s, item)) {
                return counter;
            }
            counter++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = StringList.length - 1; i >= 0; i--) {
            if (Objects.equals(StringList[i], item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        return StringList[index];
    }

    @Override
    public boolean equals(StringList otherList) {

        return Arrays.equals(StringList, otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < StringList.length; i++) {
            if (StringList[i] != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(StringList, size);
    }

    @Override
    public String toString() {
        String stroka = "";

        for (String s : StringList) {
            stroka += s;
        }
        return stroka;
    }

    public void validateItem(String item) {
        if (item == null) {
            throw new ItemofExeption("Введенный item не существует");
        }
    }

    public void validateSize(String item) {
        if (size == StringList.length) {
            throw new FulllistExeption("Введенный index не существует");
        }
    }

    public void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new ItemofExeption("Введенный index не существует");
        }
    }
}
