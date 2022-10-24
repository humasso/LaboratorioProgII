package Rombo;

public class rombo {
    public static void main(String[] args) {
        draw(5);
    }

    static void draw(int n) {
        int count = 1;
        int no_of_spaces = 1;

        for (int i = 1; i < (n * 2); i++) {

            for (int spc = n - no_of_spaces; spc > 0; spc--) {
                System.out.print(" ");
            }
            if (i < n) {
                no_of_spaces++; // for spaces
            } else {
                no_of_spaces--; // for space
            }
            for (int j = 0; j < count; j++) {
                System.out.print("*");

            }
            if (i < n) {
                count = count + 2;
            } else {
                count = count - 2;
            }

            System.out.println();
        }

    }
}
