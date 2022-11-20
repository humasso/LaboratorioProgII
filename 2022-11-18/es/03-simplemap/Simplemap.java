import java.util.ArrayList;
import java.util.List;

// Overview:
/**
 * questa classe si occuperà di rappresentare un oggetto di tipo Map.
 * La struttura della mappa sarà con chiavi singole a ad ognuna di esse sarà
 * associato un valore numerico.
 * Ogni chiave sarà una Stringa univoca e il valore associato sarà un intero.
 * 
 */
public class Simplemap {
    /*
     * AF(elements):{ k_i: v_i | per ogni i = 1, ..., n, k_i = elements[i]keys, v_i
     * = elementes[i].values}
     * 
     */
    /*
     * RI:
     * elements[i].value non deve essere mai null $\forall i \to 0\leq i \leq n$
     * // * elements[i].key non deve essere mai null $\forall i \to 0\leq i \leq n$
     * elements[i] non deve essere mai null $\forall i \to 0\leq i \leq n$
     * elements[i].key!=elements[j].key $\forall j \to 0\leq j \leq n$ con i!=j
     * elements non deve essere null
     * 
     */

    // Campi
    private record mapEl(String key, int value) {

        public mapEl {
            if (key.equals(null) || key.equals("")) {
                throw new IllegalArgumentException("key non può essere null/vuota");
            }

        }

        public String toString() {
            return "[" + key + ":" + value + "]";
        }

    }

    List<mapEl> elements;

    /**
     * Si occuperà di inizializzare la nostra mappa
     */
    public Simplemap() {
        elements = new ArrayList<mapEl>();
    }

    /**
     * Questo metodò si occuperà di aggiugere il nuovo elemento passato come
     * parametro all'interno della mappa. Se l'elemento key è già presente non
     * faccio nulla
     * 
     * @param key
     * @param value
     * 
     * 
     * 
     * 
     */
    public void put(String key, int value) {
        // System.out.println(key + " " + value);
        if (!contains(key)) {
            elements.add(new mapEl(key, value));
        }
    }

    /**
     * Metodo che ritorna la posizione dell'elemento avendo la chiave = key
     * 
     * @param key
     * @return
     */
    public int getIndex(String key) {
        int g = 0;
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).key.equals(key)) {

                return g;
            }
            g++;
        }
        return -1;
    }

    /**
     * Questo Metodo si occuperà di rimuovere l'elemento dalla mappa avente come
     * chiave key. Se l'elemento non dovesse essere contenuto non farà nulla
     * 
     * 
     * @param key
     * @throws IllegalArgumentException se key == null allora richiamo
     *                                  l'errore
     */
    public void remove(String key) {
        if (key.equals(null)) {
            throw new IllegalArgumentException("Key  non può essere null");
        }
        // System.out.println("index: " + getIndex(key));
        if (getIndex(key) != -1) {
            elements.remove(elements.get(getIndex(key)));
        }
    }

    /**
     * Restituisce il numero di colonne della mappa
     * 
     * @return
     */

    public int len() {
        return elements.size();
    }

    /**
     * Controllo la presenza di un elemento con chiave= key e se presente ritorno
     * null altrimenti false.
     * Se key==null allora ritorno false
     * 
     * @param key
     * @return
     */
    public boolean contains(String key) {
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Ci restituisce il valore di un elemento avendo la sua chiave. Se la chiave
     * non è presente richiamo un errore IllegalArgumentException
     * 
     * @param key
     * @return
     * @throws IllegalArgumentException
     */
    public int getValue(String key) {
        if (!contains(key)) {
            throw new IllegalArgumentException("elemento non presente");
        }
        return elements.get(this.getIndex(key)).value;

    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Simplemap) {
            Simplemap el = (Simplemap) obj;
            if (elements.size() != el.elements.size()) {
                return false;
            }
            for (int i = 0; i < el.elements.size(); i++) {
                if (!elements.contains(el.elements.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;

    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }

    // TODO rep ok
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Mapp: [");
        if (elements.size() > 0) {
            for (int i = 0; i < elements.size() - 1; i++) {
                sb.append(elements.get(i) + ",");
            }
            sb.append(elements.get(elements.size() - 1));
        }
        sb.append("]");
        return sb.toString();

    }

}
