/*
Autoservis
---------------------------------------
Zadanim je vytvorit autoservis, ktery na vice mistech CR a SR. Tedy bude mit vice pobocek.
Kazda pobocka bude instanci daneho servisu.

Autoservis si vede evidenci vsech svych vozidel. Tento seznam bude implementovan pomoci kolekce,
ktera bude obsahovat instance tridy auto.

Trida auto bude obsahovat, alespon 5 atributu, pro jeji nasledne porovnani (filtrovani).
Jednim z atributu je SPZ.

Kazda pobocks opravuje, prodava a kupuje auta. Kazda tato transakce je evidovana pomoci EET,
a proto ma svuj unikatni kod. dale je uveden kupujici, prodavajici a datum obchodu, dan a castka.

po kazde provedene transakci je updatovana balance firmy.

Kazda pobocka musi mit presny prehled o svych aktualne vlastnenyvh autech a soucasne byt schopna
sdelit zajemci, jestli jeho pozadovane auto neni k dostani i na jinych pobockach.
*/

package com.company;

public class Main {

    public static class AutoServis {
        public String nazev;
        public int cislo;

    }

    public static class Auto {
        private int cena;
        private String spz;
        private String barva;
        private String stav;
        private String typ;

        public Auto(int cena, String spz, String barva, String stav, String typ) {
            this.cena = cena;
            this.spz = spz;
            this.barva = barva;
            this.stav = stav;
            this.typ = typ;
        }
    }

    public static class Ucet{
        public int stav;

    }

    public static void main(String[] args) {
	// write your code here
        Auto a1 = new Auto(1000000, "5H32003", "cerna", "referencni", "sedan");
        Auto a2 = new Auto(600000, "6AZ2158", "cervena", "ojete", "dodavka");
        Auto a3 = new Auto(2650000, "4P14656", "hneda", "nove", "kupe");
        Auto a4 = new Auto(100000, "7L81254", "modra", "ojete", "kombik");
        Auto a5 = new Auto(400000, "6U46325", "cerna", "ojete", "kupe");
        Auto a6 = new Auto(1200000, "7HA2015", "ruzova", "referencni", "sedan");
        Auto a7 = new Auto(250000, "8DI3159", "bila", "ojete", "sedan");
        Auto a8 = new Auto(5600000, "4HJ1000", "stribrna", "nove", "dodavka");
        Auto a9 = new Auto(950000, "5B80007", "cerna", "ojete", "mpv");
        Auto a10 = new Auto(1450000, "7AS5050", "bezova", "referencni", "mpv");
        System.out.println("cena: " + a1.cena + "; spz: " + a1.spz + "; barva: " + a1.barva + "; stav: " + a1.stav + "; typ: " + a1.typ);
    }
}
