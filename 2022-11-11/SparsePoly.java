import java.util.LinkedList;

public class SparsePoly {
    private record Monomio(int degree,int coeff) {
        public Monomio(int degree,int coeff) {
            if (degree<0){
                throw new NegativeExponentExeption("il grado non deve essere minore di 0");
            }
        }
        public String toString() {
            return coeff+"x^"+degree
        }
    }

    // Campi
    List<Monomio> terms;

    /*
     * AF(terms)=
     * terms[0].coeff*x^terms[0].degree+...+terms[n].coeff*x^terms[n].degree
     * if n==0 =>0
     */
    /*
     * RI(terms)=terms[i].degree>=0 && tutti gli elementi di terms devono essere
     * Monomi
     * && terms dev'esere ordnato per grado
     * && tutti gli elmenti di terms devono essere monomi
     */
    // Costruttori
    // EFFECTS: costruisce il polinomio zero
    public SparsePoly() {
        terms = new LinkedList<>();
    }

    // EFFECTS: costruisce il polinomio coeff*x^degree
    public SparsePoly(int coeff, int degree) {
        this();
        if (coeff != 0)
            terms.add(new Monomio(coeff, degree));
    }

    // METODI
    // EFFECTS: restituisce il grado del polinomio
    public int degree() {
        if terms.size()==return -1;
        return terms.get(terms.size()-1).degree;
    }

    // REQUIRES: degree>=0
    // EFFECTS: restituisce il coefficiente relativo a x^degree
    public int coeffByDegree(int degree) {
        return 0;
    }

    // REQUIRES: other non null
    // EFFECTS: restituisce this + other
    public SparsePoly sum(SparsePoly other) {

    }

    // REQUIRES: other non null
    // EFFECTS: restituisce this + other
    public SparsePoly mul(SparsePoly other) {

    }

    // REQUIRES: this non null
    // EFFECTS: restituisce this + other
    public SparsePoly minus(SparsePoly other) {

    }

}
