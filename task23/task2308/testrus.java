package com.javarush.task.task23.task2308;

import java.util.Arrays;
import java.util.Comparator;

public class testrus {
    public static void main(String[] args) {
        final Item item1 = new Item(4, 20);
        final Item item2 = new Item(3, 18);
        final Item item3 = new Item(2, 14);

        final Item[] items = {item1, item2, item3};
        Arrays.sort(items, Comparator.comparingDouble(Item::valuePerUnitOfWeight).reversed());

        System.out.println(Arrays.toString(items));
        final int W = 7;// вместимость рюкзока
        int weihhtSoFar = 0;//текущий вес
        double valueSoFar = 0;//ценность которую набрали
        int currentItem = 0;//индес текущего предмета

        while (weihhtSoFar != W && currentItem<items.length) {
if(weihhtSoFar+items[currentItem].getWeight() <=W){
    weihhtSoFar+=items[currentItem].getWeight();
    valueSoFar+=items[currentItem].getValue();
}
else {
    valueSoFar+= ((W-weihhtSoFar)/(double)items[currentItem].getWeight())*items[currentItem].getValue();
}
currentItem++;

        }
        System.out.println("Большая сумма "+valueSoFar);

    }

    static class Item {
        private int weight;
        private int value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "weight=" + weight +
                    ", value=" + value +
                    '}';
        }

        public double valuePerUnitOfWeight() {
            return value / (double) weight;
        }
    }
}
