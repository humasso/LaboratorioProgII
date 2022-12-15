import java.util.NoSuchElementException;

/**
 * Overview: Interfccia che rappresenta una listino prezzi.
 * <p>
 * Il listino indica il prezzo di un cerco numero di giocattoli di dato tipo e
 * se è a conoscenza del prezzo di un certo giocattolo
 */
public interface Listino {
    /**
     * Indica se il listino conosce il prezzo di un dato giocattolo
     * 
     * @param g il giocattolo
     * @return se il listino conoce o meno il prezzo
     * @throws IllegalArgumentException se g è nullo
     */
    public boolean conosce(Giocattolo g) throws IllegalArgumentException;

    /**
     * Indica il prezzo di un certo numero di giocattoli di un dato tipo. Se il
     * giocattolo
     * 
     * @param g        il giocattolo
     * @param quantita numero di giocattoli
     * @return prezzo di acquisto di quantità giocattoli
     * @throws IllegalArgumentException se il numero non è positivo e se g è nullo
     * @throws NoSuchElementException   se il giocattolo non è noto al listino
     */
    public int getTotalPrice(Giocattolo g, int quantita) throws IllegalArgumentException, NoSuchElementException;

}