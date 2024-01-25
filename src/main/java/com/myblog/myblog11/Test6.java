package com.myblog.myblog11;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test6 {
    public static void main(String[] args) {
        List<Employee> x= Arrays.asList (
                new Employee("mike",30,"chennai"),
                new Employee("stallin",25,"chennai"),
                new Employee("adam",34,"pune"),
                new Employee("sam",34,"banglore")
        );

        Map<Integer, List<Employee>> collect = x.stream().collect(Collectors.groupingBy(e -> e.getAge()));

        for (Map.Entry<Integer,List<Employee>> entry : collect.entrySet()){
            int age=entry.getKey();
            System.out.println("age"+age+":..");
            List<Employee> employeesWithAge = entry.getValue();
            for (Employee e:employeesWithAge){
                System.out.println(e.getName());
                System.out.println(e.getCity());
            }

        }
    }
}
