package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/

public class Solution {
    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) throws TooShortStringException {
        if(string==null){
            throw new TooShortStringException();
        }
        String [] spleatstring= string.split(" ");

        if(spleatstring.length<5){
            throw new TooShortStringException();
        }
StringBuilder stringBuilder=new StringBuilder();

        for (int i = 1; i < 5; i++) {
            stringBuilder.append(spleatstring[i]);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString().trim();
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
