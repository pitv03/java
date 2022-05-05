package logika;

import java.time.LocalDate;

/**
 *  Třída Hra - tato třída představuje logiku adventury.
 * 
 *  Toto je hlavní třída  logiky aplikace.
 *  Tato třída vytváří instanci třídy HerniPlan, která inicializuje mistnosti hry
 *  a vytváří seznam platných příkazů a instance tříd provádějící jednotlivé příkazy.
 *  Vypisuje uvítací a ukončovací text hry.
 *  Také vyhodnocuje jednotlivé příkazy zadané uživatelem.
 *
 *@author     Vojtěch Pitřinec
 *@version    LS 2021/2022
 */

public class Hra implements IHra {
    private SeznamPrikazu platnePrikazy;    // obsahuje seznam přípustných příkazů
    private HerniPlan herniPlan;
    private boolean konecHry = false;

    /**
     *  Vytváří hru a inicializuje místnosti (prostřednictvím třídy HerniPlan) a seznam platných příkazů.
     */
    public Hra() {
        herniPlan = new HerniPlan();
        platnePrikazy = new SeznamPrikazu();
        platnePrikazy.vlozPrikaz(new PrikazNapoveda(platnePrikazy));
        platnePrikazy.vlozPrikaz(new PrikazJdi(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazVezmi(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazOdloz(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazPridejVybaveni(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazPremistiObjekt(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazOpustLod(herniPlan, this));
        platnePrikazy.vlozPrikaz(new PrikazKonec(this, herniPlan));
    }

    /**
     *  Vrátí úvodní zprávu pro hráče.
     */
    public String vratUvitani() {
        LocalDate cas = LocalDate.now();
        return "Vítejte!\n" +
               "Jsi členem posádky nákladní lodi, která " + cas + " narazila na skaliska a pomalu ji zaplavuje voda. \n" +
                "Do přístavu kde je suchý dok sice dopluje, ale již bude z velké části zaplavená. \n" +
                "Hlavním úkolem je uvolnit zatarasenou cestu několika členům posádky, kteří se nemohou dostat ven ze spodní strojové paluby (D2). \n" +
                "Dalším úkolem je přestěhovat a zachránit nejdůležitější věci, které se nacházejí v dalších spodních palubách. \n" +
                "Na palubách, kterými procházíš budeš používat strojové zařízení i nástroje, které při dalších úkolech jsou nutné k jejich splnění..\n" +
               "Napište 'napoveda', pokud si nevíte rady, jak hrát dál.\n" +
               "\n" +
               herniPlan.getAktualniProstor().vypisVeci();
    }

    /**
     * Tato metoda zjišťuje co všechno hráč ve hře splnil a za to mu přidělí body.
     *
     * @return      metoda vrací celkový počet bodů
     */
    public String vypisBody(){
        int body = 0;

        //zde testuji jestli byla zachranena posadka
        if (herniPlan.posadkaOsvobozena == true){
            System.out.println("Splnil jste hlavni ukol, zachranil jste posadku. Ziskavate 100 bodu.");
            body += 100;
        }
        else {
            return "Prohral jste! Nesplnil jste ani zakladni ukol.";
        }

        //zde testuji co zbylo v prostoru D3
        if (herniPlan.najdiProstor("paluba_D3").najdiVec("kontejner_se_sperky") == null){
            System.out.println("Zachranil jste kontejner se sperky. Ziskavate 25 bodu.");
            body += 25;
        }
        if (herniPlan.najdiProstor("paluba_D3").najdiVec("kontejner_s_Ferrari") == null){
            System.out.println("Zachranil jste kontejner s Ferrari. Ziskavate 20 bodu.");
            body += 20;
        }

        //zde testuji co zbylo v prostoru D1
        if (herniPlan.najdiProstor("paluba_D1").najdiVec("kontejner_s_notebooky") == null){
            System.out.println("Zachranil jste kontejner s notebooky. Ziskavate 15 bodu.");
            body += 15;
        }
        if (herniPlan.najdiProstor("paluba_D1").najdiVec("kontejner_s_mobily") == null){
            System.out.println("Zachranil jste kontejner s mobily. Ziskavate 15 bodu.");
            body += 15;
        }
        if (herniPlan.najdiProstor("paluba_D1").najdiVec("kontejner_s_tablety") == null){
            System.out.println("Zachranil jste kontejner s tablety. Ziskavate 15 bodu.");
            body += 15;
        }

        if (body < 190){
            return "Vyhral jste castecne. Nemate plny pocet bodu, ale hlavni ukol, zachraneni posadky jste splnil. \n" +
                    "Celkovy pocet bodu je: " + body + "\n" +
                    "Diky, ze jste si zahrali.";
        }
        else {
            return "Vyhral jste!!! Celkovy pocet bodu je: " + body+ "\n" +
                    "Diky, ze jste si zahrali.";
        }
    }
    
    /** 
     * Vrací true, pokud hra skončila.
     */
     public boolean konecHry() {
         return konecHry;
    }

    /**
     *  Metoda zpracuje řetězec uvedený jako parametr, rozdělí ho na slovo příkazu a další parametry.
     *  Pak otestuje zda příkaz je klíčovým slovem  např. jdi.
     *  Pokud ano spustí samotné provádění příkazu.
     *
     *@param  radek     text, který zadal uživatel jako příkaz do hry.
     *@return           vrací se řetězec, který se má vypsat na obrazovku
     */
     public String zpracujPrikaz(String radek) {
        String [] slova = radek.split("[ \t]+");
        String slovoPrikazu = slova[0];
        String []parametry = new String[slova.length-1];
        for(int i = 0; i < parametry.length; i++){
           	parametry[i] = slova[i+1];
        }
        String textKVypsani=" .... ";
        if (platnePrikazy.jePlatnyPrikaz(slovoPrikazu)) {
            IPrikaz prikaz = platnePrikazy.vratPrikaz(slovoPrikazu);
            textKVypsani = (String) prikaz.provedPrikaz(parametry);
        }
        else {
            textKVypsani = "Nevím co tím myslíš? Tento příkaz neznám. ";
        }
        return textKVypsani;
    }
    
     /**
     *  Nastaví, že je konec hry, metodu využívá třída PrikazKonec,
     *  mohou ji použít i další implementace rozhraní Prikaz.
     *  
     *  @param  konecHry    hodnota false = konec hry, true = hra pokračuje
     */
    void setKonecHry(boolean konecHry) {
        this.konecHry = konecHry;
    }
    
     /**
     *  Metoda vrátí odkaz na herní plán, je využita hlavně v testech,
     *  kde se jejím prostřednictvím získává aktualní místnost hry.
     *  
     *  @return             odkaz na herní plán
     */
     public HerniPlan getHerniPlan(){
        return herniPlan;
     }
}
