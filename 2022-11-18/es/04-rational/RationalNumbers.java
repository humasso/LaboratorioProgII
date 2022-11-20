public class RationalNumbers {

    /**
     * AF:(numerator, denominator) numerator/denominator
     */
    /**
     * RI(numerartor, denomina) denominator!= 0
     */
    // Campi
    int numerator;
    int denominar;

    public RationalNumbers(int numerator, int denominar) {
        if (denominar == 0) {
            throw new IllegalArgumentException("il denominatore non può essere  minore  di 0");
        }
        this.numerator = numerator;
        this.denominar = denominar;
    }

    /**
     * Restituisce la somma tra il valore corrente è il numero n
     * 
     * @param n
     */

    public void somma(RationalNumbers n) {
        numerator = numerator * n.denominar + n.numerator;
        denominar *= n.denominar;

    }

    /**
     * Restituisce la sottrazione tra il valore corrente è il numero n
     * 
     * @param n
     */

    public void sottrazione(RationalNumbers n) {
        numerator = numerator * n.denominar - n.numerator;
        denominar *= n.denominar;
    }

    /**
     * Restituisce la moltiplicazione tra il valore corrente è il numero n
     * 
     * @param n
     */

    public void moltiplicazione(RationalNumbers n) {
        numerator *= n.numerator;
        denominar *= n.denominar;
    }

    /**
     * Restituisce la divisione tra il valore corrente è il numero n
     * 
     * @param n
     */

    public void divisione(RationalNumbers n) {
        numerator *= n.denominar;
        denominar *= n.numerator;

    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof RationalNumbers) {
            RationalNumbers g = (RationalNumbers) obj;
            return ((g.numerator / g.denominar) == (numerator / denominar));
        }
        return false;
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "[" + numerator + "," + denominar + "]";
    }

}
