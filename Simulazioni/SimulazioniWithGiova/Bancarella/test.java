import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        Giocattolo gigi = new Giocattolo("gigi", "alluminio");
        System.out.println(gigi.toString());

        List<Giocattolo> giocattoli = new ArrayList<Giocattolo>();
        giocattoli.add(gigi);
        giocattoli.add(new Giocattolo("tino", "pongo"));

        Inventario inventario = new Inventario(giocattoli, new ArrayList<Giocattolo>());

        System.out.println(inventario.toString());
        inventario.sell(gigi);
        System.out.println(inventario.toString());

        Map<Giocattolo, Integer> disponibili = new HashMap<Giocattolo, Integer>();
        disponibili.put(new Giocattolo("bambola", "ferro"), 5);
        disponibili.put(new Giocattolo("bambola", "legno"), 10);
        disponibili.put(gigi, 15);

        ListinoDuePerTre listino = new ListinoDuePerTre(disponibili);
        System.out.println(listino.getTotalPrice(gigi, 6));

    }
}