import java.util.Iterator;
import java.util.NoSuchElementException;

public class RangeIterator {

    private final int from;
    private final int to;
    private final int step;

    /**
     * AF(c)= [c.from, c.from + step, c.from + 2*step, ... , to)=
     * [r_i|r_i=c.from+c.step*i, i>=0,c.step>0,r_i<c.to || r_i>c.to,step<0]
     * Si noti che se c.step > 0 e c.from < c.to, oppure se c.step < 0 e c.from >
     * c.to,
     * allora il range è vuoto
     * 
     * RI(c) = c.step != 0
     * 
     */
    /**
     * Crea un RangeIterator da from a to, con incremento uguale a step
     * o solleva un'eccezione di tipo IllegalArgumentException se step == 0
     * 
     * @param from :
     * @param to   :
     * @param step :
     * @throws IllegalArgumentException lanciata quando step ==0
     */
    public RangeIterator(int from, int to, int step) throws IllegalArgumentException {
        if (step == 0)
            throw new IllegalArgumentException("step dev'essere diverso da 0");
        this.from = from;
        this.to = to;
        this.step = step;
    }

    /**
     * Crea un RangeIterator da from a to, con incremento uguale a step
     * o solleva un'eccezione di tipo IllegalArgumentException se step == 0
     * 
     * @param to
     * @param step
     * @throws IllegalArgumentException lanciata quando step ==0
     * 
     */
    public RangeIterator(int to, int step) {
        this(0, to, step);
    }

    /**
     * Crea un RangeIterator da from a to, con incremento uguale a step
     * 
     * @param to
     */
    public RangeIterator(int to) {
        this(0, to, 1);
    }

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int next = from;
            private boolean hasNext = step > 0 ? next < to : next > to;

            @Override
            public boolean hasNext() {
                if (!hasNext) {
                    next += step;
                    hasNext = step > 0 ? next < to : next > to;
                }
                return hasNext;
            }

            @Override
            public Integer next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                hasNext = false;
                return next;
            }

        };
    }
}
