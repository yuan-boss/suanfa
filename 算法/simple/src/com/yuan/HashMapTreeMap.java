package com.yuan;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @module:
 * @description:
 * @author: yuan_boss
 * @create: 2022-07-23 14:44
 **/
public class HashMapTreeMap {

    public static class Node{
        int value;
        public Node(int v){
            value = v;
        }
    }


    public static void main(String[] args) {


        HashMap<String,String > map = new HashMap<>();
        map.put("1","我是1");
        map.put("2","我是2");
        map.put("3","我是3");
        String one = "1";
        System.out.println(map.get("1"));
        System.out.println(map.get(one));
        map.put(one,"他是1");
        System.out.println(map.get("1"));
        System.out.println(map.get("3"));
        String remove = map.remove("3");
        System.out.println("移除结果"+remove);
        System.out.println(map.get("3"));

        HashMap<Node,String> map2 = new HashMap<>();
        Node node = new Node(1);
        Node node2 = new Node(2);
        map2.put(node,"节点1");
        map2.put(node2,"节点2");
        System.out.println(map2.get(node));
        System.out.println(map2.get(node2));

        TreeMap<Integer,String> treeMap = new TreeMap<>();
        treeMap.put(1,"a");
        treeMap.put(2,"b");
        treeMap.put(3,"c");
        System.out.println(treeMap.firstKey());
        System.out.println(treeMap.floorKey(5));
    }
}
