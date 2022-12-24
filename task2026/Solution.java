package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/

public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] arr) {

        int countShips = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == 1) {
                    if (j != 0 && i != 0) {
                        if (arr[i - 1][j] != 1 && arr[i][j - 1] != 1) {
                            countShips = countShips + 1;
                        }
                    } else {
                        if (i == 0 && j == 0) {
                            countShips = countShips + 1;
                        }else{
                            if (i == 0) {
                                if (arr[0][j-1] == 0) {
                                    countShips = countShips + 1;
                                }
                            }
                            if (j == 0) {
                                if (arr[i-1][0] == 0) {
                                    countShips = countShips + 1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return countShips;
    }
}

//1 строка - основной for
//2 строка - вложенный for
//3 строка - определение является ли текущая ячейка верхним левым углом (по сути угол может быть любой,
// но т. к. перебор массива мы, как правило, начинаем слева-сверху этот угол брать логичнее всего)
//Само решение сводится к:  Если (текущая ячейка == "1" && (слева граница || "0") && (сверху граница
// || "0")) мы нашли прямоугольник
