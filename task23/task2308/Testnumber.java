package com.javarush.task.task23.task2308;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Testnumber {
    public static void main(String[] args) {
        int [] stations ={0,200,375,550,750,950};
        System.out.println(minStops(stations,400));
       // int[] digit = {1, 3, 7, 9, 9, 5};
       // System.out.println(maxNumberFromDigits(digit));
    }

    public static String maxNumberFromDigits(int[] digits) {
       return String.join("", Arrays.stream(digits).boxed().
                sorted(Collections.reverseOrder())
                .map(String::valueOf).toArray(String[]::new));
    }
public static int minStops(int [] stations,int capacity){
int result=0;
int stop=0;

while (stop<stations.length-1){
    int nextstop=stop;
    while (nextstop<stations.length-1&& stations[nextstop+1]-stations[stop]<=400){
        nextstop++;
    }
    if(stop==nextstop){
        return -1;
    }
    if(nextstop<stations.length-1){
        result++;
    }
    stop=nextstop;
}


    return result;
}
}


