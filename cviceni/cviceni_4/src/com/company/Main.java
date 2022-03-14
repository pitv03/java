package com.company;

import java.util.Arrays;
import java.util.Scanner;
import java.lang.String;
import java.lang.Math;

import static java.lang.Math.abs;

public class Main {

public static void vypisSachovnici(char[][] sachovnice) {
    System.out.println("Vystup:");
    System.out.println("    A  B  C  D  E  F  G  H  ");           //horni okraj
    System.out.println("  +------------------------+");
    for(int i = 7; i>=0; i--){
        System.out.print(i + 1);
        System.out.print(" |");
        for (int j = 0; j < 8; j++) {
            if (sachovnice[i][j] == '#')
                System.out.print("   ");
            else {
                System.out.print("[");
                System.out.print(sachovnice[i][j]);
                System.out.print("]");
            }
        }
        System.out.print("|");
        System.out.println();
    }
    System.out.println("  +------------------------+");       //spodni okraj
    System.out.println("    A  B  C  D  E  F  G  H  ");
    System.out.println();
}

public static boolean presunFiguru(int[] pocSourad, int[] konSourad, char[][] sachovnice, int cb){
    if ((pocSourad[1] + cb == konSourad[1]) && (abs(pocSourad[0] - konSourad[0]) == 1)){        //posun figury bez preskoceni
        sachovnice[pocSourad[1]][pocSourad[0]] = ' ';
        if (cb == 1)
            sachovnice[konSourad[1]][konSourad[0]] = 'B';
        else sachovnice[konSourad[1]][konSourad[0]] = 'C';
        if ((konSourad[1] == 7) && (sachovnice[konSourad[1]][konSourad[0]] == 'B'))         //kdyz bude bila figura na poslednim cernem poli, tak zmizi
            sachovnice[konSourad[1]][konSourad[0]] = ' ';
        if ((konSourad[1] == 0) && (sachovnice[konSourad[1]][konSourad[0]] == 'C'))         //kdyz bude cerna figura na poslednim cernem poli, tak zmizi
            sachovnice[konSourad[1]][konSourad[0]] = ' ';
        return true;
    }
    int druhFigury = 0;             //cerna figura
    if (cb == 1) druhFigury = 1;            //bila figura
    if (((pocSourad[1] + cb + cb == konSourad[1]) && (abs(pocSourad[0] - konSourad[0]) == 2))                           //skok figury
        && ((pocSourad[1] + cb == konSourad[1] - cb) && (((sachovnice[(pocSourad[1] + konSourad[1]) / 2][(pocSourad[0] + konSourad[0]) / 2]) == 'C' && druhFigury == 1)
        || ((sachovnice[(pocSourad[1] + konSourad[1]) / 2][(pocSourad[0] + konSourad[0]) / 2]) == 'B' && druhFigury == 0)))) {
        sachovnice[pocSourad[1]][pocSourad[0]] = ' ';
        if (cb == 1)
            sachovnice[konSourad[1]][konSourad[0]] = 'B';
        else sachovnice[konSourad[1]][konSourad[0]] = 'C';
        sachovnice[pocSourad[1] + cb][(konSourad[0] + pocSourad[0]) / 2 ] = ' ';                  //vyhozeni figury
        if ((konSourad[1] == 7) && (sachovnice[konSourad[1]][konSourad[0]] == 'B'))         //kdyz bude bila figura na poslednim cernem poli, tak zmizi
            sachovnice[konSourad[1]][konSourad[0]] = ' ';
        if ((konSourad[1] == 0) && (sachovnice[konSourad[1]][konSourad[0]] == 'C'))         //kdyz bude cerna figura na poslednim cernem poli, tak zmizi
            sachovnice[konSourad[1]][konSourad[0]] = ' ';
        return true;
    }
    System.out.println("Neplatny tah.");
    return false;
}

public static boolean tah(Scanner s1, char[][] sachovnice, int cb){
    int[]souradnice = new int[2];

    System.out.println("Napis souradnice figury se kterou chces tahnout:");
    String vstup = s1.nextLine();
    if (vstup.length()!=2){                                                    //zde testuji jestli ma zadany retezec prave dva znaky
        System.out.println("Spatne souradnice.");
        return false;                                               //tah se nepovedl, spousti se znova
    }
    prevedSouradnice(vstup, souradnice, s1, sachovnice, cb);
    int[]pocSourad = new int[2];
    pocSourad = Arrays.copyOfRange(souradnice, 0, 2);
    if ((cb == 1 && sachovnice[souradnice[1]][souradnice[0]] != 'B') || (cb == -1 && sachovnice[souradnice[1]][souradnice[0]] != 'C')) {
        System.out.println("Na tomto poli se vase figura nenachazi.");
        return false;                                               //tah se nepovedl, spousti se znova
    }
    System.out.println("Napis cilove souradnice tahu figury:");
    vstup = s1.nextLine();
    prevedSouradnice(vstup, souradnice, s1, sachovnice, cb);
    int[]konSourad = new int[2];
    konSourad = Arrays.copyOfRange(souradnice, 0, 2);
    if (sachovnice[souradnice[1]][souradnice[0]] != ' ') {
        System.out.println("Toto pole je obsazene, neplatny tah.");
        return false;                                               //tah se nepovedl, spousti se znova
    }
    return presunFiguru(pocSourad, konSourad, sachovnice, cb);
}

public static int[] prevedSouradnice(String vstup, int[] souradnice, Scanner s1, char[][] sachovnice, int cb){
    String sloupec = vstup.substring(0, 1);
    int pomSloupec = 0;
    if ((sloupec.equals("A")) || (sloupec.equals("a"))) pomSloupec = 0;             //prevedeni sloupcu na integer pro lepsi praci v poli
    else if ((sloupec.equals("B")) || (sloupec.equals("b"))) pomSloupec = 1;
    else if ((sloupec.equals("C")) || (sloupec.equals("c"))) pomSloupec = 2;
    else if ((sloupec.equals("D")) || (sloupec.equals("d"))) pomSloupec = 3;
    else if ((sloupec.equals("E")) || (sloupec.equals("e"))) pomSloupec = 4;
    else if ((sloupec.equals("F")) || (sloupec.equals("f"))) pomSloupec = 5;
    else if ((sloupec.equals("G")) || (sloupec.equals("g"))) pomSloupec = 6;
    else if ((sloupec.equals("H")) || (sloupec.equals("h"))) pomSloupec = 7;
    else {
        System.out.println("Spatne souradnice");                                    //podminka pro nespravny vstup sloupce
        tah(s1, sachovnice, cb);
    }
    //System.out.println(pomSloupec);
    String radek = vstup.substring(1, 2);
    int pomRadek = Integer.parseInt(radek);
    if ((pomRadek < 1) || (pomRadek > 8)){                                          //podminka pro zadani spatneho radku
        System.out.println("Spatne souradnice");
        tah(s1, sachovnice, cb);
    }
    pomRadek--;
    //System.out.println(pomRadek);
    souradnice[0] = pomSloupec;
    souradnice[1] = pomRadek;
    return souradnice;
}

public  static boolean konecHry(char[][] sachovnice){
    int chybiB = 0;
    int chybiC = 0;
    for(int i = 0; i<8; i++){
        for(int j = 0; j<8; j++){
            if (sachovnice[i][j] == 'B') chybiB = 1;
            if (sachovnice[i][j] == 'C') chybiC = 1;
        }
    }
    if (chybiB == 0 || chybiC == 0) return true;
    else return false;
}

