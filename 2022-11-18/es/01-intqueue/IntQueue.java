
public class IntQueue {
    /*-
     * ABS FUN:  AF(elements, head, tail)
     *           = [ elements[i] | head <= i < tail ]
     *           = [elements[head], elements[head+1], ..., elements[tail-1]] se -1 < head <= tail
     *           o [elements[head], elements[head+1], ..., elements[elements.size-1], elements[0], ..., elements[tail-1]] se head > tail
     *
     * REP INV:  la coda non contiene più elementi della sua capienza massima,
     * 			-1 <= head < size
     *           0 <= tail < size
     *           head == -1 ⇒ tail = 0
     */
    private int head, tail;
    private int[] elements;

    // costruttori
    /**
     * Costruisco una coda di dimensione n, sollevo un eccezzione se n<=0
     * 
     * @param n
     * @throws IllegalArgumentException se n<=0 viene sollevata quest'eccezione
     */
    public IntQueue(int n) throws IllegalArgumentException {
        if (n <= 0) {
            throw new IllegalArgumentException("la dimensione  maggiore di 0");
        }
        elements = new int[n];
        head = -1;
        tail = 0;
        assert repOk();
    }

    /**
     * Inserisce un elemento n all'interno della coda, se la coda non è piena,
     * altrimenti solleva un eccezione
     * 
     * 
     * @param n
     * @throws FullQueueExeption
     */
    public void enqueue(int n) {
        if (isFull())
            throw new FullQueueExeption("coda piena");
        elements[tail] = n;
        tail = (tail + 1) % elements.length;

    }

    /**
     * Restituisce l'elemento in testa alla coda e lo elimina se la coda non è
     * vuota. Altrimenti solleva un eccezzione
     * 
     * @return
     * @throws EmptyQueueExeption
     */
    public int dequeue() {
        if (isEmpty())
            throw new EmptyQueueExeption("coda vuota");
        int result = elements[head];
        head = (head + 1) % elements.length;
        if (head == tail) {
            head = -1;
            tail = 0;

        }

        assert repOk(); // fixx why
        return result;
    }

    /**
     * Restituisce la mensione della lista
     * 
     * @return n=
     */
    public int size() {
        return (tail - head + elements.length) % elements.length;
    }

    /**
     * restituisce true se la coda è vuota altrimenti false
     * 
     * @return
     */
    public boolean isEmpty() {
        return head == -1;
    }

    /**
     * restituisce true se la coda è piena altrimenti false
     * 
     * @return
     */
    public boolean isFull() {
        return head == tail;
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(elements.length);
        for (int i = 0; i < size(); i++)
            result = 31 * result + Integer.hashCode(elements[(head + i) % elements.length]);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof IntQueue))
            return true;
        IntQueue other = (IntQueue) obj;
        if (elements.length != other.elements.length)
            return false;
        if (size() != other.size())
            return false;
        for (int i = 0; i < size(); i++) {
            if (elements[(head + i) % elements.length] != other.elements[(head + i) % elements.length])
                return false;
        }
        return true;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("IntQueue: [");
        if (size() > 0) {
            int i;
            for (i = 0; i < size() - 1; i++) {
                sb.append(elements[(head + i) % elements.length] + ", ");
            }
            sb.append(elements[(head + i) % elements.length] + "] ");
        }
        return sb.toString();

    }

    /**
     * controllo se la variabile di varianza è sempre vera
     * 
     * @return
     */
    private boolean repOk() {
        return -1 <= head && head < elements.length && 0 <= tail && tail < elements.length && head != -1 || tail == 0;

    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public int getTail() {
        return tail;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }

    public int[] getElements() {
        return elements;
    }

    public void setElements(int[] elements) {
        this.elements = elements;
    }

}
