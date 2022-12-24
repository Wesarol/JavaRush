package com.javarush.task.task23.task2308;

public class test {
    public static void main(String[] args) {
        test test1=new test();
       String g= test1.spinWords("Hey fellow warriors");
        System.out.println(g);
    }
    public String spinWords(String sentence) {
        //TODO: Code stuff here
        StringBuilder s=new StringBuilder();

        String [] strings=sentence.split(" ");
        if(strings.length==1){
            return new StringBuilder(sentence).reverse().toString().trim();
        }
        for (String string:strings){

            if(string.length()>=5){
                StringBuilder stringBuilder=new StringBuilder();
              String str=  stringBuilder.append(string).reverse().toString();
              s.append(str+" ");
            }
            else {
                s.append(string+" ");
            }
        }
String res=s.toString().trim();
        return res;
    }
    //Напишите функцию, которая принимает строку из одного или нескольких слов и возвращает ту же строку,
    // но с перевернутыми всеми словами из пяти или более букв (точно так же, как имя этого Ката). Передаваемые
    // строки будут состоять только из букв и пробелов. Пробелы будут включены только в том случае, если присутствует
    // более одного слова.
    //
    //Примеры:
    //
    //spinWords( "Hey fellow warriors" ) => returns "Hey wollef sroirraw"
    //spinWords( "This is a test") => returns "This is a test"
    //spinWords( "This is another test" )=> returns "This is rehtona test"
    //src/main/java/SpinWords.java:20: error: reached end of file while parsing
    //}
}
