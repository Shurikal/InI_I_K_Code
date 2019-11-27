package concurrency.uebungen_concurrency;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Zaehlen {

    boolean[] b_arr;
    final static int size = 500 * (int)Math.pow(10, 6);

    public static void main(String[] args) {
        new Zaehlen();

    }

    public Zaehlen(){
        b_arr = new boolean[size];
        Random r = new Random();
        for(int i = 0;i <size;i++){
            b_arr[i] = r.nextBoolean();
        }

        System.out.println("Array gefüllt");
        for(int i = 1; i< 100;i++){
            calculate(i);
        }
        for(int i = 100; i<1000;i+=10){
            calculate(i);
        }

        for(int i = 1000; i<10000;i+=100){
            calculate(i);
        }
    }

    public void calculate(int threads){

        //System.out.println("Calculation for "+ threads +" Threads!");
        int h = size/threads;

        ArrayList<Counter> alc = new ArrayList<>();

        long oldTime = System.nanoTime();
        for(int i = 0; i< threads; i++){
            Counter c = new Counter(b_arr,(h*i),(h*(i+1)));
            c.start();
            alc.add(c);
        }

        try{
            for(Counter c : alc){
                c.join();
            }
        }catch(Exception e){

        }

        int counter = 0;
        for(Counter c : alc){
            counter += c.counter;
        }
        long newTime = System.nanoTime();
        //System.out.println(counter);
        System.out.println("Threads/Zeit\t" + threads+ "\t" + ((newTime-oldTime)/Math.pow(10,6)));
    }

}
