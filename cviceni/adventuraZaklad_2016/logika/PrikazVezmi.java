package logika;

/**
 *  Třída PrikazVezmi implementuje v této hře příkaz vezmi.
 *  Pomocí příkazu vezmi si může hráč vzít do batohu určitou věc z místnosti, kterou potřebuje.
 *
 *@author     Vojtěch Pitřinec
 *@version    LS 2021/2022
 */

public class PrikazVezmi implements IPrikaz{
    private static final String NAZEV = "vezmi";
    private HerniPlan plan;

    /**
     * Konstruktor třídy
     *
     * @param plan herní plán, ve kterém se bude ve hře "chodit"
     */

    public PrikazVezmi(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     * Tato metoda provádí příkaz 'vezmi'.
     * Když není zadáno jakou věc má vzít nebo se daná věc v prostoru nenachází, tak se vypíše chybové hlášení.
     * Stejně tak, když už nějakou věc v batohu máme, tak nemůžeme vzít další, protože do batohu se vejde vždy pouze jedna věc.
     *
     * @param parametry     jako parametr je zde věc, kterou si bereme do batohu.
     *
     * @return      vrací název věci kterou si hráč vzal
     */

    @Override
    public String provedPrikaz(String... parametry) {

        if (parametry.length == 0) {
            // pokud chybí druhé slovo (věc, kterou chci vzít), tak ....
            return "Co mám vzít? Nezadal jste věc, kterou byste si chtě vzít s sebou do batohu.";
        }

        String branaVec = parametry[0];

        if(plan.vecVBatohu != null){
            return "V batohu se jiz nachazi: " + plan.vecVBatohu.nazev + " Abyste mohli vzit jinou vec musite ji odlozit.";
        }

        //zde testuji ktere veci mohu vzit do batohu
        Vec naselvec = plan.aktualniProstor.najdiVec(branaVec);
        if (naselvec == null) {
            return "tuto vec nelze vzit";
        }
        if (!naselvec.vejdeSeDoBatohu) {
            return "tuto vec nelze vzit";
        }
        plan.vecVBatohu=naselvec;
        plan.aktualniProstor.odstranVec(naselvec.nazev);

        return "Mate v batohu " + naselvec.nazev;
    }

    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *
     *  @return     nazev prikazu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }
}
