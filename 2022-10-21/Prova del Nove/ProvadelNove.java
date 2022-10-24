public class ProvadelNove {
    public static void main(String[] args) {
        // System.out.println(isTheLowest("56789"));
        genSub(4);
    }

    // REQUIRES: n deve essere una stringa contentente solo numeri
    static int sumChipers(String n) {
        int Len = n.length();

        if (Len <= 1)
            return n.charAt(0) - '0';

        return (n.charAt(0)) - '0' + sumChipers(n.substring(1, Len));
    }

    /**
     * @param n
     * @return
     */
    static int isTheLowest(String n) {
        int g = (Integer.toString(sumChipers(n))).length();
        int s = sumChipers(n);
        while (g > 1) {
            // System.out.println("check");
            s = sumChipers(Integer.toString(s));
            g = Integer.toString(s).length();
            // System.out.println(g);

        }
        return s;
    }

    static void genSub(int n) {
        int max = n;
        for (int i = 1; i <= max; i++) {
            for (int j = 1; j <= max; j++) {
                for (int h = 1; h <= max; h++) {
                    if (i * j != h && isTheLowest(Integer.toString(i * j)) == h) {
                        System.out.println(i + " " + j + " " + h);
                    }

                }
            }
        }
    }
}
