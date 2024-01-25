package com.myblog.myblog11;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerFunctionalInterface {

//    public static void main(String[] args) {
//        Consumer<Integer> result=number-> System.out.println(number);
//        result.accept(100);
//    }
public static void main(String[] args) {
    List<String> names= Arrays.asList("mike","adam","stallin");
    Consumer<String> val = name-> System.out.println(name);
    names.forEach(val);
}
}
