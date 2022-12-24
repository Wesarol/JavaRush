package com.javarush.task.task22.task2201;

/* 
Строки нитей или строковые нити? Вот в чем вопрос
*/

public class Solution {
    public static void main(String[] args) {
        new Solution();
    }

    public static final String FIRST_THREAD_NAME = "1#";
    public static final String SECOND_THREAD_NAME = "2#";

    private Thread thread1;
    private Thread thread2;
    private Thread thread3;

    public Solution() {
        initThreads();
    }

    protected void initThreads() {
        this.thread1 = new Thread(new Task(this, "A\tB\tC\tD\tE\tF\tG\tH\tI"), FIRST_THREAD_NAME);
        this.thread2 = new Thread(new Task(this, "J\tK\tL\tM\tN\tO\tP\tQ\tR\tS\tT\tU\tV\tW\tX\tY\tZ"), SECOND_THREAD_NAME);
        this.thread3 = new Thread(new Task(this, "\t\t"), "3#");

        Thread.setDefaultUncaughtExceptionHandler(new OurUncaughtExceptionHandler());

        this.thread1.start();
        this.thread2.start();
        this.thread3.start();
    }

    public synchronized String getPartOfString(String string, String threadName) {
        try {
         // String [] split=  string.split("\\t");
          String resul=  string.substring(string.indexOf('\t')+1,string.lastIndexOf('\t'));
            return resul;
        }
        catch (StringIndexOutOfBoundsException ex){
            if(threadName.equals(FIRST_THREAD_NAME)) {
                throw new StringForFirstThreadTooShortException(ex);
            }
                if(threadName.equals(SECOND_THREAD_NAME)){
                    throw new    StringForSecondThreadTooShortException(ex);
                }
                else {
                    throw new RuntimeException(ex);
            }
        }
    }
    //алгоритм в соответствии с условиями задачи:
    //1. в try получаем строку. при отсутствии возможности получить ее (не хватает знаков табуляции)
    //2. в cach ловим (StringIndexOutOfBoundsException ex) и через if / else или swith передаем эксепшен
    //throw new TooShortString... (ex) и throw new RuntimeException(ex);.
    //c RunTime все будет в порядке, а вот передачу ex в TooShort... компилятор не примет, так как у них не переопределены конструкторы, принимающие (Throwable cause). идем и наследуемся от Runtime и генерируем (alt + ins) конструктор ...(Throwable cause).
    //3. дальше свистопляска: ThisUncaughtExceptionHandler имеет единственный @Override метод, который выводит на консоль сообщение, которое собирается из пазлов в 3х других методах:
    //пазлы для (t, e, string): string формат строки с тремя переменными String
    //1#                               - t.getname
    //TooShort...Exception  - e.getClass.getSimpleName
    //java... : ..of range: -1  - e.getCause
    //return String.format (string, пазл,пазл,пазл)
}
