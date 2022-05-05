package logika;

/**
 *  Třida Vec implementuje v této hře vec, kterou v ni používám.
 *  Tato trida je soucasti jednoduche textove hry.
 *
 *@author     Vojtěch Pitřinec
 *@version    LS 2021/2022
 */

public class Vec {
    public final String nazev;
    public boolean vejdeSeDoBatohu = false;
    public String vybaveni;

    /**
     *  Konstruktor třídy Vec
     *  tento konstruktor mi přidává název a vybavení ke všem věcem, které zde vytvářím.
     *
     *  @param nazev        rika jak se vec jmenuje
     *  @param vybaveni     k věci se může přidat nějaké vybavení, aby správně fungovala
     */
    public Vec(String nazev, String vybaveni){
        this.nazev=nazev;
        this.vybaveni=vybaveni;
    }

    /**
     * Konstruktor třídy Vec
     * tonto druhý konstruktor jsem si vytvořil proto, abych pramametr vejdeSeDoBatohu nemusel vypisovat u všech věcí,
     * ale jen u těch, kde to potřebuji.
     *
     * @param nazev             popisuje jak se daná věc jmenuje
     * @param vybaveni          k věci se může přidat nějaké vybavení, aby správně fungovala
     * @param vejdeSeDoBatohu   určuje jestli se daná věc vejde nebo nevejde do batohu
     */
    public Vec(String nazev, String vybaveni, boolean vejdeSeDoBatohu){
        this(nazev,vybaveni);
        this.vejdeSeDoBatohu=vejdeSeDoBatohu;
    }

    /**
     * Tato matoda vypíše "popis" dané věci.
     * Konktétně název a jestli má věc nějaké vybavení.
     */
    public void vypisPopis() {
        System.out.println("nazev: " + this.nazev + "\n" +
                           "vybaveni: " + this.vybaveni);
    }
}
