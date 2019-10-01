package ganzeZahlen;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Basiswechsel{
    public static void main(String[] args){
        System.out.println((short)1234L);

        ziffernAusgabehex(Integer.MAX_VALUE,16);

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        do {
            try {
                line = in.readLine();
                int i = Integer.parseInt(line);
                ziffernAusgabehex(i,16);
                System.out.println("--");
            } catch (Exception e) {

            }
        }while(line !=null && !line.equals("exit") );
        System.exit(42);
    }

    public static void ziffernAusgabe(int n){
        ListStack<Integer> ls = new ListStack<>();
        if(n == 0){
            System.out.print(0);
        }
        while (n>0){
            int ziffer = n % 10;
            ls.push(ziffer);
            n = n / 10;
        }
        while(!ls.isEmpty()){
            System.out.print(ls.pop());
        }
    }

    public static void ziffernAusgabe(int n,int basis){
        if(basis< 2 || basis > 10){
            return;
        }
        ListStack<Integer> ls = new ListStack<>();
        if(n == 0){
            System.out.print(0);
            return;
        }
        while (n>0){
            int ziffer = n % basis;
            ls.push(ziffer);
            n = n / basis;
        }
        while(!ls.isEmpty()){
            System.out.print(ls.pop());
        }
    }

    public static void ziffernAusgabehex(int n,int basis){
        if(basis< 2 || basis > 16){
            return;
        }
        ListStack<String> ls = new ListStack<>();
        if(n == 0){
            System.out.print(0);
            return;
        }
        while (n>0){
            String ziffer = String.format("%X",n % basis);
            ls.push(ziffer);
            n = n / basis;
        }
        while(!ls.isEmpty()){
            System.out.print(ls.pop());
        }
    }



}
