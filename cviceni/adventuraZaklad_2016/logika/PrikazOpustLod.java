package logika;

/**
 * Třída OpustLod implementuje pro hru příkaz opust_lod.
 * Tento příkaz se bude používat když už nebudeme chtí dále hrát a budeme chtít opustit lod, pokud to bude možné.
 *
 * @author      Vojtěch Pitřinec
 * @version     LS 2021/2022
 */
public class PrikazOpustLod implements IPrikaz{
    private static final String NAZEV = "opust_lod";
    private HerniPlan plan;
    private Hra hra;

    /**
     * konstruktor třídy PrikazOpustLod
     *
     * @param plan  herní plán, ve kterém se bude ve hře "chodit"
     * @param hra   odkaz na hru, aby se mohla hra ukoncit po opusteni lodi
     */
    public PrikazOpustLod(HerniPlan plan, Hra hra) {
        this.plan = plan;
        this.hra = hra;
    }

    /**
     * Tato metoda provádí příkaz opust_lod.
     * Hráč se během hry může rozhodnout opustit loď, když mu přijde, že loď s posádkou i věcma jsou stracené
     * a že nemá již cenu hrát.
     * Ovšem toto rozhodnutí musí učinit hráč dříve než zachrání posádku, poté již dostane rozkaz loď neopouštět a
     * měl by se pokusit hru dokončit.
     * Abyste mohli použít člun k opuštění lodi, musíte se nacházet v prostoru se záchranným člunem.
     *
     * @param       parametry zde je parametrem zachranny clun, kterym chceme opustit lod
     *
     * @return      metoda vrací buť, že jste opustili lod -> konec hry, nebo se už člun nesmí použít a hrajete dál
     */
    @Override
    public Object provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybi druhe slovo (sousedni prostor), tak ....
            return "V cem mam lod opustit? Nezadali jste presnou vec.";
        }

        String zachLod = parametry[0];

        try {
            if (plan.aktualniProstor.najdiVec(zachLod).equals("zachranny_clun") == false){

            }
        }
        catch (NullPointerException e){
            return "V tomto prostoru se vec (zachranny clun), ve kterem by se dala lod opustit nenachazi.";
        }

        if (plan.posadkaOsvobozena == true){
            return "V tuto chvili se jiz neda pouzit zachranny clun, protoze jste uz vyprostili uveznenou posadku \n" +
                    "a dostali jste rozkaz z pobrezi, ze lod uz opustit nesmite. \n" +
                    "Pokracujte dale v plneni ukolu.";
        }

        //Kdyz je hrac v prostoru se zachrannym clunem muze opustit lod -> hra tim konci
        if (plan.aktualniProstor.najdiVec(zachLod).equals("zachranny_clun") == false){
            hra.setKonecHry(true);
        }
        System.out.println("Opoustite lod v zachrannem clunu:");
        plan.aktualniProstor.najdiVec(zachLod).vypisPopis();
        return "Hra konci. Myslite si, ze nemate sanci na zachranu lodi, ani uveznene posadky uvnitr strojove paluby.";
    }

    /**
     * Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *
     * @return     nazev prikazu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }
}
