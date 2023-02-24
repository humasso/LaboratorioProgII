public class test {
    public static void main(String[] args) {
        polySparse ppol = new polySparse(3, 5);
        polySparse pol2 = new polySparse(2, 6);
        System.out.println(ppol.add(pol2));
    }
}
