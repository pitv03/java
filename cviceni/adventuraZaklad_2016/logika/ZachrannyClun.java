package logika;

/**
 * Třída ZachrannyClun implementuje ve této hře Věc Záchranný člun
 * Tato třída dědí z třídy Vec (nazev a vybaveni).
 *
 * @author      Vojtěch Pitřinec
 * @version     LS 2021/2022
 */
public class ZachrannyClun extends Vec{
    private int hmotnost;
    private int kapacita;

    /**
     * Konstruktor k třídě ZachrannyClun
     *
     * @param nazev     název záchranného člunu
     * @param vybaveni  jaké má člun vzbavení
     * @param hmotnost  jakou hmotnost člun má
     * @param kapacita  pro kolik osob je člun určen
     */
    public ZachrannyClun (String nazev, String vybaveni, int hmotnost, int kapacita) {
        super(nazev, vybaveni);
        this.hmotnost = hmotnost;
        this.kapacita = kapacita;
    }

    /**
     * Tato metoda nám vypíše několik informací o záchranném člunu.
     * Metoda zároveň dědí z metody vypisPopis, která se nachází ve Třídě Vec.
     */
    @Override
    public void vypisPopis() {
        super.vypisPopis();
        System.out.println("hmotnost: " + this.hmotnost + " kg\n" +
                           "kapacita poctu lidi: " + this.kapacita);
    }
}
