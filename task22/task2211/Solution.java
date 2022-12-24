package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* 
Смена кодировки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //Charset charset=Charset.forName("Windows-1251");
       // Charset charset1=Charset.forName("UTF-8");
       try(BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1]),StandardCharsets.UTF_8));BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(new FileInputStream(args[0]),"Windows-1251"))) {
           while (bufferedReader.ready()){
               bufferedWriter.write(bufferedReader.readLine()+"\n");
           }
       }
    }
}
