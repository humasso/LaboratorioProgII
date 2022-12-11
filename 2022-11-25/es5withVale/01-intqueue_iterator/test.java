import java.util.Iterator;
public class test {
    public static void main(String[] args) {
        IntQueue coda = new IntQueue(4);
        coda.enqueue(0);
        coda.enqueue(1);
        coda.enqueue(2);
        coda.enqueue(3);
        Iterator<Integer> et = coda.iterator();
        
        while (et.hasNext()){
            System.out.println(et.next());
        }
    }
}
