package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Integer[] arr1 = new Integer[]{1, 25, 45, 7, 10};
        String[] arr2 = new String[]{"da", "ku", "re", "po"};
        Person[] arr3 = new Person[]{new Person("Serhii", 35), new Person("Natalia", 23), new Person("Vita", 48)};

        System.out.println(GenericImpl.makeList(arr1));
        System.out.println(GenericImpl.makeList(arr2));
        System.out.println(GenericImpl.makeList(arr3));
        System.out.println("________________________");


        List<Integer> list1 = Arrays.asList(1, 23, 5);
        List<String> list2 = Arrays.asList("S", "T", "Lu", "Ru", "V", "C");
        List<Person> list3 = Arrays.asList(new Person("Petia", 25), new Person("Filip", 18), new Person("Maria", 33));


        System.out.println(Arrays.toString(GenericImpl.makeArray(list1)));
        System.out.println(Arrays.toString(GenericImpl.makeArray(list2)));
        System.out.println(Arrays.toString(GenericImpl.makeArray(list3)));


        System.out.println("________________________");
        System.out.println(Checker.check("nata123_87_mn12", "12345678NW_", "12345678NW_"));
    }
}
