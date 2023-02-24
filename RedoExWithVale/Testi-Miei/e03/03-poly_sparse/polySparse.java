import java.util.ArrayList;
import java.util.List;

import javax.management.Query;

public class polySparse {
    private final List<Integer> terms;
    private final List<Integer> expo;

    /*
     * AF:
     * terms è una lista che contiene i termini dei polinomi
     * expo è una lista che contiene tutti gli esponenti dei polinomi
     */
    /*
     * RI:
     * n>=0
     * La dimensione delle liste Terms ed Expo deve essere uguale
     */

    public polySparse() {
        terms = new ArrayList<Integer>();
        expo = new ArrayList<Integer>();
    }

    public polySparse(int c, int n) throws NegativeExponentException {
        if (n < 0) {
            throw new NegativeExponentException("Martino gay");
        }
        terms = new ArrayList<Integer>();
        expo = new ArrayList<Integer>();
        terms.add(c);
        expo.add(n);
    }

    public polySparse add(polySparse q) {
        polySparse r = this;
        for (int i = 0; i < q.expo.size(); i++) {
            int x = getPosByExpo(r, q.expo.get(i));
            if (x != -1) {
                r.terms.set(x, q.terms.get(i) + r.terms.get(i));
            } else {
                r.terms.add(q.terms.get(i));
                r.expo.add(q.expo.get(i));
            }
        }
        return r;
    }

    public int getPosByExpo(polySparse p, int x) {
        int i;
        for (i = 0; i < p.expo.size(); i++) {
            if (x == p.expo.get(i)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < terms.size(); i++) {
            str += terms.get(i) + "x^" + expo.get(i) + " + ";
        }
        return str;
    }

}
