package com.myblog.myblog;

import javax.persistence.criteria.CriteriaBuilder;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestJava2 {
    public static void main(String[] args) {
//        List<Integer> numbers = Arrays.asList(12,32,11,44,10);
//       List<Integer> evenNum =  numbers.stream().filter(n-> n%2==0).collect(Collectors.toList());
//        System.out.println(evenNum);

//        List<Integer> num = Arrays.asList(23,33,22,43,33,88);
//        List<Integer> res1 = num.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
//        List<Integer> res2 = num.stream().filter(n->n%2!=0).collect(Collectors.toList());
//        List<Integer> res3 = num.stream().filter(n->n<30).collect(Collectors.toList());
//        System.out.println(res1);
//        System.out.println(res2);
//        System.out.println(res3);
        List<String> Heros = Arrays.asList("rajesh","saktiman","hulk","ram");
        List<String> res1 = Heros.stream().filter(s -> s.equals("hulk")).collect(Collectors.toList());
        List<String> res2 = Heros.stream().filter(s -> s.startsWith("r")).collect(Collectors.toList());
        List<String> res3 = Heros.stream().filter(s -> s.endsWith("m")).collect(Collectors.toList());
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);

    }
}
