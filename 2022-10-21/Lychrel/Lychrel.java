package Lychrel;

public class Lychrel {

    /**
     * @param args
     */
    public static void main(String[] args) {
        printLychrelSequence(6174);
    }

    /**
     * @param n
     * @return int
     */
    // EFFECTS: restuisce l'intero nell'ordine invertito
    public static String reverse(String n) {
        String reverse = "";
        for (int i = n.length() - 1; i >= 0; i--) {
            reverse += n.charAt(i);
        }
        return reverse;
    }

    // EFFECTS: RESTITUISCE UNA BOOL A SECONDA CHE LA STRINGA SIA PALINDROMA O MENO
    public static boolean isPalindroma(String s) {
        int len = s.length();
        if (len <= 1)
            return true;
        return s.charAt(0) == s.charAt(len - 1) && isPalindroma(s.substring(1, len - 1));
    }

    // REQUIRES: s deve contenere solo numeri
    // EFFECTS: string to num

    public static long stringToNum(String s) {

        long n = 0;
        for (int i = 0; i < s.length(); i++) {
            n *= 10;
            n += s.charAt(i) - '0';
        }
        return n;
    }
    // REQUIRES: s deve contenere solo numeri
    // EFFECTS:lont to strig

    public static String numtoString(long s) {
        return "" + s;
    }

    // REQUIRES: n deve essere positivo e non deve essere un numero di Lychrel
    // Modifies: System.out
    // Effects: Stampa System.out la sequenza di Lychrel
    public static long LychrelStep(long n) {
        return n + stringToNum(reverse(numtoString(n)));
    }

    static void printLychrelSequence(long n) {
        while (!isPalindroma(numtoString(n))) {
            System.out.println(n);

            n = LychrelStep(n);
        }
        System.out.println(n);

    }

}
