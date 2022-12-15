import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Classe astratta immutabile che rappresenta i listini in cui il prezzo di un
 * certo numero di
 * giocattoli di un certo tipo dipende dal prezzo unitario di un giocattolo di
 * tale tipo.
 */
public abstract class AbstractListinoUnitario implements Listino {
    // Campi
    private final Map<Giocattolo, Integer> prezzoUnitario;

    /**
     * Costruisco un listino dato da una mappa di giocattoli con il loro rispettivo
     * prezzo
     * 
     * @param prezzoUnitario
     * @throws NullPointerException     se la mappa è o contiene chiavi o valori
     *                                  {@code null}
     * @throws IllegalArgumentException se la mappa contiene integer negativi
     */
    public AbstractListinoUnitario(final Map<Giocattolo, Integer> prezzoUnitario) {
        this.prezzoUnitario = new HashMap<>();

        for (Map.Entry<Giocattolo, Integer> e : prezzoUnitario.entrySet()) {
            final Giocattolo giocattolo = Objects.requireNonNull(e.getKey(), "La mappa non può contenere chiavi null.");
            final Integer num = Objects.requireNonNull(e.getValue(), "La mappa non può contenere valori null.");

            if (num <= 0)
                throw new IllegalArgumentException("Il prezzo di " + giocattolo + " deve essere positivo");

            this.prezzoUnitario.put(giocattolo, num);
        }
    }

    /**
     * Restituisce il prezzo unitario di un oggetto
     * 
     * @param g
     * @return prezzo
     */

    public int prezzoUnitario(final Giocattolo g) {
        Objects.requireNonNull(g, "Il giocattolo non può essere nullo");
        Integer prezzo = Objects.requireNonNull(prezzoUnitario.get(g), "Gicattolo not found: " + g);
        // if (prezzo==null){
        // throw new IllegalArgumentException("Gicattolo not found: "+ g)
        // }
        return prezzo;
    }

    @Override
    public boolean conosce(Giocattolo g) {
        return prezzoUnitario.containsKey(Objects.requireNonNull(g, "Il giocattolo non può essere nullo"));
    }

    @Override
    public abstract int getTotalPrice(Giocattolo g, int quantita);
}