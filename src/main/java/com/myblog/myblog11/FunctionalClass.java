package com.myblog.myblog11;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionalClass {
    //Ex=1 For checking the length
//    public static void main(String[] args) {
//       Function<String,Integer> result = str->str.length();
//        Integer val = result.apply("mike");
//        System.out.println(val);
//    }
    //Ex=2 for increment val by 10
//public static void main(String[] args) {
//    Function<Integer,Integer> result = i->i+10;
//    Integer val=result.apply(30);
//    System.out.println(val);
//}
    //Ex=3 increment val by 10
//public static void main(String[] args) {
//    List<Integer> data= Arrays.asList(10,20,40,50);
//    List<Integer> val = data.stream().map(i -> i + 10).collect(Collectors.toList());
//    System.out.println(val);
//}
    //ex=4 For converting every characters to Upper case
//    public static void main(String[] args) {
//        List<String> data = Arrays.asList("mike","stallin","adma");
//        List<String> val = data.stream().map(i -> i.toUpperCase()).collect(Collectors.toList());
//        System.out.println(val);
//    }
    //Ex=5 for sorting of data
    public static void main(String[] args) {
        List<String> data = Arrays.asList("mike", "stallin", "adam");
        List<String> val = data.stream().sorted().collect(Collectors.toList());
        System.out.println(val);

    }
}
