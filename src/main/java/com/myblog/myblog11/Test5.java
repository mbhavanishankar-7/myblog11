package com.myblog.myblog11;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Task is to filter out even numbers,square each of them,and sum of the number
public class Test5 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10,20,30,5);
        List<Integer> data = numbers.stream().filter(n1 -> n1 % 2 == 0).map(n2 -> n2 * n2).collect(Collectors.toList());
        System.out.println(data);
    }

}
