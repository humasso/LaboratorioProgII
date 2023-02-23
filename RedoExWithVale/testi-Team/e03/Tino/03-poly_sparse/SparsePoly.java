import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    Overview:Questa classe rappresenta polinomi sparsi a coefficienti reali in una sola variabile, 
    con polinomio sparso intendiamo un polinomio avente molti coefficienti uguali a 0 
*/

public class SparsePoly {
    // Campi
    Map<Integer, Integer> monomi;
    int deg;

    /*
     * AF:le chiavi di questa struttura costituiscono i gradi dei monomi con
     * coefficiente diverso da 0 presenti nel
     * polinomio che rappresento, per rappresentare il polinomio zero creo una
     * struttura di grado 0
     * IR: il polinomio non può essere nullo, ogni chiave può apparire una e una
     * sola volta, le chiavi devono essere > 0,
     * se chiave k!=0 map[k]!=0; altrimenti map[k] può assumere qualsiasi valore
     */
    // COSTRUTTORI
    public SparsePoly() {
        monomi = new HashMap<Integer, Integer>();
        monomi.put(0, 0);
        deg = 0;
    }

    // Effects: dati due interi c ed n costruisce un polinomio avente grado n e che
    // ha come coeffiente di grado n il valore c
    public SparsePoly(int c, int n) throws NegativeExponentException {
        if (n < 0)
            throw new NegativeExponentException("Il grado non può essere negativo");
        monomi = new HashMap<Integer, Integer>();
        monomi.put(n, c);

        deg = n;
    }

    // EFFECTS: restituisce il grado massimo del polinomio
    public int degree() {
        return deg;
    }

    // EFFECTS: restituisce il coefficente del termine di grado n del polinomio, se
    // il grado n è < 0 o >grado massimo del polinomio lancia una
    // IllegalArgumentException
    public int coeff(int n) throws IllegalArgumentException {

        if (n < 0 || n > deg)
            throw new IllegalArgumentException("Grado non accettabile");

        if (monomi.containsKey(n)) {
            return monomi.get(n);
        } else {
            return 0;
        }
    }

    public SparsePoly add(SparsePoly q) {
        SparsePoly eP = new SparsePoly();
        for (Map.Entry<Integer, Integer> entry : monomi.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (eP.monomi.containsKey(key)) {
                value += eP.monomi.get(key);
            }
            eP.monomi.put(key, value);
        }
        for (Map.Entry<Integer, Integer> entry : q.monomi.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (eP.monomi.containsKey(key)) {
                value += eP.monomi.get(key);
            }
            eP.monomi.put(key, value);
        }
        ArrayList<Integer> chiavi = new ArrayList<Integer>();
        for (Map.Entry<Integer, Integer> entry : eP.monomi.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (value == 0) {
                chiavi.add(key);
            }

        }
        for (int i = 0; i < chiavi.size(); i++) {
            int k = chiavi.get(i);
            eP.monomi.remove(k);
        }
        return eP;
    }

    @Override
    public String toString() {

        String vD = "";
        // System.out.println("toString: " + degree());
        for (Map.Entry<Integer, Integer> entry : monomi.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (vD == "" || value < 0) {
                vD += value.toString() + "x^" + key.toString();
            } else {
                vD += "+" + value.toString() + "x^" + key.toString();
            }

        }
        return vD;
    }
}
