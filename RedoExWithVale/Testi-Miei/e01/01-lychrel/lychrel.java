import java.util.Scanner;

public class lychrel {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        String arg = String.valueOf(i);

        while (!isPalindroma(arg)) {

            String iStr = String.valueOf(i);
            String newStr = "";
            for (int j = iStr.length() - 1; j >= 0; j--) {
                newStr += iStr.charAt(j);
            }
            // System.out.println(newStr);
            i = i + Integer.parseInt(newStr);
            arg = String.valueOf(i);
            System.out.println(i);
        }
        in.close();

    }

    public static boolean isPalindroma(String str) {
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i)) != (str.charAt(str.length() - 1 - i))) {
                return false;
            }
        }

        return true;
    }
}
