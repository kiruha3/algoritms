package com.stringlist.stringlist.stringlist;

import com.stringlist.stringlist.selfexeption.FulllistExeption;
import com.stringlist.stringlist.selfexeption.IndexOfExeption;
import com.stringlist.stringlist.stringlist.utils.Generate;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringListImplTest {
    public final StringListImpl stringListImpl = new StringListImpl();
    public final Generate generate = new Generate();

    @Test
    void addItem_success() {
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
    void addItem_FulllistExeption() {
    //        //Подготовка входных данных
    //        int size = 1;
    //        String[] arrayTest = new String[1];
    //        String item = "тест";
    //        arrayTest[0] = item;
    //
    //        String expected = "good";
    //        if (arrayTest[size-1] == null) {
    //            arrayTest[1] = item;
    //        } else {
    //            expected = "Введенный index вне диапазона";
    //        }
    //        //Подготовка ожидаемого результата
    //
    //        //Начало теста
    //        StringList stringList = new StringListImpl(1);
    //        stringList.add(item);
    //        Exception exception = assertThrows(
    //                FulllistExeption.class,
    //                () -> stringList.add(item)
    //        );
    //        assertEquals(expected, exception.getMessage());
    }

    @Test
    void addItem_ItemofExeption() {
    }

    @Test
    void addItem_validateIndex() {
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
        for (int i = arrayTest.length - 1; i > index; i--) {
            arrayTest[i] = arrayTest[i - 1];
        }
        arrayTest[index] = item;
        String expectedItemInArray = arrayTest[index];
        //Начало теста
        StringList stringList = new StringListImpl(4);
        stringList.add("тест1");
        stringList.add("тест2");
        stringList.add("тест3");
        stringList.add(index, item);
        String actualItemInArray = stringList.get(index);
        assertEquals(expectedItemInArray, actualItemInArray);
    }

    @Test
    void set_success() {
        //Подготовка входных данных
        int size = 4;
        String[] arrayTest = new String[4];
        String item = "тест";
        int index = 2;
        //Подготовка ожидаемого результата
        arrayTest[0] = "тест1";
        arrayTest[1] = "тест2";
        arrayTest[2] = "тест3";
        arrayTest[2] = item;
        String expectedItemInArray = arrayTest[index];
        //Начало теста
        StringList stringList = new StringListImpl(4);
        stringList.add("тест1");
        stringList.add("тест2");
        stringList.add("тест3");
        stringList.set(index, item);
        String actualItemInArray = stringList.get(2);
        assertEquals(expectedItemInArray, actualItemInArray);
    }

    @Test
    void removeIndex() {
        //Подготовка входных данных
        int size = 4;
        String[] arrayTest = new String[size];
        StringList stringList = new StringListImpl(size);
        String item = "тест2";
        int index = 1;
        //Подготовка ожидаемого результата
        arrayTest[0] = "тест1";
        arrayTest[1] = "тест2";
        arrayTest[2] = "тест3";
        arrayTest[3] = "тест4";

        stringList.add("тест1");
        stringList.add("тест2");
        stringList.add("тест3");
        stringList.add("тест4");
        System.arraycopy(arrayTest, index + 1, arrayTest, index, size - index - 1);
        size--;
        arrayTest[size] = null;
        String expectedItemInArray = arrayTest[index];
        //Начало теста

        stringList.remove(index);
        String actualItemInArray = stringList.get(index);
        assertEquals(expectedItemInArray, actualItemInArray);
    }

    @Test
    void removeItem() {
        //Подготовка входных данных
        int size = 4;
        String[] arrayTest = new String[size];
        StringList stringList = new StringListImpl(size);
        String item = "тест2";

        //Подготовка ожидаемого результата
        arrayTest[0] = "тест1";
        arrayTest[1] = "тест2";
        arrayTest[2] = "тест3";
        arrayTest[3] = "тест4";
        int index = generate.indexOf(item, arrayTest);
//        index=arrayTest.indexOf
        stringList.add("тест1");
        stringList.add("тест2");
        stringList.add("тест3");
        stringList.add("тест4");
        System.arraycopy(arrayTest, index + 1, arrayTest, index, size - index - 1);
        size--;
        arrayTest[size] = null;
        String expectedItemInArray = arrayTest[index];
        //Начало теста

        stringList.remove(item);
        String actualItemInArray = stringList.get(index);
        assertEquals(expectedItemInArray, actualItemInArray);
    }

    @Test
    void contains() {
        //Подготовка входных данных
        int size = 4;
        String[] arrayTest = new String[size];
        StringList stringList = new StringListImpl(size);
        String item = "тест2";
        //Подготовка ожидаемого результата
        arrayTest[0] = "тест1";
        arrayTest[1] = "тест2";
        arrayTest[2] = "тест3";
        arrayTest[3] = "тест4";
//        index=arrayTest.indexOf
        stringList.add("тест1");
        stringList.add("тест2");
        stringList.add("тест3");
        stringList.add("тест4");
        Integer expectedres = generate.indexOf(item, arrayTest);
        //Начало теста
        Integer actualres = stringList.indexOf(item);
        assertEquals(expectedres, actualres);

    }

    @Test
    void indexOf_success() {
        //Подготовка входных данных
        int size = 4;
        String[] arrayTest = new String[size];
        StringList stringList = new StringListImpl(size);
        String item = "тест2";
        int counter = 0;
        //Подготовка ожидаемого результата
        arrayTest[0] = "тест1";
        arrayTest[1] = "тест2";
        arrayTest[2] = "тест3";
        arrayTest[3] = "тест4";

        stringList.add("тест1");
        stringList.add("тест2");
        stringList.add("тест3");
        stringList.add("тест4");
        //Начало теста
        Integer expectedIndex = -1;
        for (String s : arrayTest) {
            if (s.equals(item)) {
                expectedIndex = counter;
                break;
            }
            counter++;
        }
        counter = 0;
        //Начало теста
        Integer ActualIndex = stringList.indexOf(item);
        assertEquals(expectedIndex, ActualIndex);
    }

    @Test
    void lastIndexOf_success() {
        //Подготовка входных данных
        int size = 4;
        String[] arrayTest = new String[size];
        StringList stringList = new StringListImpl(size);
        String item = "тест2";
        int counter = 0;
        //Подготовка ожидаемого результата
        arrayTest[0] = "тест1";
        arrayTest[1] = "тест2";
        arrayTest[2] = "тест3";
        arrayTest[3] = "тест4";

        stringList.add("тест1");
        stringList.add("тест2");
        stringList.add("тест3");
        stringList.add("тест4");
        //Начало теста
        Integer expectedIndex = -1;
        for (int i = arrayTest.length - 1; i >= 0; i--) {
            if (arrayTest[i].equals(item)) {
                expectedIndex = i;
            }
        }
        counter = 0;
        //Начало теста
        Integer ActualIndex = stringList.lastIndexOf(item);
        assertEquals(expectedIndex, ActualIndex);
    }

    @Test
    void get() {
        //Подготовка входных данных
        int size = 4;
        String[] arrayTest = new String[size];
        StringList stringList = new StringListImpl(size);
        int counter = 0;
        //Подготовка ожидаемого результата
        arrayTest[0] = "тест1";
        arrayTest[1] = "тест2";
        arrayTest[2] = "тест3";
        arrayTest[3] = "тест4";

        stringList.add("тест1");
        stringList.add("тест2");
        stringList.add("тест3");
        stringList.add("тест4");
        //Начало теста
        String expectedGet = arrayTest[1];
        String actualGet = stringList.get(1);
        assertEquals(expectedGet, actualGet);
    }

    @Test
    void size_success() {
        //Подготовка входных данных
        int size = 4;
        String[] arrayTest = new String[size];
        StringList stringList = new StringListImpl(size);
        arrayTest[0] = "тест1";
        arrayTest[1] = "тест2";
        arrayTest[2] = "тест3";
        arrayTest[3] = "тест4";

        stringList.add("тест1");
        stringList.add("тест2");
        stringList.add("тест3");
        stringList.add("тест4");
//        //Подготовка ожидаемого результата
        Integer expectedSize = size;
        //Начало теста
        Integer ActualSize = stringList.size();

        assertEquals(expectedSize, ActualSize);
    }

    @Test
    void isEmpty_success() {

        //Подготовка входных данных
        int size = 4;
        String[] arrayTest = new String[size];
        StringList stringList = new StringListImpl(size);
//        arrayTest[0] = "тест1";
//        arrayTest[1] = "тест2";
//        arrayTest[2] = "тест3";
//        arrayTest[3] = "тест4";
//
//        stringList.add("тест1");
//        stringList.add("тест2");
//        stringList.add("тест3");
//        stringList.add("тест4");


//        //Подготовка ожидаемого результата
        Boolean expectedEmpty = true;
        for (int i = 0; i < arrayTest.length; i++) {
            if (arrayTest[i] != null) {
                expectedEmpty = false;
            }
        }
        //Начало теста
        Boolean actualEmpty = stringList.isEmpty();
        assertEquals(expectedEmpty, actualEmpty);

    }

    @Test
    void clear() {
        //Подготовка входных данных
        int size = 4;
        String[] arrayTest = new String[size];
        StringList stringList = new StringListImpl(size);
        arrayTest[0] = "тест1";
        arrayTest[1] = "тест2";
        arrayTest[2] = "тест3";
        arrayTest[3] = "тест4";

        stringList.add("тест1");
        stringList.add("тест2");
        stringList.add("тест3");
        stringList.add("тест4");

        //Подготовка ожидаемого результата
        size = 0;
        arrayTest[0] = null;
        int expectedClear = size;
        //Начало теста
        stringList.clear();
        int actualClear = stringList.size();
        assertEquals(expectedClear, actualClear);


    }

    @Test
    void toArray() {
        int size = 4;
        String[] arrayTest = new String[size];
        StringList stringList = new StringListImpl(size);
        arrayTest[0] = "тест1";
        arrayTest[1] = "тест2";
        arrayTest[2] = "тест3";
        arrayTest[3] = "тест4";

        stringList.add("тест1");
        stringList.add("тест2");
        stringList.add("тест3");
        stringList.add("тест4");
        String expectedtoArray = Arrays.toString(Arrays.copyOf(arrayTest, size));
        //Начало теста
        String actualtoArray = Arrays.toString(stringList.toArray());
        assertEquals(expectedtoArray, actualtoArray);
    }
}