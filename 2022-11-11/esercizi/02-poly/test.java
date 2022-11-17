public class test {
    public static void main(String[] args) {
        Poly g = new Poly(5, 4);
        Poly h = new Poly(3, 4);
        g.mul(h);
        System.out.println(g.toString());
    }
}
