package com.javarush.task.task23.task2305;

/* 
Inner
*/

public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {

    }

    public static Solution[] getTwoSolutions() {
        Solution [] solutions=new Solution[2];
        solutions[0]=new Solution();
        solutions[1]=new Solution();

        Solution solution=new Solution();
        solution.innerClasses[0]=solution.new InnerClass();
        solution.innerClasses[1]=solution.new InnerClass();

        Solution solution1=new Solution();
        solution1.innerClasses[0]=solution1.new InnerClass();
        solution1.innerClasses[1]=solution1.new InnerClass();
        solutions[0]=solution;
        solutions[1]=solution1;

        return solutions;
    }

    public static void main(String[] args) {

    }
}
