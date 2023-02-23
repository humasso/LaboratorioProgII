
public class EmptyQueueExeption extends RuntimeException {

    public EmptyQueueExeption() {
    }

    public EmptyQueueExeption(String message) {
        super(message);
    }

}
