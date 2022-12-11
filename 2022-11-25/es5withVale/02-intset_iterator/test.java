import java.util.Iterator;

public class test {
    public static void main(String[] args) {
        IntsSets insieme = new IntsSets();
        insieme.AddElement(0);
        insieme.AddElement(1);
        insieme.AddElement(2);
        insieme.AddElement(3);
        insieme.AddElement(0);

        Iterator<Integer> et = insieme.iterator();
        
        while (et.hasNext()){
            System.out.println(et.next());
        }
    }
}
