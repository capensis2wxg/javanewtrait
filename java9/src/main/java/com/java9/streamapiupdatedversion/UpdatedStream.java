package com.java9.streamapiupdatedversion;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author wxg
 * @date 2022/5/25-17:19
 * @quotes 小不忍则乱大谋
 */
public class UpdatedStream {
    public static void main(String[] args) {

    }

    //java9新特性十：Stream API的加强
    @Test
    public void test1(){
        List<Integer> list = Arrays.asList(23, 43, 45, 55, 61, 54, 32, 2, 45, 89, 7);
        //  takeWhile 返回从开头开始的按照指定规则尽量多的元素
        list.stream().takeWhile(x -> x < 60).forEach(System.out::println);
        //  dropWhile():与 takeWhile 相反，返回剩余的元素。
        list.stream().dropWhile(x -> x < 60).forEach(System.out::println);
    }

    @Test
    public void test2(){
        //  of()参数中的多个元素，可以包含null值
        Stream<Integer> stream1 = Stream.of(1, 2, 3,null);
        stream1.forEach(System.out::println);
        /*  of()参数不能存储单个null值。否则，报异常
         Stream<Object> stream2 = Stream.of(null);
          stream2.forEach(System.out::println);
         */
        Integer i = 10;
        i = null;
        //ofNullable()：形参变量是可以为null值的单个元素
        Stream<Integer> stream3 = Stream.ofNullable(i);
        long count = stream3.count();
        System.out.println(count);
    }

    @Test
    public void test3(){
        Stream.iterate(0,x -> x + 1).limit(10).forEach(System.out::println);
        //java9中新增的重载的方法
        Stream.iterate(0,x -> x < 100,x -> x + 1).forEach(System.out::println);
    }

    //java9新特性十一：Optional提供了新的方法stream()
    @Test
    public void test4(){
        List<String> list = new ArrayList<>();
        list.add("Tom");
        list.add("Jerry");
        list.add("Tim");
        Optional<List<String>> optional = Optional.ofNullable(list);
        Stream<List<String>> stream = optional.stream();
        /*  long count = stream.count();
         System.out.println(count);
         */
        stream.flatMap(Collection::stream).forEach(System.out::println);

    }

}
