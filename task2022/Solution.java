package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/

public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName=fileName;
        this.stream = new FileOutputStream(fileName);
      
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\r\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();

    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
       
        in.defaultReadObject();
        this.stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();

    }

    public static void main(String[] args) throws Exception {
        Solution sol = new Solution("C:\\Java\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2021\\file.txt");
        sol.writeObject("danil");
        sol.writeObject("ilin");
        String fileName="C:\\Java\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2021\\Текстовый документ.txt";
ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream("C:\\Java\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2021\\Текстовый документ.txt"));
objectOutputStream.writeObject(sol);
objectOutputStream.close();
sol.close();

ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream(fileName));
Solution sol2=(Solution) objectInputStream.readObject();
sol2.writeObject("03.06.1999");
objectInputStream.close();
sol2.close();
       // System.out.println(1);
       // Solution sol = new Solution("C:/1/1.txt");
        sol.writeObject("Записываем данные");
        sol.writeObject("Дозапишем данные - у нас же метод flush а не close в writeObject");


        String filePath = "C:/1/save.bin";
        ObjectOutputStream streamOut = new ObjectOutputStream(new FileOutputStream(filePath));
        //если попытаться тут у объекта запустить метод writeObject(ObjectOutputStream out) и
        //передать туда наш стрим - получим ошибку NotActiveException - это не правильно.
        streamOut.writeObject(sol);
        //закрываем поток вывода в файл
        sol.close();
        //закрываем поток сериализации
        streamOut.close();

        ObjectInputStream streamIn = new ObjectInputStream(new FileInputStream(filePath));
       // Solution sol2 = (Solution) streamIn.readObject();
        sol2.writeObject("Данные нового потока.");
        //закрываем поток вывода в файл
        sol2.close();
        //закрываем поток десериализации
        streamIn.close();
    }
}
