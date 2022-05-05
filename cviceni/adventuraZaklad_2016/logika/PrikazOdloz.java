package logika;

/**
 *  Třída PrikazOdloz implementuje v této hře příkaz odloz.
 *  Pomocí příkazu odloz si může hráč odložit věc z batohu, pokud nějakou v batohu má.
 *
 *@author     Vojtěch Pitřinec
 *@version    LS 2021/2022
 */

public class PrikazOdloz implements IPrikaz{
    private static final String NAZEV = "odloz";
    private HerniPlan plan;

    /**
     * Konstruktor třídy
     *
     * @param plan  herní plán, ve kterém se bude ve hře "chodit"
     */
    public PrikazOdloz(HerniPlan plan){
        this.plan = plan;
    }

    /**
     * Tato metoda provádí příkaz 'odloz'.
     * Když se žádná věc v batohu nenachází, tak se hráči vypíše, že je batoh prázdný.
     *
     * @param parametry     zde je parametrem věc, která je v batohu (obsahBatohu)
     *
     * @return      vrací jestli byla věc úspěšně odložena
     */
    @Override
    public String provedPrikaz(String... parametry) {

        if (parametry.length == 0) {
        // pokud chybí druhé slovo (věc, kterou chci vzít), tak ....
        return "Co mám odlozit? Nezadal jste věc, kterou chete odlozit z batohu.";
        }

        String obsahBatohu = parametry[0];

        if(plan.vecVBatohu.nazev.equals(obsahBatohu)){
            plan.aktualniProstor.pridejVec(plan.vecVBatohu);    //zde vracim vec na puvodni misto
            plan.vecVBatohu = null;
        }
        else{
            return "Tato vec se v batohu nenachazi.";
        }
        return "Vec byla odlozena, batoh je prazdny.";
    }

    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *
     *  @return      nazev prikazu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }
}
