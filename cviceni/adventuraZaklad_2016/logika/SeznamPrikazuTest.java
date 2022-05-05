package logika;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída SeznamPrikazuTest slouží ke komplexnímu otestování třídy
 * SeznamPrikazu
 *
 * @author    Vojtěch Pitřinec
 * @version   LS 2021/2022
 */
public class SeznamPrikazuTest {
    private Hra hra;
    private PrikazKonec prKonec;
    private PrikazJdi prJdi;
    private PrikazJdi prOdloz;
    private PrikazJdi prPremistiObjekt;
    private PrikazJdi prPridejVybaveni;
    private PrikazJdi prVezmi;

    @Before
    public void setUp() {
        hra = new Hra();
        prKonec = new PrikazKonec(hra, new HerniPlan());
        prJdi = new PrikazJdi(hra.getHerniPlan());
        prOdloz = new PrikazJdi(hra.getHerniPlan());
        prPremistiObjekt = new PrikazJdi(hra.getHerniPlan());
        prPridejVybaveni = new PrikazJdi(hra.getHerniPlan());
        prVezmi = new PrikazJdi(hra.getHerniPlan());
    }

    @Test
    public void testVlozeniVybrani() {
        SeznamPrikazu seznPrikazu = new SeznamPrikazu();
        seznPrikazu.vlozPrikaz(prKonec);
        seznPrikazu.vlozPrikaz(prJdi);
        seznPrikazu.vlozPrikaz(prOdloz);
        seznPrikazu.vlozPrikaz(prPremistiObjekt);
        seznPrikazu.vlozPrikaz(prPridejVybaveni);
        seznPrikazu.vlozPrikaz(prVezmi);
        assertEquals(prKonec, seznPrikazu.vratPrikaz("konec"));
        assertEquals(prJdi, seznPrikazu.vratPrikaz("jdi"));
        assertEquals(prOdloz, seznPrikazu.vratPrikaz("odloz"));
        assertEquals(prPremistiObjekt, seznPrikazu.vratPrikaz("premisti_objekt"));
        assertEquals(prPridejVybaveni, seznPrikazu.vratPrikaz("pridej_vybaveni"));
        assertEquals(prVezmi, seznPrikazu.vratPrikaz("vezmi"));
        assertEquals(null, seznPrikazu.vratPrikaz("napoveda"));
    }
    @Test
    public void testJePlatnyPrikaz() {
        SeznamPrikazu seznPrikazu = new SeznamPrikazu();
        seznPrikazu.vlozPrikaz(prKonec);
        seznPrikazu.vlozPrikaz(prJdi);
        seznPrikazu.vlozPrikaz(prOdloz);
        seznPrikazu.vlozPrikaz(prPremistiObjekt);
        seznPrikazu.vlozPrikaz(prPridejVybaveni);
        seznPrikazu.vlozPrikaz(prVezmi);
        assertEquals(true, seznPrikazu.jePlatnyPrikaz("konec"));
        assertEquals(true, seznPrikazu.jePlatnyPrikaz("jdi"));
        assertEquals(true, seznPrikazu.jePlatnyPrikaz("odloz"));
        assertEquals(true, seznPrikazu.jePlatnyPrikaz("premisti_objekt"));
        assertEquals(true, seznPrikazu.jePlatnyPrikaz("pridej_vybaveni"));
        assertEquals(true, seznPrikazu.jePlatnyPrikaz("vezmi"));
        assertEquals(false, seznPrikazu.jePlatnyPrikaz("napoveda"));
        assertEquals(false, seznPrikazu.jePlatnyPrikaz("Konec"));
    }

    @Test
    public void testNazvyPrikazu() {
        SeznamPrikazu seznPrikazu = new SeznamPrikazu();
        seznPrikazu.vlozPrikaz(prKonec);
        seznPrikazu.vlozPrikaz(prJdi);
        seznPrikazu.vlozPrikaz(prOdloz);
        seznPrikazu.vlozPrikaz(prPremistiObjekt);
        seznPrikazu.vlozPrikaz(prPridejVybaveni);
        seznPrikazu.vlozPrikaz(prVezmi);
        String nazvy = seznPrikazu.vratNazvyPrikazu();
        assertEquals(true, nazvy.contains("konec"));
        assertEquals(true, nazvy.contains("jdi"));
        assertEquals(true, nazvy.contains("odloz"));
        assertEquals(true, nazvy.contains("premisti_objekt"));
        assertEquals(true, nazvy.contains("pridej_vybaveni"));
        assertEquals(true, nazvy.contains("vezmi"));
        assertEquals(false, nazvy.contains("napoveda"));
        assertEquals(false, nazvy.contains("Konec"));
    }
}
