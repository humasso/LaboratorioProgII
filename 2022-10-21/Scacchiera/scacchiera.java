package Scacchiera;

public class scacchiera {
    public static void main(String[] args) {
        block(4);
    }

    static void block(int n) {
        // int righa, colonna = 0;
        // int c = 0;
        // boolean check = true;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < n; j++) {
                for (int h = 0; h < 8; h++) {
                    for (int r = 0; r < n; r++) {
                        // if (i % 2 == 0 || h % 2 == 0) {
                        if (h % 2 == 0) {
                            if (i % 2 == 0) {
                                System.out.print("-");

                            } else {
                                System.out.print("#");

                            }
                        } else {
                            if (i % 2 == 0) {
                                System.out.print("#");

                            } else {
                                System.out.print("-");

                            }
                        }
                    }
                }
                System.out.println();

            }
        }
    }
}
