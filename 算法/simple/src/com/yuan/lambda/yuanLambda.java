package com.yuan.lambda;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @module:
 * @description:
 * @author: yuan_boss
 * @create: 2022-07-28 17:23
 **/
public class yuanLambda {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1a");
        list.add("2");
        list.add("3a");
        list.add("4");
        list.stream().filter(str -> str.isEmpty()).collect(Collectors.toList()).forEach(System.out::println);
        list.stream().filter(String::isEmpty).collect(Collectors.toList()).forEach(System.out::println);
/*        System.out.println(a);*/
        System.out.println("===================================");
        User user1 = new User();
        user1.setName("小明");
        user1.setAge(3);
        User user2 = new User();
        user2.setName("小明");
        user2.setAge(3);
        User user3 = new User();
        user3.setName("小红");
        user3.setAge(3);

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
/*        List<User> userList = users.stream().distinct().collect(Collectors.toList());
        userList.forEach(System.out::println);*/

        //users.stream().filter(user -> user.getName().equals("小明")).collect(Collectors.toList()).forEach(System.out::println);

       //users.stream().limit(2).distinct().collect(Collectors.toList()).forEach(System.out::println);

        /*去除前几个元素*/
        //users.stream().skip(2).forEach(System.out::println);
/*        users.stream().map(user -> user).collect(Collectors.toList()).forEach(System.out::println);*/

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();

        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());


        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        System.out.println(strings.stream().filter(s-> !s.isEmpty()).collect(Collectors.joining("->")));

        List<Integer> numberss = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        // 获取对应的平方数
      // List<Integer> squaresList = numberss.stream().map( i -> i*i).distinct().collect(Collectors.toList());
        List<Integer> squaresList = numberss.stream()
                .map(i -> i * i)
                .sorted((x, y) -> y - x)
                .collect(Collectors.toList());
        System.out.println(squaresList);
        squaresList.forEach(num -> {
            num += 2;
            System.out.println(num);
        });

        System.out.println("===============================================================");
        List<String> strList = Arrays.asList("a", "ba", "bb", "abc", "cbb", "bba", "cab");
        Map<Integer, String> strMap = new HashMap<Integer, String>();
        AtomicInteger i = new AtomicInteger();
        strMap = strList.stream()
                .collect( Collectors.toMap( str ->i.getAndIncrement(), str -> str ) );

        strMap.forEach((key, value) -> {
            System.out.println(key+"::"+value);
        });

        String[] strings1 = new String[]{"1","2","6","3"};
        Stream<String> stream = Arrays.stream(strings1);
        System.out.println(stream.sorted().collect(Collectors.joining("->")));

        System.out.println(users.stream().map(User::getName).collect(Collectors.joining("->")));


        Function< String, String> func = String::toUpperCase;
        String abc = func.apply("abc");
        System.out.println(abc);
    }

    private static String getMergedStringUsingJava7(List<String> strings, String separator){
        StringBuilder stringBuilder = new StringBuilder();

        for(String string: strings){

            if(!string.isEmpty()){
                stringBuilder.append(string);
                stringBuilder.append(separator);
            }
        }
        String mergedString = stringBuilder.toString();
        return mergedString.substring(0, mergedString.length()-1);
    }
}
