import java.util.Map;

/**
 * Overview:
 * Classe che implementa un listino il cui prezzo di n giocattoli dello stesso
 * tipo è pari a n volte il prezzo del giocattolo
 * 
 */
public class ListinoLineare extends AbstractListinoUnitario {
    /**
     * Costruisce un listino a partire da una mappa tra giocattoli e prezzi
     * unitari.
     * 
     * @param mapp
     */
    public ListinoLineare(Map<Giocattolo, Integer> mapp) {
        super(mapp);
    }

    @Override
    public int getTotalPrice(Giocattolo g, int quantita) throws IllegalArgumentException {
        if (quantita <= 0)
            throw new IllegalArgumentException("il numero deve essere positivo");
        return prezzoUnitario(g) * quantita;
    }
}