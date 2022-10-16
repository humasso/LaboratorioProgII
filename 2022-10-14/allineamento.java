import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class allineamento {
    
    public static void main(String[] args) {
        List<String> parole = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        int max = 0;
        int spacing = 1;
        while (s.hasNext()){
            String parola =s.next();
            parole.add(parola);
            if (max<parola.length()){
                max= parola.length();   
            }
        }
        s.close();    
       
        for(int j=0;j<=parole.size()+spacing;j++){
            //System.out.print(j);
            for(int i=0;i<=max+spacing;i++){
                if (j==0|| i==0 || i==max+spacing || j==parole.size()+spacing){
                    System.out.print("*");
                }else{
                    if (i-1<(parole.get(j-1).length())){
                        System.out.print(parole.get(j-1).charAt(i-1));  
                    }else{
                        System.out.print("-");

                    }

                    

                }
                
            }
            System.out.println("");
        }
    }  
}

