package com.javarush.task.task22.task2208;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> paramsMap = new LinkedHashMap<>();
        paramsMap.put("name", "Ivanov");
        paramsMap.put("country", "Ukraine");
        paramsMap.put("city", "Kiev");
        paramsMap.put("age", null);

        System.out.println(getQuery(paramsMap));
    }

    public static String getQuery(Map<String, String> params) {
      StringBuilder stringBuilder=new StringBuilder();
      for(String s: params.keySet()){
          String res=params.get(s);
          if(res==null){
              continue;
          }
          if(stringBuilder.toString().length()!=0){
              stringBuilder.append(" and ");
          }
          stringBuilder.append(s+" = '"+res+"'");
      }
      return stringBuilder.toString();
    }
}
