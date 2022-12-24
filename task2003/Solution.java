package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/

public class Solution {
    //Нужен объект Properties
    //Properties prop = new Properties();
    //
    //Считать из потока так:
    //prop.load(inputStream);
    //
    //Properties -> Map в одну строчку:
    //prop.forEach( (k, v) -> properties.put( (String)k, (String)v) );
    //
    //Map -> Properties
    //prop.putAll(properties);
    //
    //Properties-> outputStream
    //prop.store(outputStream, "");

    public static Map<String, String> runtimeStorage = new HashMap<>();
    public static Properties properties ;

    public static void save(OutputStream outputStream) throws Exception {
        //напишите тут ваш код
        Properties prop =new Properties();
        for(Map.Entry<String ,String > map:runtimeStorage.entrySet()){
            prop.put(map.getKey().toString(),map.getValue().toString());
        }
        prop.putAll(runtimeStorage);
prop.store(outputStream,"");
outputStream.close();
    }

    public static void load(InputStream inputStream) throws IOException {
        //напишите тут ваш код
        Properties prop=new Properties();
        prop.load(inputStream);
        prop.forEach((k,v)->runtimeStorage.put((String)k,(String)v));
        inputStream.close();




    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fos = new FileInputStream(reader.readLine())) {
            load(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(runtimeStorage);
    }
}
