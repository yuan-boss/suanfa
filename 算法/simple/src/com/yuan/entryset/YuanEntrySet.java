package com.yuan.entryset;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @module:
 * @description:
 * @author: yuan_boss
 * @create: 2022-07-30 08:11
 **/
public class YuanEntrySet {


    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(0,"第一");
        map.put(1,"第二");
        map.put(2,"第三");
        for (int i = 0; i < map.size(); i++) {
            String s = map.get(i);
            System.out.println(s);
        }
        System.out.println("======================");
        for (Map.Entry<Integer,String> entry : map.entrySet()){
            System.out.println(entry.getValue());
        }

    }
}
