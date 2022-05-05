package logika;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Trida Prostor - popisuje jednotlivé prostory (místnosti) hry
 *
 * Tato třída je součástí jednoduché textové hry.
 *
 * "Prostor" reprezentuje jedno místo (místnost, prostor, ..) ve scénáři hry.
 * Prostor může mít sousední prostory připojené přes průchody. Pro každý průchod
 * si prostor ukládá odkaz na sousedící prostor.
 *
 * @author     Vojtěch Pitřinec
 * @version    LS 2021/2022
 */
public class Prostor extends ZakladniPole{
    private String nazev;
    private List<Vec> obsah;
    private Set<Pruchod> vychody;   // obsahuje sousední místnosti

    /**
     * Vytvoření prostoru se zadaným popisem, např. "paluba_A1"
     *
     * @param cislo     udává číslo prostoru
     * @param nazev     nazev prostoru, jednoznačný identifikátor, jedno slovo nebo víceslovný název bez mezer
     */
    public Prostor(int cislo, String nazev) {
        super(cislo);
        this.nazev = nazev;
        vychody = new HashSet<>();
        obsah = new ArrayList<>();
    }

    /**
     * Definuje východ z prostoru (sousední/vedlejsi prostor). Vzhledem k tomu,
     * že je použit Set pro uložení východů, může být sousední prostor uveden
     * pouze jednou (tj. nelze mít dvoje dveře do stejné sousední místnosti).
     * Druhé zadání stejného prostoru tiše přepíše předchozí zadání (neobjeví se
     * žádné chybové hlášení). Lze zadat též cestu ze do sebe sama.
     *
     * @param vedlejsi  prostor, který sousedi s aktualnim prostorem.
     *
     */
    public void setVychod(Pruchod vedlejsi) {
        vychody.add(vedlejsi);
    }

    /**
     * Tato metoda přidává novou věc do prostoru.
     *
     * @param vec   název přidávané věci
     */
    public void pridejVec(Vec vec){
        this.obsah.add(vec);
    }

    /**
     * Tato metoda přidává záchranný člun do prostoru.
     *
     * @param zachrannyClun   název přidávané věci
     */
    public void pridejZachrannyClun(ZachrannyClun zachrannyClun){
        this.obsah.add(zachrannyClun);
    }


    /**
     * Metoda,která zjišťuje zda prostor obsahuje nějaké věci
     *
     * @return  vrací true, když něco obsahuje
     */
    public boolean obsahujeVeci(){
        if (this.obsah.isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * Vrací popis prostoru i s vecma, ktere tam jsou.
     * Priklad vypisu:
     * Jste na plaluba_B1 a zde se nachazi: prazdny kontejner,
     * vychody: paluba_C1 paluba_B2 paluba_A1
     *
     * @return      popis
     */
    public String vypisVeci(){
        StringBuffer vystup = new StringBuffer();
        vystup.append("Jste na " + nazev + " a zde se nachazi: ");
        for(Vec vec: obsah){
            vystup.append(vec.nazev + ", ");
        }
        String konVystup = String.valueOf(vystup);
        if(obsah.isEmpty()) konVystup = "Jste na " + nazev + " a zde se nachazi: tento prostor je prazdny.";
        return konVystup + "\n" + popisVychodu();
    }

    /**
     * Tato metoda odstaní věc z prostoru.
     *
     * @param       nazev název věci, kterou chceme odstranit
     * @return      tato metoda vrací odstraněnou věc
     */
    public Vec odstranVec(String nazev){
    for(Vec vec :obsah) {
        if (vec.nazev.equals(nazev)) {
            this.obsah.remove(vec);
            obsahujeVeci();
            return vec;
        }
    }
    return null;
}

    /**
     * Tato metoda najde věc v daném prostoru pomocí cyklu for:each
     *
     * @param       nazev název hledané věci v konkrétním prostoru
     * @return      vrací najitou věc
     */
    public Vec najdiVec(String nazev){
        for(Vec vec :obsah) {
            if (vec.nazev.equals(nazev))
                return vec;
        }
        return null;
    }

    /**
     * Metoda equals pro porovnání dvou prostorů. Překrývá se metoda equals ze
     * třídy Object. Dva prostory jsou shodné, pokud mají stejný název. Tato
     * metoda je důležitá z hlediska správného fungování seznamu východů (Set).
     *
     * Bližší popis metody equals je u třídy Object.
     *
     * @param o     object, který se má porovnávat s aktuálním
     * @return      hodnotu true, pokud má zadaný prostor stejný název, jinak false
     */  
      @Override
    public boolean equals(Object o) {
        // porovnáváme zda se nejedná o dva odkazy na stejnou instanci
        if (this == o) {
            return true;
        }
        // porovnáváme jakého typu je parametr 
        if (!(o instanceof Prostor)) {
            return false;    // pokud parametr není typu Prostor, vrátíme false
        }
        // přetypujeme parametr na typ Prostor 
        Prostor druhy = (Prostor) o;

        //metoda equals třídy java.util.Objects porovná hodnoty obou názvů. 
        //Vrátí true pro stejné názvy a i v případě, že jsou oba názvy null,
        //jinak vrátí false.

       return (java.util.Objects.equals(this.nazev, druhy.nazev));       
    }

    /**
     * metoda hashCode vraci ciselny identifikator instance, ktery se pouziva
     * pro optimalizaci ukladani v dynamickych datovych strukturach. Pri
     * prekryti metody equals je potreba prekryt i metodu hashCode. Podrobny
     * popis pravidel pro vytvareni metody hashCode je u metody hashCode ve
     * tride Object
     */
    @Override
    public int hashCode() {
        int vysledek = 3;
        int hashNazvu = java.util.Objects.hashCode(this.nazev);
        vysledek = 37 * vysledek + hashNazvu;
        return vysledek;
    }

    /**
     * Vrací název prostoru (byl zadán při vytváření prostoru jako parametr
     * konstruktoru)
     *
     * @return      název prostoru
     */
    public String getNazev() {
        return nazev;
    }

    /**
     * Vrací textový řetězec, který popisuje sousední východy, například:
     * "vychody: hala ".
     *
     * @return      Popis východů - názvů sousedních prostorů
     */
    private String popisVychodu() {
        String vracenyText = "východy:";
        for (Pruchod sousedni : vychody) {
            vracenyText += " " + sousedni.dejDruhejKonec(this).getNazev();
        }
        return vracenyText;
    }

    /**
     * Metoda vratPruchodDoProstoru spojuje dva sousední prostory, že je možné procházet oboustranně.
     *
     * @param nazevSouseda  parametrem je název sousedního prostoru
     * @return      vrací hledaný prostor
     */
    public Pruchod vratPruchodDoProstoru(String nazevSouseda) {
        List<Pruchod>hledaneProstory =
                vychody.stream()
                        .filter(sousedni -> sousedni.dejDruhejKonec(this).getNazev().equals(nazevSouseda))
                        .collect(Collectors.toList());
        if(hledaneProstory.isEmpty()){
            return null;
        }
        else {
            return hledaneProstory.get(0);
        }
    }

    /**
     * Tato metoda vypíše informace o prostoru.
     * A dědí z abstraktní třídy ZakladniPole.
     */
    @Override
    public void getInfoProstoru(){
        super.getInfoProstoru();
        System.out.println("nazev prostoru: " + nazev);
    }
}
