package uiText;


import java.util.Scanner;

import logika.HerniPlan;
import logika.IHra;
/**
 *  Class TextoveRozhrani
 * 
 *  Toto je uživatelského rozhraní aplikace Adventura
 *  Tato třída vytváří instanci třídy Hra, která představuje logiku aplikace.
 *  Čte vstup zadaný uživatelem a předává tento řetězec logice a vypisuje odpověď logiky na konzoli.
 *
 *@author       Vojtěch Pitřinec
 *@version      LS 2021/2022
 */

public class TextoveRozhrani {
    private IHra hra;
    private HerniPlan plan;

    /**
     *  Vytváří hru.
     */
    public TextoveRozhrani(IHra hra) {
        this.hra = hra;
        this.plan = hra.getHerniPlan();
    }

    /**
     *  Hlavní metoda hry. Vypíše úvodní text a pak opakuje čtení a zpracování
     *  příkazu od hráče do té doby dokud hráč nenapíše příkaz konec,
     *  nebo hráči dojde limit počtu příkzů, nebo hráč splní všechny ůkoly.
     *  Nakonec se vypíší body získané při hře a jestli hráč vyhrál.
     */
    public void hraj() {
        System.out.println(hra.vratUvitani());

        // základní cyklus programu - opakovaně se čtou příkazy a poté
        // se provádějí do konce hry.

        int pocetPrikazu = 0;
        while (((!hra.konecHry()) && (pocetPrikazu <= 50)) &&
                (plan.najdiProstor("paluba_D3").obsahujeVeci() == true || plan.najdiProstor("paluba_D1").obsahujeVeci() == true)) {
            String radek = prectiString();
            System.out.println(hra.zpracujPrikaz(radek));
            pocetPrikazu++;
        }

        //zde testuji jestli nebyl presahnut limit prikazu
        if (pocetPrikazu == 51) {
            System.out.println("Nestihl jste zachranit posadku v casovem limitu. Hru jste prohral. Muzete to zkusit znovu.");
        }
        //zde testuji jestli hrac splni vsechny ukoly
        if (plan.najdiProstor("paluba_D3").obsahujeVeci() == false && plan.najdiProstor("paluba_D1").obsahujeVeci() == false){
            System.out.println(hra.vypisBody());
        }
    }

    /**
     *  Metoda přečte příkaz z příkazového řádku
     *
     *@return    Vrací přečtený příkaz jako instanci třídy String
     */
    private String prectiString() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("> ");
        return scanner.nextLine();
    }

}
