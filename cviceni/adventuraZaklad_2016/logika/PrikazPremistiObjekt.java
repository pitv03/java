package logika;

import java.util.Scanner;
import java.util.SimpleTimeZone;

/**
 *  Třída PrikazPremistiObjekt implementuje v této hře příkaz premisti_objekt.
 *  Aby hráč mohl přemístit objekt (kontejner) musí mít u sebe v batohu jeřáb.
 *  aby mohl použít jeřáb, musí ho hráč dovybavit ocelovým lanem.
 *  Hráč může přemísťovat objekty pouze do palub třídy A nebo B.
 *  Hráč může přemístit objek pouze z místnosti, ve které se právě nachází.
 *
 *@author     Vojtěch Pitřinec
 *@version    LS 2021/2022
 */

public class PrikazPremistiObjekt implements IPrikaz{
    private static final String NAZEV = "premisti_objekt";
    private HerniPlan plan;

    /**
     * Konstruktor třídy
     *
     * @param plan      herní plán, ve kterém se bude ve hře "chodit"
     */
    public PrikazPremistiObjekt(HerniPlan plan){
        this.plan = plan;
    }

    /**
     * Tato metoda kontroluje zda je se objekt přemísťuje do správného koncového prostoru.
     * Dále 'přenáší' požadovaný objekt z prostoru, kde se hráč nachází do koncového prostoru.
     */
    public String premisteniObjektu(Vec premistovanaVec){
        Scanner s = new Scanner(System.in);
        System.out.println("Zadejte prostor, kam chcete premistit objekt: ");
        String konProstor = s.nextLine();

        //Zde testuji koncovy prostor
        switch (konProstor){
            case "paluba_A1":
                System.out.println("Ano, do tohoto prostoru muzete objekt premistit.");
                break;
            case "paluba_A2":
                System.out.println("Ano, do tohoto prostoru muzete objekt premistit.");
                break;
            case "paluba_A3":
                System.out.println("Ano, do tohoto prostoru muzete objekt premistit.");
                break;
            case "paluba_B1":
                System.out.println("Ano, do tohoto prostoru muzete objekt premistit.");
                break;
            case "paluba_B2":
                System.out.println("Ano, do tohoto prostoru muzete objekt premistit.");
                break;
            case "paluba_B3":
                System.out.println("Ano, do tohoto prostoru muzete objekt premistit.");
                break;
            default:
                return "Takovy cilovy prostor neexistuje, nebo se tam neda objekt prestehovat.";
        }

        Prostor cilovyProstor = plan.najdiProstor(konProstor);
        if(cilovyProstor==null) {
            return "Cilovy prostor neexistuje.";
        }
        else{
            plan.aktualniProstor.odstranVec(premistovanaVec.nazev);
            cilovyProstor.pridejVec(premistovanaVec);
            if ((plan.aktualniProstor.getNazev().equals("paluba_D3") || (plan.aktualniProstor.getNazev().equals("paluba_D1"))) &&
            plan.aktualniProstor.obsahujeVeci() == false && plan.posadkaOsvobozena == false){
                plan.posadkaOsvobozena = true;
                return "Objekt uspesne premisten.\n" +
                        "Posadka je osvobozena.";
            }
            return "Objekt uspesne premisten.";
        }
    }

    /**
     * V této metodě ověřuji zda mám v batohu jeřáb a jestli má jeřáb u sebe pořebné vybavení - ocelové lano.
     * Když chybí jeřáb nebo u jeřábu lano, tak to hráče okamžitě upozorní a nebude moci přemístit objekt.
     * Součástí této metody je také metoda premisteniObjektu(), ta je popsána výše.
     *
     * @param parametry     objekt (kontejner),který chceme přemístit
     *
     * @return      vrací zda se objekt zdárně přemístil
     */
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo (věc, kterou chcete premistit), tak ....
            return "Co chcete premistit? Nezadal jste objekt, ktery chcete ptremistit.";
        }

        String premistovanyObjekt = parametry[0];

        //podminka jestli vubec se v batohu nachazi jerab
        try {
            if(!plan.vecVBatohu.nazev.equals("jerab")){
                //return "V batohu se jerab nenachazi. Musite si ho nejdrive vyzvednout.";
            }
        }
        catch (NullPointerException e ) {
            return "V batohu se jerab nenachazi. Musite si ho nejdrive vyzvednout.";
        }

        //zde uveruji jestli ma u sebe jerab ocelove lano
        try {
            if (!plan.vecVBatohu.vybaveni.equals("ocelove_lano")) {
                //return "V batohu se jerab sice nachazi, ale k premisteni objektu musi mit jerab u sebe vybaveni - ocelove_lano.";
            }
        }
        catch (NullPointerException e ) {
            return "V batohu se jerab sice nachazi, ale k premisteni objektu musi mit jerab u sebe vybaveni - ocelove_lano.";
        }

        //zde kontroluji jestli se hledana vec nachazi v aktualnim prostoru
        Vec premistovanaVec = plan.aktualniProstor.najdiVec(premistovanyObjekt);
        if(premistovanaVec == null)
            return "takova vec tady neni";
        else
            return premisteniObjektu(premistovanaVec);
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
