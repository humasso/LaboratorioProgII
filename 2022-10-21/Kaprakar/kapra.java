import java.util.Arrays;

public class kapra {
    public static void main(String[] args) {
        byte[] n = { 0, 1, 2 };
        reverse(n);
        printKaprekar((short) 1709);
    }

    /*
     * REQUIRES: a non null
     * MODIFIES: a
     * EFFECTS: esegue l'inversione di a
     */
    public static void reverse(byte[] a) {
        for (byte i = 0; i < a.length / 2; i++) {
            byte tmp = a[i];
            a[i] = a[a.length - 1 - i];
            a[a.length - 1 - i] = tmp;
        }
    }

    /*
     * REQUIRES: 0<n<10000,digits < 6
     * EFFECTS: trasforma n in un array di cifre
     */
    public static byte[] numtoDigits(short n, int j) {
        byte[] a = new byte[j];
        for (int i = (int) j - 1; i >= 0; i--, n /= 10) {
            a[i] = (byte) (n % 10);
        }
        return a;
    }

    /*
     * REQUIRES:a non null, ciascun elemento deve essere compreso tr 0 e 0
     * EFFECTS: trasforma l'array in un intero,concatenando le cifre
     */
    public static short digitstoNum(byte[] a) {
        short n = 0;
        for (byte b : a) {
            if (b < 0 || b > 9) {
                throw new IllegalArgumentException("Valori attesi per argomento compresi tra 0 e 9. Trovato: " + b);
            }
            n = (short) (n * (short) 10 + b);
        }
        return n;

    }

    /*
     * REQUIRES: un numero n compreso tra 0 e 10000 (esclusi )
     * EFFECTS: restiuisce il numero successivo della "sequenza di Kaprekar"
     */
    public static short stepKaprekar(short n) {
        byte[] digits = numtoDigits(n, 4);
        System.out.println(Arrays.toString(digits));
        Arrays.sort(digits);
        n = (short) -digitstoNum(digits);
        reverse(digits);

        return (short) (n + digitstoNum(digits));

    }

    /*
     * REQUIRES: n non null,un numero n compreso tra 0 e 10000 (esclusi )
     * MODIFIES: system.out
     * EFFECTS: Stampa su standard outpuy la sequenza di Kaprekar a partire da n, un
     * elemento per riga
     */
    public static void printKaprekar(short n) {
        if (n < 1 || n > 9999)
            throw new IllegalArgumentException(
                    "Il numero in input deve avere al più 4 cifre e dev'essere positivo.");

        System.out.println(n);
        while (n != 6174) {
            n = stepKaprekar(n);
            if (n == 0)
                throw new IllegalArgumentException(
                        "Almeno due cifre dl numero in input deve essere diverse.");
            System.out.println(n);
        }
    }

}
