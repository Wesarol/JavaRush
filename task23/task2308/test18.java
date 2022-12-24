package com.javarush.task.task23.task2308;

import java.util.Arrays;

public class test18 {

    public static void main(String[] args) {



        System.out.println(isIsogram("aba"));

        //assertEquals(true, isogram.isIsogram("Dermatoglyphics"));
        //        assertEquals(true, isogram.isIsogram("isogram"));
        //        assertEquals(false, isogram.isIsogram("moose"));
        //        assertEquals(false, isogram.isIsogram("isIsogram"));
        //        assertEquals(false, isogram.isIsogram("aba"));
        //        assertEquals(false, isogram.isIsogram("moOse"));
        //        assertEquals(true, isogram.isIsogram("thumbscrewjapingly"));
        //        assertEquals(true, isogram.isIsogram(""));
    }

        public static boolean  isIsogram(String str) {
            String [] s1=str.toLowerCase().split("");
            System.out.println(Arrays.toString(s1));
            int num=0;
            for (int i = 0; i < s1.length-1 ; i++) {
                for (int j = i+1; j <s1.length ; j++) {
                    if(s1[i].equals(s1[j])){
                       return false;

                    }
                }
            }


            return true;
        }
    }
