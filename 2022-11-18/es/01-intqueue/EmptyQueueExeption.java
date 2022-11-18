
public class EmptyQueueExeption extends RuntimeException {

    public EmptyQueueExeption() {
        super();
    }

    public EmptyQueueExeption(String message) {
        super(message);
    }

}
