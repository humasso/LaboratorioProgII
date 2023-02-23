public class prova_del_nove {
    public static int getSum(int i) {
        String str = String.valueOf(i);
        int h = 0;
        for (int j = 0; j < str.length(); j++) {
            h += Character.getNumericValue(str.charAt(j));
        }
        return h;
    }

    public static void main(String[] args) {
        int i = 12;
        System.out.println(getSum(i));
    }
}
