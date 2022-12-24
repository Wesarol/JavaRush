package com.javarush.task.task23.task2308;

public class ff {
    public class SpinWords {

        public String spinWords(String sentence) {
            //TODO: Code stuff here
            StringBuilder s=new StringBuilder();
            String [] strings=sentence.split(" ");
            for (String string:strings){

                if(string.length()>=5){
                    StringBuilder stringBuilder=new StringBuilder();
                    String str=  stringBuilder.append(string).toString();
                    s.append(str+" ");
                }
                else {
                    s.append(string+" ");
                }
            }
            String res=s.toString().trim();
            return res;
        }
}}
