package logika;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  Class HerniPlan - třída představující mapu a stav adventury.
 * 
 *  Tato třída inicializuje prvky ze kterých se hra skládá:
 *  vytváří všechny prostory,
 *  propojuje je vzájemně pomocí průchodů
 *  a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 *  Do prostorů jsou zde rovnou přidány i věci, které se v nich budou nacházet.
 *
 *@author     Vojtěch Pitřinec
 *@version    SL 2021/2022
 */
public class HerniPlan {
    
    public Prostor aktualniProstor;
    public Vec vecVBatohu = null;
    public List<Prostor> prostory = new ArrayList<>();
    public boolean posadkaOsvobozena = false;
    
     /**
     *  Konstruktor který vytváří jednotlivé prostory a propojuje je pomocí průchodů.
     *  Jako výchozí aktuální prostor bude kapitánský můstek.
     */
    public HerniPlan() {
        zalozProstoryHry();
    }

    /**
     * Tato metoda hleda potrebny prostor v ArrayListu
     *
     * @param       nazev je nazev hledaneho prostoru
     * @return      kdyz prostor najde, tak vraci hledany prostor. Kdyz ho nenajde vraci null.
     */
    public Prostor najdiProstor (String nazev){
        for(Prostor prostor :prostory) {
            if (prostor.getNazev().equals(nazev))
                return prostor;
        }
        return null;
    }

    /**
     *  Zde se vytváří všechny prostory a věci v prostorech.
     *  A taky si zde prostory ukladam do ArrayListu.
     */
    private void zalozProstoryHry() {
        // vytvářejí se jednotlivé prostory
        Prostor kapitanMustek = new Prostor(1,"kapitansky_mustek");
        prostory.add(kapitanMustek);
        kapitanMustek.pridejVec(new Vec("mapa", null));

        Prostor palubaA1 = new Prostor(2,"paluba_A1");
        prostory.add(palubaA1);
        palubaA1.pridejVec(new Vec("jerab", null, true));

        Prostor palubaA2 = new Prostor(3,"paluba_A2");
        prostory.add(palubaA2);
        palubaA2.pridejVec(new Vec("ocelove_lano", null, true));

        Prostor palubaA3 = new Prostor(4,"paluba_A3");
        prostory.add(palubaA3);

        Prostor palubaB1 = new Prostor(5,"paluba_B1");
        prostory.add(palubaB1);
        palubaB1.pridejVec(new Vec("prazdny_kontejner", null));

        Prostor palubaB2 = new Prostor(6,"paluba_B2");
        prostory.add(palubaB2);
        palubaB2.pridejVec(new Vec("zebrik", null, true));
        palubaB2.pridejVec(new Vec("kontejner_se_zeleninou", null));
        palubaB2.pridejVec(new Vec("kontejner_s_ovocem", null));

        Prostor palubaB3 = new Prostor(7,"paluba_B3");
        prostory.add(palubaB3);
        palubaB3.pridejVec(new Vec("jerab", null, true));
        palubaB3.pridejVec(new Vec("kontejner_s_masem", null));
        palubaB3.pridejZachrannyClun(new ZachrannyClun("zachranny_clun", "jidlo a piti", 10000, 30));

        Prostor palubaC1 = new Prostor(8,"paluba_C1");
        prostory.add(palubaC1);
        palubaC1.pridejVec(new Vec("kontejner_se_drevem", null));
        palubaC1.pridejVec(new Vec("rucni_naradi", null, true));

        Prostor palubaC2 = new Prostor(9,"paluba_C2");
        prostory.add(palubaC2);
        palubaC2.pridejVec(new Vec("kontejner_s_pivem", null));
        palubaC2.pridejVec(new Vec("ocelove_lano", null, true));

        Prostor palubaC3 = new Prostor(10,"paluba_C3");
        prostory.add(palubaC3);
        palubaC3.pridejVec(new Vec("kontejner_s_plysaky",null));

        Prostor palubaD1 = new Prostor(11,"paluba_D1");
        prostory.add(palubaD1);
        palubaD1.pridejVec(new Vec("kontejner_s_notebooky", null));
        palubaD1.pridejVec(new Vec("kontejner_s_tablety", null));
        palubaD1.pridejVec(new Vec("kontejner_s_mobily", null));

        Prostor palubaD2Strojovna = new Prostor(12,"paluba_D2_strojovna");
        prostory.add(palubaD2Strojovna);

        Prostor palubaD3 = new Prostor(13,"paluba_D3");
        prostory.add(palubaD3);
        palubaD3.pridejVec(new Vec("kontejner_s_Ferrari", null));
        palubaD3.pridejVec(new Vec("kontejner_se_sperky", null));

        /**
         * Zde se přiřazují průchody mezi prostory.
         * U některých prostorů je uvedena věc, která bude nutná k prvnímu průchodu.
         */
        new Pruchod(kapitanMustek, palubaA1, null);
        new Pruchod(palubaA1, palubaA2, null);      //pruchody mezi palubami A
        new Pruchod(palubaA2, palubaA3, null);
        new Pruchod(palubaA1, palubaB1, null);      //pruchody mezi palubami A a B
        new Pruchod(palubaA3, palubaB3, null);
        new Pruchod(palubaB1, palubaB2, null);      //pruchody mezi palubami B
        new Pruchod(palubaB2, palubaB3, null);
        new Pruchod(palubaB1, palubaC1, null);      //pruchody mezi palubami B a C
        new Pruchod(palubaB3, palubaC3, new Vec("zebrik", null));
        new Pruchod(palubaC1, palubaC2, null);      //pruchody mezi palubami C
        new Pruchod(palubaC2, palubaC3, new Vec("rucni_naradi", null));
        new Pruchod(palubaC1, palubaD1, null);      //pruchody mezi palubami C a D
        new Pruchod(palubaC3, palubaD3, null);
        new Pruchod(palubaD1, palubaD2Strojovna, null);      //pruchody mezi palubami D
        new Pruchod(palubaD2Strojovna, palubaD3, null);

        aktualniProstor = kapitanMustek;  // hra zacina na kapitanskem mustku
    }
    
    /**
     * Metoda vrací odkaz na aktuální prostor, ve ktetém se hráč právě nachází.
     *
     * @return     aktuální prostor
     */
    
    public Prostor getAktualniProstor() {
        return aktualniProstor;
    }
    
    /**
     * Metoda nastaví aktuální prostor, používá se nejčastěji při přechodu mezi prostory
     *
     * @param     prostor nový aktuální prostor
     */
    public void setAktualniProstor(Prostor prostor) {
        aktualniProstor = prostor;
    }
}
