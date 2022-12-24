package com.javarush.task.task22.task2209;

import javax.annotation.processing.SupportedSourceVersion;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/* 
Составить цепочку слов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        {fileName = reader.readLine();}

        String content = new String(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8);
        String[] words = content.split(" ");
//C:\Java\JavaRushTasks\3.JavaMultithreading\src\com\javarush\task\task22\task2206\Текстовый документ.txt
        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder stringBuilder=new StringBuilder();
        if(words==null||words.length==0) return stringBuilder;
        if(words[0].equals("")&& words.length==1) return stringBuilder;

        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(words));

        while (isYes((ArrayList<String>) list)){
            Collections.shuffle(list);
        }

        for (String s:list){
            stringBuilder.append(s+" ");
        }
        stringBuilder.toString().trim();
        return stringBuilder;
    }
    public static boolean isYes(ArrayList<String> list){
        for (int i = 0; i < list.size()-1; i++) {
            String first=list.get(i).toLowerCase();
            String second=list.get(i+1).toLowerCase();
            if(first.charAt(first.length()-1)!=second.charAt(0)) return true;
        }
        return false;
    }

}