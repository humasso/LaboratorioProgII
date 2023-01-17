import java.util.List;
import java.util.Scanner;

public class test {
    public static void main(String[] args) throws NumberFormatException, DuplicateElementException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Inserire istruzioni nel formato +/- int:");
        IntSet insieme = new IntSet();
        while (scan.hasNextLine()) {
            String[] riga = (scan.nextLine()).split(" ");
            // System.out.println(riga[1]);
            switch (riga[0]) {
                case "+":
                    insieme.insert(Integer.parseInt(riga[1]));
                    break;
                case "-":
                    insieme.remove(Integer.parseInt(riga[1]));
                    break;
            }
        }
        scan.close();
        System.out.println(insieme);
    }
}
