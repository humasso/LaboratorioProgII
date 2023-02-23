import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class IntSet {
    List<Integer> elements;

    /**
     * ABS:
     * elemets rappresenterà i singoli elementi appartenenti all'insieme
     * 
     */
    /**
     * RI:
     * elements non deve contenere elementi ripetuti
     */
    /**
     * Inizializza un isieme vuoto
     */
    public IntSet() {
        elements = new ArrayList<Integer>();
    }

    /**
     * Sceglie un elemento a caso dal set, lancia un eccezione se è vuoto
     * 
     * @return
     * @throws EmptySetExeption
     */
    public int choose() throws EmptySetExeption {
        if (isEmpty()) {
            throw new EmptySetExeption("the set is empty");
        }

        Random rand = new Random();
        int int_random = rand.nextInt(elements.size());
        return elements.get(int_random);
    }

    /**
     * Restitusce una boolean se il set è full oppure no
     * 
     * @return
     */
    public boolean isEmpty() {
        return elements.isEmpty();

    }

    /**
     * Restiusce il numero di elementi appartenenti al set
     * 
     * @return
     */
    public int size() {
        return elements.size();

    }

    /**
     * Restituisce un booleano se l'elemento x è contenuto all'interno dell'isieme
     * 
     * @param x
     * @throws EmptySetExeption viene lanciata se l'insieme è vuoto
     * @return
     * 
     */
    public boolean contains(int x) throws EmptySetExeption {
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i) == x) {
                return true;
            }
        }
        return false;
    }

    /**
     * Aggiungo l'elemeneto all'interno dell'insieme a patto che non sia già
     * presente
     * 
     * @param x
     */
    public void add(int x) {

        if (contains(x)) {
            System.out.println("elemento " + x + " già presente");
        } else {
            elements.add(x);
        }

    }

    public int getPos(int x) {
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i) == x) {
                return i;
            }
        }
        return -1;

    }

    /**
     * Rimuove l'ememento x dall'insieme. Se l'insieme è vuoto l'ancia un eccezione
     * se invece non è contenuto stampa
     * 
     * @param x
     * @throws NoSuchElementException
     */
    public void remove(int x) throws NoSuchElementException {
        if (isEmpty()) {
            throw new EmptySetExeption("the set is empty");

        }
        if (contains(x)) {
            int j = getPos(x);
            elements.remove(j);
        } else {
            throw new NoSuchElementException("l'element non c'è");
        }
    }

    @Override
    public String toString() {
        return "elements=" + elements;
    }

}
