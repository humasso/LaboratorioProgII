import java.util.ArrayList;
import java.util.List;

//Questa classe si occuperà di implementare gli insiemi matematici di interi
public class IntsSets {
    // ogni oggetto rappresenterà un insieme

    // Campi
    // Elements sarà la strotturà che rappresenterà il nostro insieme
    private List<Integer> elements;

    // COSTRUTTORI

    /* Costruisce un insieme vuoto */

    public IntsSets() {
        elements = new ArrayList<>();
    }

    /**
     * @param v
     */
    public void AddElement(int v) {
        if (!this.contains(v))
            elements.add(v);
    }

    /**
     * Ritorna un valore boolena se l'elemento è compreso all'interno dell'insieme
     * 
     * @param v valore che si vuole controllare sia all'interno dell'insime
     * @return boolean rappresentante la presenza o meno dell'elemento nell'insieme
     */
    private boolean contains(int v) {
        return elements.contains(v);
    }

    /**
     * L'elemento all'interno dell'insieme verrà rimosso
     * 
     * @param v elemento che si desiderà rimuovere
     */
    public void RemoveElement(int v) {
        if (this.contains(v)) {
            int index = elements.indexOf(v);
            if (index != -1) {
                int lastIndex = elements.size() - 1;
                elements.set(index, elements.get(lastIndex));
                elements.remove(lastIndex);
            }

        } else {
            throw new NoElementInTheSet("L'elemento richiesto non è presente nell' insieme");
        }
    }

    /**
     * @return Numero di elementi dell'insimeme
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
     * Post-condizioni: restituisce un elemento scelto arbitrariamente nell'insieme
     * e solleva un'eccezione di tipo EmptyException se l'insieme è vuoto
     * 
     * @return int
     * @throws EmptyException
     */
    public int choose() throws EmptyException {
        if (this.size() == 0)
            throw new EmptyException("Impossibile estrarre un elemento. Insieme vuoto.");
        return elements.get(elements.size() - 1);
    }

}