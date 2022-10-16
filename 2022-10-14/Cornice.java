import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cornice {
    public static void main(String[] args) {
        List<String> parole = new ArrayList<>();
        int maxlen=0;
        Scanner s = new Scanner(System.in);
        while (s.hasNext()){
            String parola =s.next();
            if (parola.length()>maxlen) maxlen=parola.length();
            parole.add(parola);
        }
        s.close();
        System.out.println(parole+", la più lunga è lunga "+maxlen);

    }
}
