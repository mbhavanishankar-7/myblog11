package com.myblog.myblog11;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PredicateClass {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 12, 1, 5, 16, 19, 20);
        List<Integer> evenNumbers = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println(evenNumbers);
    }
}
