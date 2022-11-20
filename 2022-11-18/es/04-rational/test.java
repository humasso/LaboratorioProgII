import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        List<RationalNumbers> list = new ArrayList<RationalNumbers>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] g = sc.nextLine().split(" ");
            list.add(new RationalNumbers(Integer.parseInt(g[0]), Integer.parseInt(g[1])));

        }
        sc.close();
        list.get(0).somma(list.get(1));
        System.out.println(list.get(0));
    }

}
