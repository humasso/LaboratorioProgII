import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            String[] val = (sc.nextLine()).split(" ");
            int p = Integer.parseInt(val[0]);
            int q = Integer.parseInt(val[1]);
            Poly sumP = new Poly();
            for (int i = 0; i < p; i++) {
                String[] values = (sc.nextLine()).split(" ");
                int c = Integer.parseInt(values[0]);
                int n = Integer.parseInt(values[1]);
                sumP = sumP.add(new Poly(c, n));
            }

            System.out.println(sumP);
            Poly sumQ = new Poly();

            for (int i = 0; i < q; i++) {
                String[] values = (sc.nextLine()).split(" ");
                int c = Integer.parseInt(values[0]);
                int n = Integer.parseInt(values[1]);
                sumQ = sumQ.add(new Poly(c, n));
            }
            System.out.println(sumQ);
            System.out.println("minus: " + sumP.minus());
            System.out.println("add:" + sumP.add(sumQ));
            System.out.println("mul: " + sumP.mul(sumQ));
            System.out.println("sub: " + sumP.sub(sumQ));

        }

    }
}
