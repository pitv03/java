package com.company;

import java.util.Scanner;

public class Main {

    public static class Student{
        int age;
        String name;
        String nationality;

        public Student(int age, String name, String nationality){
          this.age = age;
          this.name = name;
          this.nationality = nationality;
        }

        private void multiplicationAge(){
            this.age *= 2;
        }

        public void celebrateBirthday(){
            age+=1;
        }

        public int tellMeYourAge(){
            return age;
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student(20, "John", "CZ");
        System.out.println(s1.age + " " + s1.name + " " + s1.nationality);
        s1.celebrateBirthday();
        System.out.println(s1.age + " " + s1.name + " " + s1.nationality);
        s1.celebrateBirthday();
        System.out.println(s1.age + " " + s1.name + " " + s1.nationality);
        s1.tellMeYourAge();
        System.out.println(s1.age + "\n");

        Student s2 = new Student(17, "Tomas", "D");
        System.out.println(s2.age + " " + s2.name + " " + s2.nationality);
        s2.multiplicationAge();
        System.out.println(s2.age + "\n");

        //Zakladni matematicke operace ---------------------------------------------
        Scanner sc = new Scanner(System.in);
        System.out.println("Zadejte prvni cislo:");
        float x = Float.parseFloat(sc.nextLine());
        System.out.println("Zadejte druhe cislo:");
        float y = Float.parseFloat(sc.nextLine());
        float sum = x + y;
        float difference = x - y;
        float multiplication = x * y;
        float quotient = x / y;
        float modulo = x % y;
        System.out.println("Soucet:" + sum);
        System.out.println("Rozdil:" + difference);
        System.out.println("Soucin:" + multiplication);
        System.out.println("Podil:" + quotient);
        System.out.println("Modulo:" + modulo);
        System.out.println("\n");
        if(x == y){
            System.out.println("Cisla x a y se rovnaji.");
        } else {
            System.out.println("Cisla x a y se nerovnaji.");
        }
    }
}
