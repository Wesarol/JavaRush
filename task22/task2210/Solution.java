package com.javarush.task.task22.task2210;

import java.util.StringTokenizer;

/* 
StringTokenizer
*/

public class Solution {
    public static void main(String[] args) {
getTokens("level22.lesson13.task01", ".");
    }

    public static String[] getTokens(String query, String delimiter) {
        int i=0;
        StringTokenizer stringTokenizer = new StringTokenizer(query, delimiter);
        String[] token=new String[stringTokenizer.countTokens()];
        while (stringTokenizer.hasMoreTokens()){
            token[i++]=stringTokenizer.nextToken();
        }
        return token;
    }
}
