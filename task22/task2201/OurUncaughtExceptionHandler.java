package com.javarush.task.task22.task2201;

public class OurUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        final String string = "%s : %s : %s";
        if (Solution.FIRST_THREAD_NAME.equals(t.getName())) {
            System.out.println(getFormattedStringForFirstThread(t, e, string));
        } else if (Solution.SECOND_THREAD_NAME.equals(t.getName())) {
            System.out.println(getFormattedStringForSecondThread(t, e, string));
        } else {
            System.out.println(getFormattedStringForOtherThread(t, e, string));
        }
    }

    protected String getFormattedStringForOtherThread(Thread t, Throwable e, String string) {

        return String.format(string,e.getClass().getSimpleName(),e.getCause(),t.getName());
    }

    protected String getFormattedStringForSecondThread(Thread t, Throwable e, String string) {
        return String.format(string,e.getCause(),e.getClass().getSimpleName(),t.getName());
    }

    protected String getFormattedStringForFirstThread(Thread t, Throwable e, String string) {
        return String.format(string,t.getName(),e.getClass().getSimpleName(),e.getCause());
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

