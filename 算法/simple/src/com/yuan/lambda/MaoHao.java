package com.yuan.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @module:
 * @description:
 * @author: yuan_boss
 * @create: 2022-07-29 14:36
 **/
public class MaoHao {
    public static void  printValur(User user){
        System.out.println("print value : "+user.getName());
    }
    public  void  printValur2(User user){
        System.out.println("print value2 : "+user.getName());
    }
    public  void  printValurStr(String s){
        System.out.println("你好啊");
    }


    public static void main(String[] args) {
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
/*        users.forEach(user -> MaoHao.printValur(user.getName()));*/
/*        users.forEach(MaoHao::printValur);
        users.forEach(new MaoHao()::printValur2);*/

        Consumer<User> printValur = new MaoHao()::printValur2;
/*        users.forEach(user11xxx->printValur.accept(user11xxx));*/
        users.forEach(user->hello(user.getName()));
        List<String> strs = Arrays.asList("a","b","c");
        strs.forEach( MaoHao::hello);
        List<String> collected = new ArrayList<>();
        collected.add("alpha");
        collected.add("beta");
        collected = collected.stream().map(String::toUpperCase).collect(Collectors.toCollection(ArrayList::new));//注意发生的变化
/*        System.out.println(collected);*/
    }
    public  static void hello(String s){
        System.out.println("你好啊"+s);
    }
}
