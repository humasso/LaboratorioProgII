public class disegnaV {
    public static String drawV(int n) {
        String fullV = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                if (i == j || 2 * n - 2 - i == j) {
                    fullV += "*";
                } else {
                    fullV += " ";

                }
            }
            fullV += "\n";

        }

        return fullV;
    }

    public static void main(String[] args) {
        System.out.println(drawV(3));
    }

}
