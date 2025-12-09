package org.example;


import java.util.HashMap;
import java.util.LinkedList;

public class Main {
    static void main(String[] args) {
        MyHashMap<Integer,Integer> nums = new MyHashMap<>();

        nums.put(1,12);
        nums.put(2,54);
        nums.put(3,26);

        //System.out.println(nums.peek());
        System.out.println(nums.get(1));
        System.out.println(nums.size());

        nums.remove(1);

        //System.out.println(nums.pop());
        System.out.println(nums.get(3));
        System.out.println(nums.size());

        nums.clear();


        //System.out.println(nums.pop());
        //System.out.println(nums.peek());

        System.out.println(nums.size());
    }
}
