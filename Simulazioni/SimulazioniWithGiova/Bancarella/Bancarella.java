import java.util.Objects;

/**
 * Questa classe si occuperà di gestire una bancarella nella quale vengono
 * venduti oggetti
 */
public class Bancarella {
    // IR: il proprietario non può essere null o vuoto. L'inventario e il listino
    // non devono essere null. Il listino deve conoscere il prezzo di ogni
    // giocattolo nell'inventario

    // AF: (proprietario, inv, listino) : rapresentano una bancarella di un certo
    // proprietario, con un inventario inv e un listino

    private final String proprietario;
    private final Inventario inv;
    private final Listino listino;

    /**
     * Costituisce una bancarella partendo dai campi assicurandosi che non siano mai
     * == null o empty e controllando che ogni elemento del listino sia compreso
     * nell'inventario
     * 
     * @param proprietario
     * @param inv
     * @param listino
     * @throws IllegalArgumentException
     */
    public Bancarella(String proprietario, Inventario inv, Listino listino) throws IllegalArgumentException {
        if (proprietario.isEmpty() || proprietario.equals("")) {
            throw new IllegalArgumentException("Proprietario non valido ");
        }
        this.proprietario = proprietario;
        if (listino == null) {
            throw new IllegalArgumentException("Il listino non può essere vuoto");
        }
        if (inv == null) {
            throw new IllegalArgumentException("L'inventario non può essere vuoto");
        }

        for (final Giocattolo g : inv.getDisponibili()) {
            if (!listino.conosce(g))
                throw new PriceNotSetException("Non è presente un prezzo nel listino per l'oggetto " + g.getNome());
        }

        this.inv = inv;
        this.listino = listino;
    }

    /**
     * Restituisce il numero di oggetti g uguali presenti nell'inventario
     * 
     * @param g
     * @return
     */
    public int quantita(Giocattolo g) {
        Objects.requireNonNull(g, "Il giocattolo non può essere nullo");

        int counter = 0;
        for (Giocattolo gicc : inv.getDisponibili()) {
            if (gicc.equals(g)) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Restiuisce il prezzo di un singolo oggetto
     * 
     * @param g
     * @return
     */

    public int prezzo(Giocattolo g) {
        Objects.requireNonNull(g, "Il giocattolo non può essere nullo");

        return listino.getTotalPrice(g, 1);
    }

    /**
     * Vende un certo numero di giocattoli g e restituisce il costo complessivo. Se
     * la quantità è minore o uguale a zero sollevo un'eccezione di tipo
     * IllegalArgumentException
     * 
     * @param g
     * @param quantita
     * @return
     */
    public int vendi(Giocattolo g, int quantita) throws IllegalArgumentException {
        if (quantita <= 0) {
            throw new IllegalArgumentException("Quantità non può essere <=0");
        }
        Objects.requireNonNull(g, "Il giocattolo non può essere nullo");

        inv.sell(g);
        return listino.getTotalPrice(g, quantita);
    }

    /**
     * Restituisce il nome del proprietario
     * 
     * @return
     */
    public String getProprietario() {
        return proprietario;
    }

    /**
     * Restituisce l'invetario
     * 
     * @return
     */
    public Inventario getInv() {
        return inv;
    }

    /**
     * Restituisce il listino
     * 
     * @return
     */
    public Listino getListino() {
        return listino;
    }
}