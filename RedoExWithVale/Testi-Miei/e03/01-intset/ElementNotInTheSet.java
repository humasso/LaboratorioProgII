import java.util.NoSuchElementException;

public class ElementNotInTheSet extends NoSuchElementException {

    public ElementNotInTheSet() {
    }

    public ElementNotInTheSet(Throwable cause) {
        super(cause);
    }

    public ElementNotInTheSet(String s) {
        super(s);
    }

}
