package com.stringlist.stringlist.stringlist;

import com.stringlist.stringlist.selfexeption.IndexOfExeption;
import com.stringlist.stringlist.selfexeption.ItemofExeption;

public class StringListRealisation implements StringList {
    private String item;
    private Integer size = 1;
    private String[] StringList = new String[size];


    @Override
    public String add(String item) {
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

//            return bufArray[bufArray.length - 1];
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
        if (StringList.length - 1 < index) {
            throw new IndexOfExeption("Введенный index вне диапазона");
        } else {
            StringList[index] = item;
            return StringList[index];
        }
    }

    @Override
    public String remove(String item) {
        boolean catcher = false;
        int counter = 0;
        for (String s : StringList) {
            if (s == item) {
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
        return null;
    }

    @Override
    public boolean contains(String item) {
        return false;
    }

    @Override
    public int indexOf(String item) {
        return 0;
    }

    @Override
    public int lastIndexOf(String item) {
        return 0;
    }

    @Override
    public String get(int index) {
        return null;
    }

    @Override
    public boolean equals(StringList otherList) {
        return false;
    }

    @Override
    public int size() {
        return StringList.length;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public String[] toArray() {
        return new String[0];
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String[] getStringList() {
        return StringList;
    }

    public void setStringList(String[] stringList) {
        StringList = stringList;
    }

    @Override
    public String toString() {
        String stroka = "";

        for (String s : StringList) {
            stroka += s;
        }
        return stroka;
    }
}
