package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Double.parseDouble;

/* 
Читаем и пишем в файл: Human
*/

public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("C:\\Java\\JavaRushTasks\\2.JavaCore\\test1.txt");
            InputStream inputStream = new FileInputStream("C:\\Java\\JavaRushTasks\\2.JavaCore\\test1.txt");

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            System.out.println(ivanov.equals(somePerson));
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            System.out.println(ivanov.equals(somePerson));
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter=new PrintWriter(outputStream);
printWriter.println(name);
printWriter.println(assets.size());
for(Asset a:assets){
    printWriter.println(a.getName());
    printWriter.println(a.getPrice());
}

        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader (inputStream));
           name= bufferedReader.readLine();
           int a= Integer.parseInt(bufferedReader.readLine());
            for (int i = 0; i < a; i++) {
                assets.add( new Asset(bufferedReader.readLine(),Double.parseDouble(bufferedReader.readLine())));

            }
        }
    }
}
