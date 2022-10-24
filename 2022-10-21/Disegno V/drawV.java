public class drawV {
    public static void main(String[] args) {
        draw(4);
    }

    static void draw(int n) {

        int i, j;
        for (i = n - 1; i >= 0; i--) {
            for (j = n - 1; j > i; j--) {
                System.out.print(" ");
            }

            System.out.print("*");

            for (j = 1; j < (i * 2); j++)
                System.out.print(" ");

            if (i >= 1)
                System.out.print("*");
            System.out.print("\n");
        }
    }

}