    public static void main(String[] args) {
	// write your code here
        char mistoPole = '#';
        char [][]sachovnice = new char[8][8];
        for(int i = 0; i<8; i++){
            if (mistoPole != '#') mistoPole = '#';
            else {
                if (i < 3)
                    mistoPole = 'B';        //bile figury
                if (i > 4)
                    mistoPole = 'C';        //cerne figury
                if ((i > 2) && (i < 5))
                    mistoPole = ' ';        //prazdne pole
            }
            for(int j = 0; j<8; j++) {
                sachovnice[i][j] = mistoPole ;
                if (mistoPole != '#') mistoPole = '#';
                else {
                    if (i < 3)
                        mistoPole = 'B';
                    if (i > 4)
                        mistoPole = 'C';
                    if ((i > 2) && (i < 5))
                        mistoPole = ' ';
                }
            }
        }
        while (konecHry(sachovnice) == false){
            vypisSachovnici(sachovnice);        //funkce, ktera vypise sachovnici
            Scanner s1 = new Scanner(System.in);
            System.out.println("Tahne bily:");
            while (tah(s1, sachovnice, 1) == false);
            vypisSachovnici(sachovnice);
            System.out.println("Tahne cerny:");
            while (tah(s1, sachovnice, -1) == false);
        }
    }
}