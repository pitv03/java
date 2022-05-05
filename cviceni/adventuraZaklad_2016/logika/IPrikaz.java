package logika;

/**
 *  Třída implementující toto rozhraní bude ve hře zpracovávat jeden konkrétní příkaz.
 *  Toto rozhraní je součástí jednoduché textové hry.
 *  
 *@author       Vojtěch Pitřinec
 *@version      LS 2021/2022
 *  
 */
interface IPrikaz {
	
	/**
     *  Metoda pro provedení příkazu ve hře.
     *  Počet parametrů je závislý na konkrétním příkazu,
     *  např. příkazy konec a napoveda nemají parametry
     *  příkazy jdi, premisti_objekt, pridej_vybaveni, vezmi, odloz, mají jeden parametr.
     *
     * @param       parametry počet parametrů závisí na konkrétním příkazu.
     *
     * @return
     */
    public Object provedPrikaz(String... parametry);
    
    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *  
     *  @return     nazev prikazu
     */
	public String getNazev();
	
}
