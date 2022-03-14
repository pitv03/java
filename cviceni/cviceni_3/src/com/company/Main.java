package com.company;

public class Main {

    public static class Car{
        private int price;
        private String color;

        private void sell(){
            this.price *= 0.8;
        };

        public Car(int price, String color){        //Konstruktor
            this.color = color;
            this.price = price;
        };
    }

    //public double getPrice() {return this.price;}       //pouziti getter setter

    public static void main(String[] args) {
	// write your code here
        Car c1 = new Car(5000, "red");
        System.out.println(c1.price);
        c1.sell();
        System.out.println(c1.price);
        //System.out.println(c1.getPrice());


        // ternarni podmineni operator ?
        int nun =50;

        if ( nun > 30)
            System.out.println(nun);
        else
            System.out.println(0);
        // Condition ? true : false
        System.out.println( (nun > 30) ? "true" : "false");

        // u prikazu switch, kdyz zadny z casu se neprovede, tak nakonci musi byt default, ktery to ukonci
    }
}
