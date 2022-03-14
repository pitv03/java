package com.company;

import java.awt.*;              //na referencni typy
import java.io.FilterOutputStream;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;       //knihovny
import java.util.Date;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int celeCislo = 200;
        boolean pravdaNepravda = false;
        float desetinneCislo = 5.3f;
        System.out.println("Hello world");
        System.out.println(celeCislo);          //Tento radek muzu napsat pomoci: sout + klavesa tab
        celeCislo = 20;
        System.out.println(celeCislo);
        System.out.println("\n");

        //-------------------------------------------------

        Scanner sc = new Scanner(System.in);        //Tenhle radek staci napsat jen jedou pote uz dokaze cist z  console kdykoliv
        System.out.println("Napis text:");
        String vstup;
        vstup = sc.nextLine();              //metoda nextLine nacita string nebo cisla z console, je nutne pridat promennou sc
        String vystup;
        vystup = vstup + ", " + vstup + "!";
        System.out.println(vystup);
        System.out.println("\n");

        String s = "56";                //Parsovani ze stringu
        int ab = Integer.parseInt(s);
        System.out.println(ab);
        System.out.println("\n");

        //Aritmeticke operace-----------------------------------
        //Scanner sc = new Scanner(System.in);
        System.out.println("Zadejte prvni cislo:");
        float a = Float.parseFloat(sc.nextLine());      //Kdyz chceme ze stringu naparsovat int nebo float, tak musime pouzit metodu parseFloat, parseInt
        System.out.println("Zadejte druhe cislo:");
        float b = Float.parseFloat(sc.nextLine());
        float soucet = a + b;
        float rozdil = a - b;
        float soucin = a * b;
        float podil = a / b;
        float celoCiselDel = a % b;
        System.out.println("Soucet:" + soucet);
        System.out.println("Rozdil:" + rozdil);
        System.out.println("Soucin:" + soucin);
        System.out.println("Podil:" + podil);
        System.out.println("Celociselne deleni:" + celoCiselDel);
        System.out.println("\n");
        if(a == b){
            System.out.println("Cisla A a B se rovnaji");
        } else {
            System.out.println("Cisla A a B se nerovnaji");
        }

        //cykly ---------------------------------------------------
        //while a do-while
        //rozdil je v tom, ze do-while probehne aspon jednou

        int pocet = 0;
        while(pocet < 10){
            System.out.println("Cislo: " + pocet);
            pocet++;
        }
        System.out.println("\n");

        for(int i = 0; i < 10; i++){
            System.out.println("Cislo: " + i);
        }
        System.out.println("\n");

        //datove objekty ------------------------------------------

        Date now = new Date();
        System.out.println(now);
        System.out.println("\n");

        //Primitivni vs Referencni typy ---------------------------

        Point point1 = new Point(1, 1);
        Point point2 = point1;
        point1.x = 2;                   //point1 a point2 maji stejny odkaz do pameti
        System.out.println(point2);
        System.out.println("\n");

        //string --------------------------------------------------
        //string je trida, ktera ma cleny, ke kterym muzeme pristupovat pomoci operatoru tecka
        String message = "   Hello World" + "!!";
        System.out.println(message.endsWith("!!"));     //Ptame se jestli dany retezec konci stringem pomoci funkce endsWith
        System.out.println(message.length());     //kolik ma znaku retezec
        System.out.println(message.indexOf("e"));       //tato funkce nam vrati prvni vyskyt znaku "e" jako index
        System.out.println(message.replace("!", "*"));      // ! se nahradi *
        System.out.println(message.toLowerCase());      //zmeni vsechna pismena v retezci na mala
        System.out.println(message.trim());         //smaze v retezci prebytecne bile znaky
        System.out.println("\n");

        //pole-----------------------------------------------------
        //prvni starsi metoda
        int [] numbers = new int[5];        //tady si nadefinujeme pole integeru, do ktereho se vejde pet cisel o velikosti integer
        numbers[0] = 1;
        numbers[1] = 2;
        System.out.println(Arrays.toString(numbers)); // kdyz chci vypsat pole do stringu tak na to musím použít tuto funkci
        //druha novejsi metoda
        int [] numbers1 = { 2, 3, 5, 1, 4 };        //vytvarime pole integeru o velikosti pet, ktere jsme rovou naplnili
        System.out.println(numbers1.length);        //napise nam delku retezce
        System.out.println(Arrays.toString(numbers1));      //vypiseme pole pomoci stringu do console
        Arrays.sort(numbers1);          //seradi nam to cisla podle velikosti
        System.out.println(Arrays.toString(numbers1) + "\n");

        //Vicerozmerna pole-----------------------------------------
        int [][] matice = new int[2] [3];
        matice[0][0] = 1;           //plnime matici na 0 radku a 0 sloupci
        matice[1][0] = 2;
        matice[0][1] = 3;
        System.out.println(Arrays.deepToString(matice));       //pro vypsani vicerozmerneho pole musime pouzit deepToString
        //druhy zpusob naplneni
        int [][] matice1 = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(Arrays.deepToString(matice1) + "\n");

        //definovani konstant---------------------------------------
        final float PI = 3.14f;     //takto deklarujeme promennou se kterou uz potom v programu nezmenime

        //pretipovani-----------------------------------------------
        // byte > short > int > long > float > double
        // nejde pretipovat retezec na cislo, leda pres parseInt, parseFloat atd...
        short w = 1;
        int q = w + 2;      //toto je automaticke pretipovani, ktere je v posloupnosti viz. vyse
        System.out.println(q);
        double w1 = 1;
        int q1 = (int)w1 + 2;       //toto je pretipovani ktere je mimo posloupnost, je to mozne, ale odrizne se desetinna cast
        System.out.println(q1 + "\n");

        //matematicke funkce----------------------------------------
        int hodnota = Math.round(1.1f);         //tato matematicka funkce nam zaokrouhli 1.1 na 1
        System.out.println(hodnota);
        int hodnota1 = (int)Math.ceil(1.1f);        //zaokrouhli vzdy nahoru
        System.out.println(hodnota1);
        int hodnota2 = (int)Math.floor(1.1f);       //zaohrouhli vzdy dolu
        System.out.println(hodnota2);
        int hodnota3 = (int)Math.max(1, 2);       //vypise nejvyssi hodnotu
        System.out.println(hodnota3);
        int hodnota4 = (int)Math.min(1, 2);       //vypise nejnizsi hodnotu
        System.out.println(hodnota4);
        double hodnota5 = Math.random() * 100;       //vygeneruje nahodne cislo mezi 0 az 100
        System.out.println(hodnota5);
        int hodnota6 = (int) Math.round(Math.random() * 100);       //vygeneruje nahodne cislo mezi 0 az 100 zaokrouhlene na cela cisla
        System.out.println(hodnota6 + "\n");

        //Formatovani cisel-----------------------------------------
        NumberFormat currency = NumberFormat.getCurrencyInstance();          //metoda pro formatovani cisla na menu v $
        String result = currency.format(1234567.891);
        System.out.println(result);         //zde dostaneme vypis $1,234,567.89
        NumberFormat percent = NumberFormat.getPercentInstance();          //metoda pro formatovani cisla na procenta
        String result1 = percent.format(0.1);
        System.out.println(result1);         //zde dostaneme vypis 10%
    }
}
