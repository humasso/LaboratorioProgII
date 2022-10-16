import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Rovescia {
    public static void main(String[] args){
        List<Integer> numeri = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()){
            numeri.add(s.nextInt());

        }
        s.close();
        for ( int i=numeri.size();i>0;i--){
            System.out.println(numeri.get(i));
        }
    }   
}

