package com.javarush.task.task23.task2307;

/* 
Как выбрать нужное?
*/

public class Solution {
    public static final String TEST = "test";

    public static class TEST {
        @Override
        public String toString() {
            return "test class";
        }
    }

    static Object obj;

    public static void main(String[] args) {
        //Solution solution=new Solution();
        Solution.TEST test=new TEST();

        obj = test;
        System.out.println(obj);
    }
}
