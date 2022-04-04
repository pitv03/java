/*
1) Vytvorit vektor cisel o velikosti 100
2) Naplnit vektor nahodnymi cisly
3) vypsat vektor
4) while cyklus, ktey na random pozici (0, delka vektoru) odebere dany prvek z vektoru na danem indexu
do doby nez bude zbyvat 10 prvku v tom vectoru

------------------------------------------------------------------------------------------------------------------------

1) vytvorit novou mapu, kde klic bude nejaky string (=nazev)
a pro tento klic prirad do mapy nejaky seznam (pole, set, vector...)
2) proiterovat tuhle mapu a pro kazdy jeji klic vypsat jeho hodnotu
*/

package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class Main {

    public static void vypisMapu(Map <String, Vector<Integer>> pocetJmen){
        Set<String> mnozinaKlicu = pocetJmen.keySet();
        for (String klic : mnozinaKlicu){
            System.out.println(klic+"\t" + pocetJmen.get(klic));
        }
    }

    public static void main(String[] args) {
        // write your code here
        // Prvni ukol --------------------------------------------------------------------------------------------------
        System.out.println("\n" + "Prvni ukol:");
        Vector<Integer> v = new Vector<Integer>();

        for (int i = 0; i < 100; i++){
            int nahodneCislo = (int) (Math.random() * 100);
            v.add(nahodneCislo);
        }
        System.out.println("Vektor nalneny 100 nahodnych cisel:");
        System.out.println(v);
        System.out.println("\n");

        int nahodneCislo2;
        int pocNahodCisel = 100;
        while (v.size() > 10){
            nahodneCislo2 = (int) (Math.random() * pocNahodCisel);
            v.removeElementAt(nahodneCislo2);
            pocNahodCisel--;                            //musim snizit rozsah pocetu nahodnych cisel, aby byl mensi nez nahodneCislo2
            //System.out.print(nahodneCislo2 + " ");
            //System.out.print(v.size() + " ");
        }
        System.out.println("Vektor po odebrani 90 cisel:");
        System.out.println(v);
        System.out.println("\n" + "Druhy ukol:");

        // Druhy ukol --------------------------------------------------------------------------------------------------
        Map <String, Vector<Integer>> pocetJmen = new HashMap<>();
        pocetJmen.put("Tomas", new Vector<Integer>());
        pocetJmen.get("Tomas").add(8);                  //pomoci get si "vyjmu" pole z mapy, abych mel k tomu pristup
        pocetJmen.put("Pavel", new Vector<Integer>());
        pocetJmen.get("Pavel").add(45);
        pocetJmen.put("Jana", new Vector<Integer>());
        pocetJmen.get("Jana").add(21);
        pocetJmen.put("Karel", new Vector<Integer>());
        pocetJmen.get("Karel").add(3);
        pocetJmen.put("Ondrej", new Vector<Integer>());
        pocetJmen.get("Ondrej").add(19);
        pocetJmen.put("Marie", new Vector<Integer>());
        pocetJmen.get("Marie").add(152);
        pocetJmen.put("Monika", new Vector<Integer>());
        pocetJmen.get("Monika").add(47);
        pocetJmen.put("Julie", new Vector<Integer>());
        pocetJmen.get("Julie").add(82);
        pocetJmen.put("Jakub", new Vector<Integer>());
        pocetJmen.get("Jakub").add(11);
        pocetJmen.put("Mila", new Vector<Integer>());
        pocetJmen.get("Mila").add(6);

        vypisMapu(pocetJmen);
    }
}
