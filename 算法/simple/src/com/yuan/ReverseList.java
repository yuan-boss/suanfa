package com.yuan;

import java.util.LinkedList;

/**
 * @module:
 * @description:
 * @author: yuan_boss
 * @create: 2022-07-26 10:03
 **/
public class ReverseList {




        /*单链表*/
        public static class Node<V> {
        public V value;
        public Node<V> next;

        public Node(V data) {
            value = data;
        }
    }
        /*双链表*/
        public static class DoubleNode<V>{
            public V value;
            public DoubleNode<V> next;
            public DoubleNode<V> last;

            public DoubleNode(V data){
                value = data;
            }
        }

        /*单链表实现队列*/
        public static class MyQueue<V>{
            private Node<V> head;
            private Node<V> tail;
            private int size;

            public MyQueue(){
                head = null;
                tail = null;
                size = 0;
            }

            /*队列是否为空*/
            public boolean isEmpty(){
                return size == 0;
            }

            /*队列大小*/
            public int size(){
                return size;
            }


            /*入队列*/
            public void offer(V value){
                Node<V> cur = new Node<>(value);
                if (tail == null){
                    head = cur;
                    tail = cur;
                }else {
                    tail.next = cur;
                    tail = cur;
                }
                size++;
            }

            /*弹出队列*/
            public V poll(){
                V ans = null;
                if (head != null){
                    ans = head.value;
                    head = head.next;
                    size--;
                }
                if(head == null){
                    tail = null;
                }

                return ans;
            }

            /*获取头部数据，不会弹出*/
            public V peek(){
                V ans = null;
                if (head != null){
                    ans = head.value;
                }
                return ans;
            }

        }

        /*单链表实现栈*/
        public static class MyStack<V>{
            private Node<V> head;
            private int size;

            public MyStack(){
                head = null;
                size = 0;
            }

            public boolean isEmpty(){
                return size == 0 ;
            }

            public int size(){
                return size;
            }

            /*入栈*/
            public void push(V value){
                Node<V> cur = new Node<>(value);
                if (head == null){
                    head = cur;
                }else{
                    cur.next = head;
                    head = cur;
                }
                size++;
            }

            /*出栈*/
            public V pop(){
                V ans = null;
                if (head != null){
                    ans = head.value;
                    head = head.next;
                }
                size--;
                return ans;
            }

            /*获取栈顶元素，不出栈*/
            public V peek(){
                return head != null ? head.value : null;
            }
        }

        /*双链表实现双端队列*/
        public static class MyDeque<V>{
            private DoubleNode<V> head;
            private DoubleNode<V> tail;
            int size;

            public MyDeque(){
                head = null;
                tail = null;
                size = 0;
            }
            public boolean isEmpty(){
                return size == 0;
            }

            public int size(){
                return size;
            }

            /*从头部加*/
            public void pushHead(V value){
                DoubleNode<V> cur = new DoubleNode<>(value);
                if (head == null){
                    head = cur;
                    tail = cur;
                }else {
                    cur.next = head;
                    head.last = cur;
                    head = cur;
                }
                size++;

            }
            /*从尾部加*/
            public void pushTail(V value){
                DoubleNode<V> cur = new DoubleNode<>(value);
                if (head == null){
                    head = cur;
                    tail = cur;
                }else {
                    tail.next = cur;
                    cur.last = tail;
                    tail = cur;
                }
                size++;
            }

            /*从头部弹出*/
            public V pollHead(){
                V ans = null ;
                if (head == null){
                    return ans;
                }
                size--;
                ans = head.value;
                if (head == tail){
                    head = null;
                    tail = null;
                }else {
                    head = head.next;
                    head.last = null;
                }
                return ans;
            }

            /*从尾部弹出*/
            public V pollTail(){
                V ans = null;
                if (head == null){
                    return ans;
                }
                size--;
                ans = tail.value;
                if (head == tail){
                    head = null;
                    tail = null;
                } else{
                    tail = tail.last;
                    tail.next = null;
                }
                return ans;
            }
        }


        /*单链表反转*/
        public static Node reverseLinkedList(Node head) {
            Node pre = null;
            Node next = null;

            while (head != null){
                next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }
            return pre;
        }
        /*双链表反转*/
        public static DoubleNode reverseLinkedList(DoubleNode head) {
            DoubleNode pre = null;
            DoubleNode next = null;

            while (head != null){
                next = head.next;
                head.next = pre;
                head.last = next;
                pre = head;
                head = next;
            }
            return pre;
        }



        public static void main(String[] args) {
            Node n1 = new Node(1);
            n1.next = new Node(2);
            n1.next.next = new Node(3);
            n1 = reverseLinkedList(n1);

            while (n1 != null){
                System.out.print(n1.value + " ");
                n1 = n1.next;
            }
            System.out.println();
        }



}
