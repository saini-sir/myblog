package com.myblog.myblog;
import java.awt.*;
import java.util.Objects;
import java.util.function.Predicate;

public class ClassForTest {
    public static void main (String [] args ){
//        Predicate<Long> var = y-> y%2==0;
//        boolean result = var.test(10L);
//        System.out.println(result);
        Predicate<Integer> var = y -> y%2 == 0;
        boolean result = var.test(30);
        System.out.println(result);
    }
}
