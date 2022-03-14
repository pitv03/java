package com.company;

public class Main {

    public static class Car{
        public int price;
        public String color;

        private void sell(){
            this.price *= 0.8;
        };

        public Car(int price, String color){        //Konstruktor
            this.color = color;
            this.price = price;
        };
    }

    public static void main(String[] args) {
        // write your code here
        Car c1 = new Car(5000, "red");
        System.out.println(c1.price);
        c1.sell();
        System.out.println(c1.price);
    }
}
