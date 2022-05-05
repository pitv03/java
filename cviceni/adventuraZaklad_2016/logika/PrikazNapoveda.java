package logika;

/**
 *  Třída PrikazNapoveda implementuje pro hru příkaz napoveda.
 *  Tato třída je součástí jednoduché textové hry.
 *  
 *@author       Vojtěch Pitřinec
 *@version      LS 2021/2022
 *  
 */
class PrikazNapoveda implements IPrikaz {
    
    private static final String NAZEV = "napoveda";
    private SeznamPrikazu platnePrikazy;
    
    
     /**
    *  Konstruktor třídy
    *  
    *  @param platnePrikazy seznam příkazů,které je možné ve hře použít,
    *                       aby je nápověda mohla zobrazit uživateli. 
    */    
    public PrikazNapoveda(SeznamPrikazu platnePrikazy) {        //konstruktor
        this.platnePrikazy = platnePrikazy;
    }
    
    /**
     *  Vrací základní nápovědu po zadání příkazu "napoveda". Nyní se vypisuje
     *  vcelku primitivní zpráva a seznam dostupných příkazů.
     *  
     *  @return     nápověda ke hře
     */
    @Override
    public String provedPrikaz(String... parametry) {
        return "Hlavním úkolem je uvolnit zatarasenou cestu několika členům posádky, který jsou uvězněni na palubě_D2_strojovna. \n" +
                "V důsledku nárazu lodi se kontejnery sesypaly a blokují oba východy. \n" +
                "Je potřeba uvolnit alespoň jeden vychod ze strojovny a to tak, že přemístíš pomocí jeřábu všechny kontejney \n" +
                "z paluby D3 nebo D1 na nějaké volné paluby A nebo B. \n" +
                "Dalším úkolem je přestěhovat a zachránit 5 nejdůležitějších kontejnerů: kontejner se šperky, s Ferrari, s notebooky, s mobily, s tablety. \n" +
                "(Některé z těchto kontejnerů budeš muset přemístit už jen kvůli záchraně posádky.) \n" +
                "Dva průchody na lodi jsou zablokované, ty budeš muset nějakým způsobem odblokovat. \n" +
                "Více se dozvíš až přímo při hře. \n" +
                "\n" +
                "Pozn.: \n" +
                " - Příkaz pridej_vybaveni se použije tehdy, když potřebujete 'zprovoznit' nějakou věc. \n" +
                "   např.: Pro přidání vybavení k jeřábu je potřeba mít jeřáb v batohu a musíte se nacházet v prostoru s ocelovým lanem. \n"
        + "\n"
        + "Můžeš zadat tyto příkazy:\n"
        + platnePrikazy.vratNazvyPrikazu();
    }
    
     /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *  
     *  @ return    nazev prikazu
     */
    @Override
      public String getNazev() {
        return NAZEV;
     }
}
