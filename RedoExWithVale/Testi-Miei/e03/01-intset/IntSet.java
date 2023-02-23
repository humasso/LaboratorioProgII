import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

//Overview:
/*
Classe che permette di  rappresentare un insieme di interi
*/
public class IntSet {
    // Campi
    List<Integer> elements;

    /*
     * AF(elements): elements rapresenta l'insieme di elementi che saranno presenti
     * nel nostro insieme
     */
    /*
     * IR(Elements):
     * - ogni elemento all'interno di elements può apparire una e una sola volta
     * - non deve contenere elementi nulli
     * - non deve essere nullo
     */
    public IntSet() {
        elements = new ArrayList<Integer>();
    }

    /**
     * Metodo che fornisce il numero di elementi contenuto all'interno dell'insieme
     * 
     * @return
     *         n: il numero di elementi
     */
    public int size() {
        return elements.size();
    }

    /**
     * Restituisce se un l'elemnto è presente o meno all'interno dell'insieme
     * 
     * @param n
     * @return
     */
    public boolean isIn(int n) {
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i) == n) {
                return true;
            }
        }
        return false;
    }

    /**
     * Funzione che aggiunge l'elemnto I all'interno dell'insieme
     * 
     * @param i
     * @throws ElementAlreadyInSet Viene lanciata quando l'elemento è già presente
     *                             nell'insieme
     */
    public void add(int i) throws ElementAlreadyInSet {
        if (isIn(i)) {
            throw new ElementAlreadyInSet("Elemento Già presente");
        }
        elements.add(i);
    }

    /**
     * Funzione che rimuove l'elemnto I dall'insieme
     * 
     * @param i
     * @throws ElementNotInTheSet
     */
    public void remove(int i) throws ElementNotInTheSet {
        if (!isIn(i)) {
            throw new ElementNotInTheSet("Elemento Non presente");

        }
        elements.remove(i);
    }

    /**
     * il metodo con prototipo `int choose()` deve restituire un intero scelto
     * arbitrariamente tra gli elementi di una istanza, e sollevare un'eccezione di
     * tipo `EmptyException` se l'insieme è vuoto;
     * 
     * @return
     * @throws RuntimeException
     */
    public int choose() throws RuntimeException {

        if (size() == 0) {
            throw new RuntimeException("vuoto");
        }
        int n = ThreadLocalRandom.current().nextInt(0, size() + 1);
        return elements.get(n);
    }

    @Override
    public String toString() {
        return "IntSet [elements=" + elements + "]";
    }

}
