//Questa classe permetterà la rappresentazione di polinomi nella  strottura cx^n
public class Poly {
    // Campi
    int c; // moltiplicatore
    int n; // Esponente
    
    // Costruttori
    /**
     * Genera un polinomio 0
     */
    public Poly() {
        this.c = 0;
        this.n = 0;
    }

    /**
     * Genera un polinomio $cx^n$
     * 
     * @param c,n
     * 
     */
    public Poly(int c, int n) {
        if (n < 0)
            throw new NegativeExponentExeption("n non può essere negativo");
        this.n = n;
        this.c = c;
    }

    /**
     * Permette di aggiungere un polinomio Q al polinomio corrente
     * 
     * @param q Polinomio da aggiungere
     * @return Poly Polinomio risolutante dalla somma
     */
    public void add(Poly q) {
        if (this.n != q.n) {
            throw new NotSameDegree("il rango dei polinomi devono essere uguali per  poter essere sommati");
        }
        this.c += c;
        return;

    }

    /**
     * esegue una sottrazione tra polinomi dello stesso rango
     * 
     * @param q
     * @return Poly
     */
    public void sub(Poly q) {
        if (this.n != q.n) {
            throw new NotSameDegree("il rango dei polinomi devono essere uguali per  poter essere sottratti");
        }
        this.c -= c;
        return;

    }

    /**
     * Si occupa di moltiplicare il polinomio corrente per un altro polinomio q
     * 
     * @param q fixx(come specifico l'eccezzione e come faccio riferimento
     *          all'oggetto)
     */
    public void mul(Poly q) {
        if (this.n == q.n) {
            this.c *= q.c;
            // return this;
            return;
        }
        if (this.c == q.c) {
            this.n += q.n;
            // return this;
            return;
        }
        throw new NotSameDegree("il rango dei polinomi devono essere uguali per  poter essere sottratti");

    }

    /**
     * Si occupa di ottenete il polinomio opposto (?drexscvbgtfyrnhumjio,klòà)
     * 
     * @param q
     * @return Poly
     */
    public void minus(Poly q) {
        return;

    }

    /**
     * 
     * Si occupa di resituire il rango del polinomio
     * 
     * @return int
     */
    public int degree() {
        return this.c;

    }

    /**
     * risulta il coefficiente del termine di grado `d
     * 
     * @param d
     * @return int
     */
    public int coeff(int d) {

        return this.c * d ^ this.n;

    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return "Poly:" + c + "x^" + n;
    }

}
