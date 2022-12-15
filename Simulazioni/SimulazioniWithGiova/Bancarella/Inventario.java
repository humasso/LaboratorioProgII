import java.util.ArrayList;
import java.util.List;

//Overview: Questa classe rappresenta l'insieme di giocattoli presenti e venduti
public class Inventario {
    // IR: disponibili e venduti non possono contenere null

    // AF: (disponibili, venduti) : rappresenta un'inventario, indicando gli oggetti
    // disponibili e quelli venduti

    // Campi
    private List<Giocattolo> disponibili;
    private List<Giocattolo> venduti;

    // Costruttori
    /**
     * Costruttore che crea un'istanza di un'inventario senza oggetti
     */
    public Inventario() {
        disponibili = new ArrayList<Giocattolo>();
        venduti = new ArrayList<Giocattolo>();
    }

    /**
     * Costruttore che crea un'istanza di un'inventario partendo dai parametri
     * disponibili e venduti
     * 
     * @param disponibili
     * @param venduti
     * @throws IllegalArgumentException
     */
    public Inventario(List<Giocattolo> disponibili, List<Giocattolo> venduti) throws IllegalArgumentException {
        if (disponibili.contains(null) || venduti.contains(null))
            throw new IllegalArgumentException("Le liste contengono uno o più elementi nulli");

        this.disponibili = disponibili;
        this.venduti = venduti;
    }

    /**
     * Controlla se un determinato giocattolo è disponibile
     * 
     * @param g
     * @return
     */
    public boolean isInStock(Giocattolo g) {
        return (disponibili.contains(g));
    }

    /**
     * Vendi un determinato giocattolo. Nel caso quel giocattolo non fosse presente
     * sollevo un'eccezione di tipo NotInStockException
     * 
     * @param g
     * @return
     * @throws NotInStockException
     */
    public void sell(Giocattolo g) throws NotInStockException {
        if (!isInStock(g)) {
            throw new NotInStockException();
        }
        disponibili.remove(g);
        venduti.add(g);
    }

    /**
     * Controlla se un determinato giocattolo è stato venduto
     * 
     * @param g
     * @return
     */
    public boolean isSold(Giocattolo g) {
        return (venduti.contains(g));
    }

    /**
     * Metodo get che restituisce l'insieme dei giocattoli in stock
     * 
     * @return disponibili
     */
    public List<Giocattolo> getDisponibili() {
        return disponibili;
    }

    /**
     * Imposto i giocattoli disponibili
     * 
     * @param disponibili
     * @throws IllegalArgumentException
     */
    public void setDisponibili(List<Giocattolo> disponibili) throws IllegalArgumentException {
        if (disponibili.contains(null) || venduti.contains(null))
            throw new IllegalArgumentException("La lista contiene uno o più elementi nulli");

        this.disponibili = disponibili;
    }

    /**
     * Metodo get che restituisce l'insieme dei giocattoli venduti
     * 
     * @return venduti
     */
    public List<Giocattolo> getVenduti() {
        return venduti;
    }

    /**
     * Imposto i giocattoli venduti
     * 
     * @param venduti
     * @throws IllegalArgumentException
     */
    public void setVenduti(List<Giocattolo> venduti) throws IllegalArgumentException {
        if (disponibili.contains(null) || venduti.contains(null))
            throw new IllegalArgumentException("La lista contiene uno o più elementi nulli");

        this.venduti = venduti;
    }

    @Override
    public String toString() {
        return "Inventario [disponibili=" + disponibili + ", venduti=" + venduti + "]";
    }

}
