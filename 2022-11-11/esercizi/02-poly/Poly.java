//Questa classe permetterà la rappresentazione di polinomi nella  strottura cx^n
public class Poly {
    // Campi
    int c;
    int n;

    // Costruttori
    /**
     * Genera un polinomio 0
     */
    public Poly() {
        this.c = 0;
        this.n = 0;
    }

    /**
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
    public Poly add(Poly q) {
        if (this.n != q.n) {
            throw new NotSameDegree("il rango dei polinomi devono essere uguali per  poter essere sommati");
        }
        this.c += c;
        return this;

    }

    /**
     * esegue una sottrazione tra polinomi dello stesso rango
     * 
     * @param q
     * @return Poly
     */
    public Poly sub(Poly q) {
        if (this.n != q.n) {
            throw new NotSameDegree("il rango dei polinomi devono essere uguali per  poter essere sottratti");
        }
        this.c -= c;
        return this;

    }

    /**
     * @param q
     * @return Poly
     */
    public Poly mul(Poly q) {
        if (this.n == q.n) {
            this.c *= q.c;
            return this;
        }
        if (this.c == q.c) {
            this.n += q.n;
            return this;
        }
        throw new NotSameDegree("il rango dei polinomi devono essere uguali per  poter essere sottratti");

    }

    /**
     * @param q
     * @return Poly
     */
    public Poly minus(Poly q) {
        return q;

    }

    /**
     * @return int
     */
    public int degree() {
        return c;

    }

    /**
     * @param d
     * @return int
     */
    public int coeff(int d) {
        return d;

    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return "Poly:" + c + "x^" + n;
    }

}
