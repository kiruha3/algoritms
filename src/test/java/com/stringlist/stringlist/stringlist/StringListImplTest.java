package com.stringlist.stringlist.stringlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringListImplTest {
    public final StringListImpl stringListImpl = new StringListImpl();

    @Test
    void add_success() {
        //Подготовка входных данных
        String[] arrayTest = new String[1];
        String item = "тест";
        //Подготовка ожидаемого результата
        arrayTest[0] = item;
        String expectedItemInArray = arrayTest[0];
        //Начало теста
        StringList stringList = new StringListImpl(1);
        stringList.add(item);
        String actualItemInArray = stringList.get(0);
        assertEquals(expectedItemInArray, actualItemInArray);
    }

    @Test
    void addofIndex_success() {
        //Подготовка входных данных
        int size = 4;
        String[] arrayTest = new String[4];
        String item = "тест";
        int index = 2;
        //Подготовка ожидаемого результата
        arrayTest[0] = "тест1";
        arrayTest[1] = "тест2";
        arrayTest[2] = "тест3";
        for (int i = index + 1; i < arrayTest.length; i++) {
            arrayTest[i] = arrayTest[i - 1];
        }
        arrayTest[2] = item;
        String expectedItemInArray = arrayTest[2];
        //Начало теста
        StringList stringList = new StringListImpl(4);
        stringList.add("тест1");
        stringList.add("тест2");
        stringList.add("тест3");
        stringList.add(2, item);
        String actualItemInArray = stringList.get(2);
        assertEquals(expectedItemInArray, actualItemInArray);
    }

    @Test
    void set() {
    }

    @Test
    void remove() {
    }

    @Test
    void testRemove() {
    }

    @Test
    void contains() {
    }

    @Test
    void indexOf() {
    }

    @Test
    void lastIndexOf() {
    }

    @Test
    void get() {
    }

    @Test
    void size() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void clear() {
    }

    @Test
    void toArray() {
    }
}