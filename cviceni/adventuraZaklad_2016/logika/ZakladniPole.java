package logika;

/**
 * Abstraktní třída ZakladniPole reprezentuje základ pro třídu prostor.
 * Z této třídy dědí třída Prostor.
 *
 * @author      Vojtěch Pitřinec
 * @version     LS 2021/2022
 */
public abstract class ZakladniPole {
   private final int cislo;

    /**
     * Konstruktor abstraktní třídy
     * @param cislo jako parametr je zde číslo prostoru
     */
    public ZakladniPole(int cislo) {
        this.cislo = cislo;
    }

    /**
     * Tato metoda vypíše informace o prostoru
     */
    public void getInfoProstoru(){
        System.out.println("cislo prostoru: " + cislo);
    }
}
