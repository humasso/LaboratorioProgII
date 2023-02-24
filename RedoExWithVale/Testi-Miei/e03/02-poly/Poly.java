
//Overview:
/*
    Scopo dell'esercizio è progettare e implementare una gerarchia di oggetti utili
    a rappresentare *polinomi in una sola variabile* a coefficienti interi.
*/

public class Poly {
    // Campi
    private final int[] trms;
    private final int deg;

    /*
     * AF:
     * c ed n rappresenteranno una serie di monomi a partire da
     * c_0+c_1*x*1+...+c*x^n
     */
    /*
     * RI:
     * n>=0
     */
    public Poly(int c, int n) throws NegativeExponentException {
        if (!(n >= 0)) {
            throw new NegativeExponentException("esponente maggio di 0");
        }
        deg = n;
        trms = new int[deg + 1];
        trms[deg] = c;
    }

    public Poly(int n) throws NegativeExponentException {
        if (!(n >= 0)) {
            throw new NegativeExponentException("esponente maggio di 0");
        }
        deg = n;
        trms = new int[deg + 1];
    }

    public Poly() {
        deg = 0;
        trms = new int[1];

    }

    /**
     * Restituisce il grado del polinomio
     * 
     * @return
     */
    public int degree() {
        return deg;
    }

    /**
     * Restituisce l'elemento di grado d
     * 
     * @param d :grado dell'elemento da prelevare
     * @return
     */
    public int getElement(int d) {
        if (d < 0 || d > deg)
            return 0;
        return trms[d];
    }

    /**
     * Sommo due polinomi
     * 
     * @param q
     * @return
     */
    public Poly add(Poly q) {
        Poly lm;
        Poly r;

        if (this.degree() >= q.degree()) {
            r = this;
            lm = q;

        } else {
            r = q;
            lm = this;

        }
        Poly fin = new Poly(r.degree());
        int i;
        for (i = 0; i <= lm.degree(); i++) {
            fin.trms[i] = lm.getElement(i) + r.getElement(i);
        }
        for (int j = i; j <= r.degree(); j++) {
            fin.trms[j] = r.getElement(j);

        }
        return fin;
    }

    /**
     * Sottraggo due polinomi
     * 
     * @param q
     * @return
     */
    public Poly sub(Poly q) {
        return add(q.minus());
    }

    /**
     * Moltiplico due polinomi
     * 
     * @param q
     * @return
     */

    public Poly mult(Poly q) {
        Poly lm;
        Poly r;

        if (this.degree() >= q.degree()) {
            r = this;
            lm = q;

        } else {
            r = q;
            lm = this;

        }
        Poly fin = new Poly(r.degree());
        int i;
        for (i = 0; i <= lm.degree(); i++) {
            fin.trms[i] = r.getElement(i) * lm.getElement(i);
        }
        for (int j = i; j <= r.degree(); j++) {
            fin.trms[j] = r.getElement(j);

        }
        return fin;
    }

    /**
     * Inverto il segno del polinomi
     * 
     * @param q
     * @return
     */
    public Poly minus() {
        Poly r = new Poly(degree());
        for (int i = 0; i <= degree(); i++) {
            r.trms[i] = -this.getElement(i);
        }
        return r;
    }

    @Override
    public String toString() {
        String str = "";
        int i;
        str += getElement(0) + "x^" + 0;

        for (i = 1; i <= degree(); i++) {
            if (getElement(i) >= 0) {
                str += "+";
            } else {
                str += "";
            }

            str += getElement(i) + "x^" + i;
        }

        return str;
    }

}
