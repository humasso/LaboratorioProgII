import java.util.Scanner;

public class lychrel {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();

        String iStr = String.valueOf(i);
        String newStr = "";
        for (int j = iStr.length() - 1; j >= 0; j--) {
            newStr += iStr.charAt(j);
        }
        // System.out.println(newStr);
        i = i + Integer.parseInt(newStr);

        System.out.println(i);

        in.close();

    }

}
