import java.util.Arrays;

public class IntQueue {
    /**
     * TODO:
     * porca madonna capisci a che cosa cazzo serve tail perchè non ha senso
     */
    /**
     * ABS:
     * i valori contenuti all'interno di coda rappresentano gli elementi di una pilo
     * FIFO
     * mentre head rappresenta il primo argomento in cima alla pilla
     * tail rappresenta la capienza della pila
     */
    /**
     * IR:
     * la coda non contiene più elementi della sua capienza massima,
     * -1 <= head < size
     * 0 <= tail < size
     * head == -1 ⇒ tail = 0
     * 
     */
    private int[] coda;
    private int head, tail;

    /**
     * Si occupa di inizializzare un oggeto di tipo intqueue
     * 
     * @param n definira la grandezza della coda
     * @throws IllegalArgumentException Viene lanciata quando n<0
     */
    public IntQueue(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("N must be >=0");
        }
        coda = new int[n];
        head = -1;
        tail = n;

    }

    /**
     * Inserisce un elemento n all'interno della coda, se la coda non è piena,
     * altrimenti solleva un eccezione
     * 
     * @param n
     * @throws OutOfBoundException
     */
    public void Enqueue(int n) throws OutOfBoundException {
        if (tail > coda.length) {
            throw new OutOfBoundException("Out of Tail bound :(");
        }
        coda[head] = n;

        head++;

    }

    /**
     * Rimuove il primo elmento dalla pila
     * va in errore se la pila è piena
     * 
     * @throws EmptyQueueExeption
     */
    public int Dequeue() throws EmptyQueueExeption {
        System.out.println(tail);
        if (IsEmpty()) {
            throw new EmptyQueueExeption("the tail is empty popi popi");
        }
        int result = coda[head];
        head--;
        return result;
    }

    /**
     * Resituisce True se la coda è piena, viceversa se è non lo è
     * 
     * @return
     */
    public boolean IsFull() {
        return (tail == coda.length);

    }

    /**
     * Restituisce se la coda è vuota oppure no
     * 
     * @return
     */
    public boolean IsEmpty() {
        return head == -1;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(coda);
        result = prime * result + head;
        result = prime * result + tail;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        // TODO
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder("La coda contiene:");
        ret.append("[");

        if (tail != 0) {
            for (int i = 1; i < tail; i++) {
                ret.append(coda[i - 1] + ",");
            }
            ret.append(coda[tail - 1]);
        }
        ret.append("]");

        return ret.toString();
    }

}
