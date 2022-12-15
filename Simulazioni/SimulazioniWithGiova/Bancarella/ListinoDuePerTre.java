import java.util.Map;

public class ListinoDuePerTre extends AbstractListinoUnitario {

    public ListinoDuePerTre(Map<Giocattolo, Integer> prezzoUnitario) {
        super(prezzoUnitario);
    }

    @Override
    public int getTotalPrice(Giocattolo g, int quantita) {
        if (quantita <= 0)
            throw new IllegalArgumentException("il numero deve essere positivo");

        return prezzoUnitario(g) * (quantita - (int) Math.floor(quantita / 3));
    }
}
