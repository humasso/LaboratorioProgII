
public class NotInStockException extends IllegalArgumentException {

    public NotInStockException() {
    }

    public NotInStockException(String s) {
        super(s);
    }
}
