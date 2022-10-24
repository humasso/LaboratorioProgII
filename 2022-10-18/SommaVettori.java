public class SommaVettori {
    /*
     * Funzionamento che restituiesce la somma dei valori avuti per argomento
     * REQUIRES: valori!=null
     * MODIFIES: Niente
     * EFFECTS: restituisce un intero s ugule alla somma di tutti ghli elementi dei
     * valori
     * 
     */

    static int sommaVettore(int[] valori) {
        int valoriTotali = 0;
        for (int i = 0; i < valori.length; i++) {
            valoriTotali += valori[i];
        }
        return valoriTotali;
    }

    public static void main(String[] args) {
        int[] peso = new int[] { 50, 60, 90 };
        int[] telefoni = new int[] { 1, 4, 3, 5, 2 };

        System.out.println(sommaVettore(peso));
        System.out.println(sommaVettore(telefoni));

    }
}
