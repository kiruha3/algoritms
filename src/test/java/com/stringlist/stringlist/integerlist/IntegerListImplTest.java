package com.stringlist.stringlist.integerlist;

import com.stringlist.stringlist.stringlist.StringList;
import com.stringlist.stringlist.stringlist.StringListImpl;
import com.stringlist.stringlist.stringlist.utils.Generate;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class IntegerListImplTest {
    public final IntegerList integerList  = new IntegerListImpl();
    public final Generate generate = new Generate();

    @Test
    void add_success() {
        //Подготовка входных данных
        Integer[] arrayTest = new Integer[1];
        Integer item = 1;
        //Подготовка ожидаемого результата
        arrayTest[0] = item;
        Integer expectedItemInArray = arrayTest[0];
        //Начало теста
        IntegerList integerList = new IntegerListImpl(1);
        integerList.add(item);
        Integer actualItemInArray = integerList.get(0);
        assertEquals(expectedItemInArray, actualItemInArray);
    }

    @Test
    void addofIndex_success() {
        //Подготовка входных данных
        int size = 4;
        Integer[] arrayTest = new Integer[4];
        Integer item = 0;
        int index = 2;
        //Подготовка ожидаемого результата
        arrayTest[0] = 1;
        arrayTest[1] = 2;
        arrayTest[2] = 3;
        for (int i = arrayTest.length - 1; i > index; i--) {
            arrayTest[i] = arrayTest[i - 1];
        }
        arrayTest[index] = item;
        Integer expectedItemInArray = arrayTest[index];
        //Начало теста
        IntegerList integerList = new IntegerListImpl(4);
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(index, item);
        Integer actualItemInArray = integerList.get(index);
        assertEquals(expectedItemInArray, actualItemInArray);
    }

    @Test
    void set_success() {
        //Подготовка входных данных
        int size = 4;
        Integer[] arrayTest = new Integer[4];
        Integer item = 0;
        int index = 2;
        //Подготовка ожидаемого результата
        arrayTest[0] = 1;
        arrayTest[1] = 2;
        arrayTest[2] = 3;
        arrayTest[2] = item;
        Integer expectedItemInArray = arrayTest[index];
        //Начало теста
        IntegerList integerList = new IntegerListImpl(4);
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.set(index, item);
        Integer actualItemInArray = integerList.get(2);
        assertEquals(expectedItemInArray, actualItemInArray);
    }

    @Test
    void removeIndex() {
        //Подготовка входных данных
        int size = 4;
        Integer[] arrayTest = new Integer[size];
        IntegerList integerList = new IntegerListImpl(size);
        Integer item = 0;
        int index = 1;
        //Подготовка ожидаемого результата
        arrayTest[0] = 1;
        arrayTest[1] = 2;
        arrayTest[2] = 3;
        arrayTest[3] = 4;

        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        System.arraycopy(arrayTest, index + 1, arrayTest, index, size - index - 1);
        size--;
        arrayTest[size] = null;
        Integer expectedItemInArray = arrayTest[index];
        //Начало теста

        integerList.remove(index);
        Integer actualItemInArray = integerList.get(index);
        assertEquals(expectedItemInArray, actualItemInArray);
    }

    @Test
    void removeItem() {
        //Подготовка входных данных
        int size = 4;
        Integer[] arrayTest = new Integer[size];
        IntegerList integerList = new IntegerListImpl(size);
        Integer item = 2;

        //Подготовка ожидаемого результата
        arrayTest[0] = 1;
        arrayTest[1] = 2;
        arrayTest[2] = 3;
        arrayTest[3] = 4;
        int index = generate.indexOfInt(item, arrayTest);
//        index=arrayTest.indexOf
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        System.arraycopy(arrayTest, index + 1, arrayTest, index, size - index - 1);
        size--;
        arrayTest[size] = null;
        Integer expectedItemInArray = arrayTest[index];
        //Начало а

        integerList.remove(item);
        Integer actualItemInArray = integerList.get(index);
        assertEquals(expectedItemInArray, actualItemInArray);
    }

    @Test
    void contains() {
        IntegerList integerList = new IntegerListImpl(4);

        //Подготовка ожидаемого результата
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        assertTrue(integerList.contains(1));
    }

    @Test
    void indexOf() {
        //Подготовка входных данных
        int size = 4;
        Integer[] arrayTest = new Integer[size];
        IntegerList integerList = new IntegerListImpl(size);
        Integer item = 2;

        //Подготовка ожидаемого результата
        arrayTest[0] = 1;
        arrayTest[1] = 2;
        arrayTest[2] = 3;
        arrayTest[3] = 4;
        int index = generate.indexOfInt(item, arrayTest);
//        index=arrayTest.indexOf
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);

        assertEquals(Collections.binarySearch(Arrays.asList(arrayTest), 1),integerList.indexOf(1));
    }

    @Test
    void lastIndexOf_success() {
        //Подготовка входных данных
        int size = 4;
        Integer[] arrayTest = new Integer[size];
        IntegerList integerList = new IntegerListImpl(size);
        Integer item = 2;
        int counter = 0;
        //Подготовка ожидаемого результата
        arrayTest[0] = 1;
        arrayTest[1] = 2;
        arrayTest[2] = 3;
        arrayTest[3] = 4;

        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        //Начало теста
        Integer expectedIndex = -1;
        for (int i = arrayTest.length - 1; i >= 0; i--) {
            if (arrayTest[i].equals(item)) {
                expectedIndex = i;
            }
        }
        counter = 0;
        //Начало теста
        Integer ActualIndex = integerList.lastIndexOf(item);
        assertEquals(expectedIndex, ActualIndex);
    }


    @Test
    void get() {
        //Подготовка входных данных
        int size = 4;
        Integer[] arrayTest = new Integer[size];
        IntegerList integerList = new IntegerListImpl(size);
        int counter = 0;
        //Подготовка ожидаемого результата
        arrayTest[0] = 1;
        arrayTest[1] = 2;
        arrayTest[2] = 3;
        arrayTest[3] = 4;

        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        //Начало теста
        Integer expectedGet = arrayTest[1];
        Integer actualGet = integerList.get(1);
        assertEquals(expectedGet, actualGet);
    }

    @Test
    void testEquals() {
    }

    @Test
    void size() {
        //Подготовка входных данных
        int size = 4;
        Integer[] arrayTest = new Integer[size];
        IntegerList integerList = new IntegerListImpl(size);
        arrayTest[0] = 1;
        arrayTest[1] = 2;
        arrayTest[2] = 3;
        arrayTest[3] = 4;

        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
//        //Подготовка ожидаемого результата
        Integer expectedSize = size;
        //Начало теста
        Integer ActualSize = integerList.size();

        assertEquals(expectedSize, ActualSize);
    }

    @Test
    void isEmpty_success() {

        //Подготовка входных данных
        int size = 4;
        Integer[] arrayTest = new Integer[size];
        IntegerList integerList = new IntegerListImpl(size);

//        //Подготовка ожидаемого результата
        Boolean expectedEmpty = true;
        for (int i = 0; i < arrayTest.length; i++) {
            if (arrayTest[i] != null) {
                expectedEmpty = false;
            }
        }
        //Начало теста
        Boolean actualEmpty = integerList.isEmpty();
        assertEquals(expectedEmpty, actualEmpty);

    }

    @Test
    void clear() {
        //Подготовка входных данных
        int size = 4;
        Integer[] arrayTest = new Integer[size];
        IntegerList integerList = new IntegerListImpl(size);
        arrayTest[0] = 1;
        arrayTest[1] = 2;
        arrayTest[2] = 3;
        arrayTest[3] = 4;

        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);

        //Подготовка ожидаемого результата
        size = 0;
        arrayTest[0] = null;
        int expectedClear = size;
        //Начало теста
        integerList.clear();
        int actualClear = integerList.size();
        assertEquals(expectedClear, actualClear);


    }

    @Test
    void toArray() {
        //Подготовка входных данных
        int size = 4;
        Integer[] arrayTest = new Integer[size];
        IntegerList integerList = new IntegerListImpl(size);
        arrayTest[0] = 1;
        arrayTest[1] = 2;
        arrayTest[2] = 3;
        arrayTest[3] = 4;
        //Подготовка ожидаемого результата
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        String expectedtoArray = Arrays.toString(Arrays.copyOf(arrayTest, size));
        //Начало теста
        String actualtoArray = Arrays.toString(integerList.toArray());
        assertEquals(expectedtoArray, actualtoArray);
    }
}