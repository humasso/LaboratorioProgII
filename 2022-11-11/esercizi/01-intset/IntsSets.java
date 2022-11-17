import java.util.ArrayList;
import java.util.List;

//Questa classe si occuperà di implementare gli insiemi composti da numeri interi
public class IntsSets {
    // ogni oggetto rappresenterà un insieme

    // Campi
    // Elements sarà la strutturà che rappresenterà il nostro insieme
    private List<Integer> elements;

    // COSTRUTTORI

    /* Costruisce un insieme vuoto */

    public IntsSets() {
        elements = new ArrayList<>();
    }

    /*
     * IR: ogni elemento di elements deve essere diverso da null, elements non deve
     * contenere elementi uguali
     * 
     */
    /*
     * AF(elements ):elements[0]+...+elements[n]
     * if n==0 =>0
     */
    /**
     * AddElement si occupa di Aggiungere un elemento all'insieme a meno che non
     * sia==null o già presente nell'insieme
     * 
     * @param v elemento da aggiungere
     * 
     */
    public void AddElement(int v) {
        if (!elements.contains(v))
            elements.add(v);
    }

    /**
     * 
     * Ritorna un valore boolean se l'elemento è compreso all'interno dell'insieme
     * 
     * @param v valore da controllare
     * @return boolean rappresentante la presenza o meno dell'elemento nell'insieme
     */
    private boolean contains(int v) {
        return elements.contains(v);
    }

    /**
     * Si Occupa di rimuovere l'elemento V dall'interno dell'insieme se presente
     * 
     * @param v elemento che si desiderà rimuovere
     */
    public void RemoveElement(int v) {
        if (elements.contains(v)) { // this qui non serve
            int index = elements.indexOf(v);
            if (index != -1) {
                int lastIndex = elements.size() - 1;
                elements.set(index, elements.get(lastIndex));
                elements.remove(lastIndex);
            }

        }
    }

    /**
     * Si occupa di ritornare il Numero di elementi all'interno dell'isieme
     * 
     * @return
     */
    public int size() {
        return elements.size();
    }

    /**
     * restituisce una rappresentazione testuale dell'insieme this.
     * 
     * @return String
     */
    @Override
    public String toString() {
        String r = "Intset : {";
        if (this.size() > 0) {
            for (int i = 0; i < elements.size() - 1; i++)
                r += elements.get(i) + ", ";
            r += elements.get(elements.size() - 1);
        }
        return r + "}";
    }

    /**
     * Restituisce un elemento scelto arbitrariamente nell'insieme
     * e solleva un'eccezione di tipo EmptyException se l'insieme è vuoto
     * 
     * @return int
     * @throws EmptyException
     * 
     */
    public int choose() throws EmptyException {
        if (this.size() == 0)
            throw new EmptyException("Impossibile estrarre un elemento. Insieme vuoto.");
        return elements.get(elements.size() - 1);
    }

}