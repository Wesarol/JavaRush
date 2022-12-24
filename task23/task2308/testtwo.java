package com.javarush.task.task23.task2308;

import java.util.Arrays;

public class testtwo {
    public static void main(String[] args) {
int [] has=new int[]{1,2,5,4,5,1,7,11,9,10};

        //System.out.println(binarySearch(has,77));
        System.out.println(binarySearch(has,2,0,has.length-1));
        System.out.println(binarySearch(has,5,0,has.length-1));
        System.out.println(binarySearch(has,6,0,has.length-1));
        System.out.println(binarySearch(has,8,0,has.length-1));
        System.out.println(binarySearch(has,0,0,has.length-1));
    }


        public static int binarySearch ( int[] a, int key){
int low=0;
int hight=a.length-1;
while (low<hight){
    int middle=low+(hight-low)/2;

    if (a[middle]>key){
        hight=middle;
    }
    else if(a[middle]<key){
        low=middle;
    }
    else return middle;
}
        return -1;
    }
    public static int binarySearch(int [] sortedArray ,int key ,int low,int hegh){
        int midell=low+(hegh-low)/2;
        if (sortedArray[midell]==key) {
            return midell;
        }
            if (low==hegh){
                return -1;
        }
            return key>sortedArray[midell]?binarySearch(sortedArray,key,midell,hegh):binarySearch(sortedArray,key,low,midell);
    }




    }

