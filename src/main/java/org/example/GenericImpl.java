package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericImpl<T> {

    //    Написать Generic метод  List makeList(T[] t), который преобразует массив в список
    public static <T> List<T> makeList(T[] t) {
        return new ArrayList<>(List.of(t));
    }


    //    Написать Generic метод  T[] makeArray(List list), который преобразует список в массив
    //    (Возможно ли это?)
    public static <T> T[] makeArray(List<T> list) {
        try {
            T[] arr = (T[]) Array.newInstance(Object.class, list.size());
            for (int i = 0; i < list.size(); i++) {
                arr[i] = list.get(i);
            }
            return arr;
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
    }
}
