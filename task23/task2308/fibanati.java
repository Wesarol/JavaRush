package com.javarush.task.task23.task2308;

import java.math.BigDecimal;
import java.math.BigInteger;

public class fibanati {
    public static void main(String[] args) {
       // System.out.println(fib(6));
        System.out.println(fibpro(1000000));
        int i=0;
        BigInteger bigInteger=new BigInteger(String.valueOf(i));

    }


    public  static long fib(int b){
        //2^n
if(b<=1){
    return b;
}

long s1=fib(b-1);
        System.out.println(s1+" s1");
   long s2=     fib(b-2);
        System.out.println(s2+" s2");
long s3=s1+s2;
        System.out.println(s3+" s3");
return s3;
    }
    //O(n)
    public static long fibpro(int n){
        //O(n)
        long [] arr=new long[n+1];
        arr[0]=0;//0(1);
        arr[1]=1;
        //n= 4 =>3
        for (int i = 2; i <= n; i++) {
            arr[i]=arr[i-1]+arr[i-2];
        }
        //O(n+1) => )(2n)=>O(n)
        return arr[n];//o(1)
    }
}
