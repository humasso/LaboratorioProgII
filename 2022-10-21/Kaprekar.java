public class Kaprekar {
    public static void main(String[] args) {
        short n = 100;
        byte digits = 3;
        byte[] a = numtoDigitArray(n, digits);
        System.out.println(a);
    }

    // REQUIRES:0<= n<10^digits, digits<6
    // EFFECTS: restituisce il rfiferimento a un array contentente le cifre decimali
    // di n preservandone l'ordine
    public static byte[] numtoDigitArray(short n, byte digits) {
        byte[] a = new byte[digits];
        for (int i = 0; i < digits; i++, n /= 10) {
            a[i] = (byte) (n % 10);
        }
        return a;

    }

    // REQUIRES: a non null, ciascun elemento deve essere compretso tra 0 e 9, il
    // risultatto non deve essere maggiore di 2^16-1
    // EFFECTS: restituisce il numero ottenuto giustapponendo le cifre contenutie in
    // a
    public static short digitArraytoNum(byte[] a) {
        short n = 0;

    }

    // REQUIRES: a non null
    // MODIFIES: a
    // EFFECTS:esegue l'inversione "in-place" dell''ordine degli elementi di a
    void reverseArray(byte[] a) {

    }

    // REQUIRES: 0<n<10000
    // EFFECTS:restiuisce il numero successivo della "sequenza di Kaprekar"
    short stepKaprekar(short n) {
        return 0;
    }

    // REQUIRES: 0<n<10000 n è composto da almeno due cifre divers
    // MODIFIES:System.out
    // EFFECTS: Stampa su standard outpuy la sequenza di Kaprekar a partire da n, un
    // elemento per riga
    void printKraprekarSequence(short n) {
    }

}
