package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/

public class Solution implements Serializable {


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FileOutputStream fos = new FileOutputStream("temp");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        FileInputStream fis = new FileInputStream("temp");
        ObjectInputStream ois = new ObjectInputStream(fis);

        Solution savedObject = new Solution(34);
        oos.writeObject(savedObject);

        Solution loadedObject = (Solution) ois.readObject();

        System.out.println(savedObject);
        System.out.println(loadedObject);

        if (savedObject.toString().equals(loadedObject.toString()))
            System.out.println("true");
        else
            System.out.println("false");
    }

        private transient   final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private  transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    public Solution() {
    }

    @Override
    public String toString() {
        return this.string;
    }
}