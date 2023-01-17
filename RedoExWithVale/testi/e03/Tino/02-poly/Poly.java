import java.util.Arrays;

//OVERVIEW: La classe rappresenta un polinomio a coefficenti reali a una sola variabile
public class Poly {
    // Campi
    private final int[] terms;
    private final int deg;

    /**
     * AF:c0*x^0+c1*x^1+...cn*x^n
     */
    /**
     * RI: Il polinomio non può essere nullo
     * n >= 0
     */
    // COSTRUTTORI

    public Poly() {
        this.deg = 0;
        this.terms = new int[1];
    }

    // MODIFIES: this
    // EFFECTS: Dati due valori interi c ed n questo metodo inizializza un polinomio
    // di grado n in cui il termine di grado n ha coefficiente c se n>=0, lancia
    // l'eccezione NegativeExponenteException altrimenti
    /**
     * <p>
     * Costruisce un monomio cx^n
     * 
     * @param c
     * @param n
     * @throws NegativeExponentException
     */
    public Poly(int c, int n) throws NegativeExponentException {
        if (n < 0)
            throw new NegativeExponentException("esponente negativo!");
        if (c == 0) {
            n = 0;
        }
        deg = n;
        this.terms = new int[n + 1];
        this.terms[n] = c;
    }

    // EFFECTS: dato un intero n costruisce un polinomio di grado n con tutti i
    // coefficienti a 0
    /**
     * Genera un polinomio nx^n lancia un eccezione se n<0
     * 
     * @param n
     * @throws IllegalArgumentException
     */
    private Poly(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        deg = n;
        terms = new int[deg + 1];
    }

    // EFFECTS: restituisce il grado massimo del polinomio
    /**
     * Restituisce il grado massimo di un polinomio
     * 
     * @return
     */
    public int degree() {
        return deg;
    }

    // EFFECTS: dato un intero d restiuisce il coefficente del termine di grado d,
    // se il valore d è <0 o >del grado massimo del polinomio che sto considerando
    // lancia l'eccezione IllegalArgumentException
    /**
     * dato un indice restituisce l'elemento n di nx^d
     * 
     * @param d
     * @return
     * @throws IllegalArgumentException
     */

    public int coeff(int d) throws IllegalArgumentException {
        if (d < 0 || d > degree()) {
            throw new IllegalArgumentException("prova");
        }
        return terms[d];
    }

    // MODIFIES: this
    // EFFECTS: Dati due valori interi n e c scrive il valore c in posizione n. Se
    // n<0 o n>degree del polinomio che sto modificando lancio rispettivamente
    // NegativeExponenteException e IllegalArgumentException
    /**
     * Fixx doc
     * 
     * @param n
     * @param c
     * @throws NegativeExponentException
     */
    private void change(int n, int c) throws NegativeExponentException {

        if (n > deg)
            throw new IllegalArgumentException("grado del polinomio non accettato");
        terms[n] = c;
    }

    // EFFECTS: dato un polinomio q esegue la somma
    // chiamo il metodo
    /**
     * Sommo due polinomi
     * 
     * @param q
     * @return
     */
    public Poly add(Poly q) {
        Poly eP;
        int max, min;
        if (degree() >= q.degree()) {
            eP = new Poly(degree());
            max = degree();
            min = q.degree();

        } else {
            eP = new Poly(q.degree());
            max = q.degree();
            min = degree();
        }
        for (int i = 0; i <= min; i++) {
            // System.out.println(i);
            eP.change(i, coeff(i) + q.coeff(i));
        }

        for (int i = min + 1; i <= max; i++) {

            // System.out.println("s:" + i);
            if (max == degree()) {
                eP.change(i, coeff(i));

            } else {
                eP.change(i, q.coeff(i));

            }
        }

        return eP;
    }

    // EFFECTS: restituisce il polinomio opposto
    /**
     * Ritorna un un polinomio opposto
     * 
     * @return
     */
    public Poly minus() {
        Poly poly = new Poly(deg);
        for (int i = 0; i <= deg; i++)
            poly.terms[i] = -terms[i];
        return poly;
    }

    // EFFECTS:dato un polinomio q esegue la differenza
    /**
     * Questo metodo si occupa di eseguire sottrazione tra due polinomi
     * 
     * @param q
     * @return
     */
    public Poly sub(Poly q) {
        return add(q.minus());
    }

    // EFFECTS: dato un polinomio esegue il prodotto
    /**
     * esegue la moltiplicazione tra due polinomi
     * 
     * @param q
     * @return
     */
    public Poly mul(Poly q) {
        if ((q.deg == 0 && q.terms[0] == 0) || (deg == 0 && terms[0] == 0))
            return new Poly();
        Poly eP = new Poly(deg + q.deg);
        for (int i = 0; i <= deg; i++)
            for (int j = 0; j <= q.deg; j++)
                eP.terms[i + j] = eP.terms[i + j] + terms[i] * q.terms[j];
        return eP;
    }

    @Override
    public String toString() {

        String vD = "";
        // System.out.println("toString: " + degree());
        int c = 0;
        for (int i = 1; i <= degree(); i++) {
            if (terms[i] != 0) {
                if (terms[i] < 0 || c == 0) {
                    vD += terms[i] + "x^" + i;
                } else {
                    vD += "+" + terms[i] + "x^" + i;

                }
                c = 1;
            }
        }
        return vD;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(terms);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Poly))
            return false;
        Poly pol = (Poly) obj;
        if (deg != pol.deg)
            return false;
        for (int i = 0; i <= deg; i++) {
            if (terms[i] != pol.terms[i]) {
                return false;
            }
        }
        return true;
    }

}