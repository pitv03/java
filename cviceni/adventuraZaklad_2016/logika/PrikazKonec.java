package logika;

/**
 *  Třída PrikazKonec implementuje pro hru příkaz konec.
 *  pokud hráč dohraje hru do konce, tak se mu na závěr vypíšou body.
 *  Tato třída je součástí jednoduché textové hry.
 *  
 *@author       Vojtěch Pitřinec
 *@version      LS 2021/2022
 *  
 */

class PrikazKonec implements IPrikaz {

    private static final String NAZEV = "konec";
    private Hra hra;
    private HerniPlan plan;

    /**
     *  Konstruktor třídy
     *  
     *  @param hra  odkaz na hru, která má být příkazem konec ukončena
     */    
    public PrikazKonec(Hra hra, HerniPlan plan) {
        this.hra = hra;
        this.plan = plan;
    }

    /**
     * V případě, že příkaz má jen jedno slovo "konec" hra končí(volá se metoda setKonecHry(true))
     * jinak pokračuje např. při zadání "konec a".
     * 
     * @return      zpráva, kterou vypíše hra hráči
     */
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length > 0) {
            return "Ukoncit co? Nechapu, proc jste zadal druhe slovo.";
        }
        else {
            hra.setKonecHry(true);
            return hra.vypisBody();
        }
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
