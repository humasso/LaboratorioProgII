import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/*
 * Overview:
 * Lo scopo di questa classe è quello di rappresentare un insieme di interi il
 * cui il termine insieme è inteso in senso matematico
 */
public class IntSet {
    // Campi
    List<Integer> elements;
    /*
     * AF(elements):i valori contenuti all'interno di elements rappresenteranno i
     * valori contenuti nell'insieme
     */
    /*
     * IR:
     * elements non può contenere elementi nulli
     * elements non può essere nullo
     * ogni elemento con un determinato valore in elements può apparire una e una
     * sola volta
     * 
     */

    // COSTRUTTORE
    public IntSet() {
        elements = new ArrayList<Integer>();
    }

    // MODIFIES: this
    // EFFECTS: dato un valore n questo metodo lo inserisce all'interno dell'insieme
    // se l'elemento non è già presente, altrimenti lancia l'eccezione
    // DuplicateElementException

    /**
     * Questo metodo si occuperà di inserire l'elemento n all'interno dell'insieme.
     * Se dovesse essere già presente lanceremo un eccezione
     * 
     * @param n elemento da inserire
     * @throws DuplicateElementException eccezione lanciata quando l'elemento che
     *                                   vogliamo inserire è già presente
     *                                   nell'insieme
     */
    public void insert(int n) throws DuplicateElementException {
        if (contains(n)) {
            throw new DuplicateElementException("Elemento già presente nell'insieme");
        }
        elements.add(n);
    }

    // MODIFIES: this
    // EFFECTS: dato un valore n lo rimuove dall'insieme se è presente, se non è
    // presente lancia l'eccezioneNoSuchElementsException

    /**
     * Questo metodo si occuperà di rimuovere l'elemento n all'interno dell'insieme.
     * Se non dovesse essere già presente lanceremo un eccezione
     * 
     * @param n elemento da rimuovere
     * @throws NoSuchElementException eccezione da lanciare quando l'elemento non è
     *                                presente
     */
    public void remove(int n) throws NoSuchElementException {
        if (!contains(n)) {
            throw new NoSuchElementException("elemento non presente nell'insieme");
        }
        elements.remove(elements.indexOf(n));
    }

    // EFFECTS: restituisce il numero di elementi presenti nell'insieme
    /**
     * Restituisce il numero di elementi nell'insieme
     * 
     * @return
     */
    public int size() {
        return elements.size();
    }

    // EFFECTS: restituisce un numero arbitrario preso dall'insieme
    public int choose() throws EmptyException {
        if (size() <= 0) {
            throw new EmptyException("Insieme vuoto");
        }
        return elements.get(0);
    }

    // EFFECTS: dato un valore n questo metodo mi restituisce true se n è presente
    // nell'insieme, false altrimenti
    public boolean contains(int n) {
        if (elements.indexOf(n) != -1) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "IntSet [elements=" + elements + "]";
    }

}