import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class allineamentocomplesso {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<String> parole = new ArrayList<>();
        int max = 0;
        String allign = args[0];
        while (s.hasNext()) {
            String parola = s.next();
            parole.add(parola);
            if (max < parola.length()) {
                max = parola.length();
            }
        }
        s.close();

        for (int i = 0; i <= max + 1; i++) {
            for (int j = 0; j <= parole.size() + 1; j++) {
                if (i == 0 || i == max + 1 || j == 0 || j == parole.size() + 1) {
                    System.out.print("*");
                } else {
                    switch (allign) {
                        // dall'alto

                        case "h":
                            if (i - 1 < parole.get(j - 1).length()) {
                                System.out.print(parole.get(j - 1).charAt(i - 1));
                                // System.out.print(i-1);

                            } else {
                                System.out.print("-");
                            }
                            break;
                        // dal basso
                        case "l":
                            if (max - i < parole.get(j - 1).length()) {
                                System.out.print(parole.get(j - 1).charAt(max - i));

                            } else {
                                System.out.print("-");
                            }
                            break;

                    }

                    // System.out.print(parole.get(j-1).length());

                }

            }
            System.out.println("");
            ;
        }

    }
}
