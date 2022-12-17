import java.security.cert.PolicyQualifierInfo;

public class test {
    public static void main(String[] args) {
        SparsePoly poly = new SparsePoly(4, 5);
        SparsePoly poly2 = new SparsePoly(1, 5);
        System.out.println(poly);
        System.out.println(poly2);
        System.out.println(poly.add(poly2));
    }
}
