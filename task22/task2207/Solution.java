package com.javarush.task.task22.task2207;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        List<String > list=new ArrayList<>();
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader1=new BufferedReader(new FileReader(bufferedReader.readLine()));
        while (bufferedReader1.ready()){
            list.addAll(Arrays.asList(bufferedReader1.readLine().split(" ")));
        }
        bufferedReader1.close();
        bufferedReader.close();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if(i>=list.size()){
                    break;
                }
                if((list.get(j).equals((new StringBuilder(list.get(i))).reverse().toString()))&& i!=j){
    Pair pair=new Pair();
    pair.first=list.get(j);
    pair.second=list.get(i);
    result.add(pair);
    list.remove(i);
    list.remove(j);
    j=0;
                }
                else {
                    j++;
                }
            }

        }
        System.out.println(result);
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
