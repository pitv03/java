package logika;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída ProstorTest slouží ke komplexnímu otestování
 * třídy Prostor
 *
 * @author    Vojtěch Pitřinec
 * @version   LS 2021/2022
 */
public class ProstorTest {
    //== Datové atributy (statické i instancí)======================================

    //== Konstruktory a tovární metody =============================================
    //== Testovací třída vystačí s prázdným implicitním konstruktorem ----------

    //== Příprava a úklid přípravku ================================================

    /***************************************************************************
     * Metoda se provede před spuštěním každé testovací metody. Používá se
     * k vytvoření tzv. přípravku (fixture), což jsou datové atributy (objekty),
     * s nimiž budou testovací metody pracovat.
     */
    @Before
    public void setUp() {
    }

    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každé testovací metody.
     */
    @After
    public void tearDown() {
    }

    //== Soukromé metody používané v testovacích metodách ==========================

    //== Vlastní testovací metody ==================================================

    /**
     * Testuje, zda jsou správně nastaveny průchody mezi prostory hry. Prostory
     * nemusí odpovídat vlastní hře,
     */
    @Test
    public  void testLzeProjit() {
        Prostor prostor1 = new Prostor(1,"paluba_A1");
        Prostor prostor2 = new Prostor(2,"paluba_B1");
        new Pruchod(prostor1, prostor2, null);
        assertEquals(prostor2, prostor1.vratPruchodDoProstoru("paluba_B1"));
        assertEquals(prostor1, prostor2.vratPruchodDoProstoru("paluba_A1"));

        Prostor prostor3 = new Prostor(4,"paluba_B3");
        Prostor prostor4 = new Prostor(3,"paluba_B2");
        new Pruchod(prostor3, prostor4, null);
        assertEquals(prostor4, prostor3.vratPruchodDoProstoru("paluba_B2"));
        assertEquals(prostor3, prostor4.vratPruchodDoProstoru("paluba_B3"));
    }

}
