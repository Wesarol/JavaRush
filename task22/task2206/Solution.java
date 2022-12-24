package com.javarush.task.task22.task2206;

import java.util.Date;
import java.util.zip.DataFormatException;

/* 
Форматирование даты
*/

public class Solution {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(String.format(getFormattedString(), date, date, date, date, date, date));
        //должен быть вывод аналогичный следующему
        //31:10:13 15:59:59
    }

    public static String getFormattedString() {
        //05:04:18 09:09:09 (число:месяц:год часы:минуты:секунды)
        String s="%td:%tm:%ty %tH:%tM:%tS";

        return s;
    }
}
