package logika;

/**
 *  Třída PrikazJdi implementuje pro hru příkaz jdi.
 *  Tato třída je součástí jednoduché textové hry.
 *  
 *@author       Vojtěch Pitřinec
 *@version      LS 2021/2022
 */
class PrikazJdi implements IPrikaz {
    private static final String NAZEV = "jdi";
    private HerniPlan plan;
    
    /**
    *  Konstruktor třídy
    *  
    *  @param   plan herní plán, ve kterém se bude ve hře "chodit"
    */    
    public PrikazJdi(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     *  Provádí příkaz "jdi". Zkouší se jít do zadaného prostoru. Pokud prostor
     *  existuje, vstoupí se do nového prostoru. Pokud zadaný sousední prostor
     *  (pruchod) není, vypíše se chybové hlášení.
     *
     *@param parametry  jako  parametr obsahuje jméno prostoru (smer),
     *                  do kterého se má jít.
     *@return   zpráva, kterou vypíše hra hráči
     */ 
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybi druhe slovo (sousedni prostor), tak ....
            return "Kam mám jít? Musíš zadat jméno východu";
        }

        String smer = parametry[0];

        // zkousi se prejit do sousedniho prostoru
        Pruchod p = plan.getAktualniProstor().vratPruchodDoProstoru((smer));
        //Prostor sousedniProstor = plan.getAktualniProstor().vratSousedniProstor(smer);

        if (p == null) {
            return "Tam se odsud jít nedá!";
        }

        //tady zamezuju pristupu do Strojovny
        if ((smer.equals("paluba_D2_strojovna")) && (plan.aktualniProstor.obsahujeVeci() == true)) {
            return ("Vchod do paluba_D2_strojovna je zablokovan. \n" +
                    "Musite premistit vsechny objekty z " + plan.aktualniProstor.getNazev() + " do nektere z palub A nebo B.");
        }

        //zde testuji pruchod ze strojovny do D3
        if (plan.aktualniProstor.getNazev().equals("paluba_D2_strojovna") && smer.equals("paluba_D3") && plan.najdiProstor("paluba_D3").obsahujeVeci() == true)
            return "Do prostoru paluba_D3 se ze strojovny dostanete jen kdyz se na palube_D3 nic nenachazi.\n" +
                    "Musite to obejit.";

        //zde testuji pruchod ze strojovny do D1
        if (plan.aktualniProstor.getNazev().equals("paluba_D2_strojovna") && smer.equals("paluba_D1") && plan.najdiProstor("paluba_D1").obsahujeVeci() == true)
            return "Do prostoru paluba_D1 se ze strojovny dostanete jen kdyz se na palube_D1 nic nenachazi.\n" +
                    "Musite to obejit.";

        //tady se testuje zda je potreba k pruchodu do dalsi mistnosti nejaka vec, pokud ano, tak je to pouye pri prvni pruchodu
        else {
            if(p.vec != null && (plan.vecVBatohu== null || !p.vec.nazev.equals(plan.vecVBatohu.nazev))){
                System.out.println("Pruchod se nezdaril. Jsi stale na stejne palube.");
                plan.getAktualniProstor().vypisVeci();
                return "K tomuto pruchodu potrebujes pouzit " + p.vec.nazev + ", ktery se nachazi na nektere palube na lodi.";
            }
            else {
                p.vec = null;
                plan.setAktualniProstor(p.dejDruhejKonec(plan.getAktualniProstor()));
                return plan.getAktualniProstor().vypisVeci();
                //return plan.getAktualniProstor().dlouhyPopis();
            }
        }
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
