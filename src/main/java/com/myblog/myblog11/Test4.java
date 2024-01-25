package com.myblog.myblog11;

import com.myblog.myblog11.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test4 {
    public static void main(String[] args) {
        List<Employee> x=Arrays.asList (
                new Employee("mike",30,"chennai"),
                new Employee("stallin",25,"chennai"),
                new Employee("adam",34,"pune"),
                new Employee("sam",34,"banglore")
                );
        List<Employee> emps = x.stream().filter(emp -> emp.getAge() > 30).collect(Collectors.toList());

        for(Employee e:emps){
            System.out.println(e.getName());
            System.out.println(e.getCity());
            System.out.println(e.getAge());
        }
    }


}
