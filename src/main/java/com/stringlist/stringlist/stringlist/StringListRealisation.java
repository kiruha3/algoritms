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
            for (int i = 0; i < bufArray.length - 1; i++) {
                bufArray[i] = StringList[i];
            }
            bufArray[StringList.length] = item;
            StringList = new String[bufArray.length];
            for (int i = 0; i < StringList.length; i++) {
                StringList[i] = bufArray[i];
            }
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
            for (int i = 0; i < index; i++) {
                bufArray[i] = StringList[i];
            }
            bufArray[index] = item;
            for (int i = index + 1; i < bufArray.length - 1; i++) {
                bufArray[i] = StringList[i];
            }
            StringList = new String[bufArray.length - 1];
            for (int i = 0; i < StringList.length; i++) {
                StringList[i] = bufArray[i];
            }
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

            for (int i = 0; i < counter; i++) {
                bufArray[i] = StringList[i];
            }

            for (int i = counter; i < bufArray.length; i++) {
                bufArray[i] = StringList[i + 1];
            }

            if (bufArray.length == 0)
                StringList = new String[bufArray.length + 1];
            else
                StringList = new String[bufArray.length];

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
