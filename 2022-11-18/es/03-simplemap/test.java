import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Simplemap mappa = new Simplemap();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] in = line.split(" ");

            if (in[0].equals("+")) {
                mappa.put(in[1], Integer.parseInt(in[2]));
            }
            if (in[0].equals("-")) {
                // System.out.println("remove");
                mappa.remove(in[1]);
            }

        }

        scanner.close();

        System.out.println(mappa.len());
    }
}
