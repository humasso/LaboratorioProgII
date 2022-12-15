import java.util.NoSuchElementException;

public class PriceNotSetException extends NoSuchElementException {

    public PriceNotSetException() {
    }

    public PriceNotSetException(String s) {
        super(s);
    }

}
