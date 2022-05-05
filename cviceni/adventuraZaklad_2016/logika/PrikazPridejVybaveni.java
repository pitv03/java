package logika;

/**
 *  Třída PrikazPridejVybaveni implementuje v této hře příkaz pridej_vybaveni.
 *  Tento příkaz se bude používat jen v jednom jediném případě a to když bude chtít hráč přidat ocelové lano k jeřábu.
 *
 *@author     Vojtěch Pitřinec
 *@version    LS 2021/2022
 */

public class PrikazPridejVybaveni implements IPrikaz{
    private static final String NAZEV = "pridej_vybaveni";
    private HerniPlan plan;

    /**
     * Konstruktor třídy
     *
     * @param plan      herní plán, ve kterém se bude ve hře "chodit"
     */
    public PrikazPridejVybaveni(HerniPlan plan){
        this.plan = plan;
    }

    /**
     * Tato metoda je určená v této hře pouze k jedné věci a to, aby přidala správné vybavení jeřábu.
     *
     * @param parametry zde je parametrem věc, kterou budeme chtít přidat (pridavaneVybaveni).
     * @return          vrací jestlise věc úspěšně přidala
     */
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo (věc, kterou chci vzít), tak ....
            return "Co mam pridat? Nezadal jste vybaveni, ktere mam pridat. ";
        }

        String pridavaneVybaveni = parametry[0];

        //zde testuji jestli je vec, kterou chci pridat jako vybaveni v prostoru kde se prave nachazim
        Vec vybaveni = plan.aktualniProstor.najdiVec(pridavaneVybaveni);
        if(vybaveni == null) {
            return "Vybaveni " + pridavaneVybaveni + " se v prostoru " + plan.aktualniProstor.getNazev() + " nenachazi.\n" +
                    "Proto ho neni mozne pridat.";
        }

        if (plan.vecVBatohu.nazev.equals("jerab")){
            plan.vecVBatohu.vybaveni = pridavaneVybaveni;
            plan.aktualniProstor.odstranVec(pridavaneVybaveni);
            return "Vybaveni " + pridavaneVybaveni + " bylo pridano.";
        }
        return "Zadne vybaveni pridane nebylo.";
    }

    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *
     *  @return         nazev prikazu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }
}
