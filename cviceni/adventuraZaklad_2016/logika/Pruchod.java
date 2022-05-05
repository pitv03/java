package logika;

/**
 *  Třída Pruchod implementuje v této hře průchody mezi prostorama.
 *  Slouží k zaznamenání z kterého a do kterého prostoru jdu.
 *  Nové průchody vytvářím v herním plánu.
 *
 *@author     Vojtěch Pitřinec
 *@version    LS 2021/2022
 */

public class Pruchod {
    private Prostor prostor_1;
    private Prostor prostor_2;
    public Vec vec;

    /**
     * Konstruktor třídy
     *
     * @param prostor_1     označuje jeden z prostorů mezi kterýma se budu pohybovat
     * @param prostor_2     označuje jeden z prostorů mezi kterýma se budu pohybovat
     * @param vec           když je u průchodu uveden nějaký parametr věc, znamená to, že abychom mohli tímto průchodem projít,
     *                      tak tuto věc musíme mít při prvním procházení s sebou v batohu.
     */
    public Pruchod(Prostor prostor_1, Prostor prostor_2, Vec vec){
        this.prostor_1 = prostor_1;
        this.prostor_2 = prostor_2;
        this.vec = vec;
        prostor_1.setVychod(this);
        prostor_2.setVychod(this);
    }

    /**
     * Tato metoda nám říká, který z prostor_1 a prostor_2 je počáteční a který koncový.
     *
     * @param prvniKonec    toto je parametr prostoru, ze kterého jdeme do sousedního prastoru.
     * @return              vrací to cílový prostor, kam chceme jít.
     */
    public Prostor dejDruhejKonec(Prostor prvniKonec)
    {
        if(prvniKonec==prostor_1)
            return prostor_2;
        else return prostor_1;
    }
}
