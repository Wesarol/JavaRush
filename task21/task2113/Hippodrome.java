package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Hippodrome {
    static Hippodrome game;
    private List<Horse> horses;

    void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
            //В методе run сделай цикл от 1 до 100. Это и будет наш забег.
            //В теле цикла вызываем сначала move, затем print.
            //Чтобы весь цикл не отработал за долю секунды - добавь в него еще Thread.sleep(200);
        }
    }

    void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    void print() {
        for (Horse horse : horses) {
            horse.print();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }
    public Horse getWinner(){
        Horse horse1=horses.get(0);
        for (Horse horse:horses){
           if(horse.getDistance()>horse1.getDistance()) {
               horse1=horse;
           }
        }
        return horse1;
    }
    public void printWinner(){

        System.out.println("Winner is "+getWinner().getName()+"!");
    }

    public static void main(String[] args) throws InterruptedException {

        game = new Hippodrome(new ArrayList<>());
        game.getHorses().add(new Horse("\uD83D\uDC0E Алина", 3, 0));
        game.getHorses().add(new Horse("\uD83D\uDC0E Черный", 3, 0));
        game.getHorses().add(new Horse("\uD83D\uDC0E Саня", 3, 0));

        long start = System.nanoTime();
// выполнение какой-то логики
        game.run();

        game.printWinner();
        long finish = System.nanoTime();
        long elapsed = finish - start;

        System.out.println("Лучшее время ");

// Код, который нужно померить

        System.out.printf(" %,9.3f ms\n", elapsed/1_000_000.0);
    }
}
