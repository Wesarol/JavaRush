package com.javarush.task.task21.task2101;

/* 
Определяем адрес сети
*/

public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {

        byte  newbyte1= (byte) (ip[0] & mask[0]);
        byte  newbyte2= (byte) (ip[1] & mask[1]);
        byte  newbyte3= (byte) (ip[2] & mask[2]);
        byte  newbyte4= (byte) (ip[3] & mask[3]);
        byte [] byte5=new byte[]{newbyte1,newbyte2,newbyte3,newbyte4};

        return byte5;
    }

    public static void print(byte[] bytes) {
        String bbb;
        for (byte b:bytes){
           bbb= Integer.toBinaryString(b&255);
           String finall=String.format("%8s",bbb);
            System.out.print(finall.replace(" ","0")+" ");

            //System.out.println(bbb.substring(bbb.length()-8)+" ");

        }
        System.out.println();
    }
}
