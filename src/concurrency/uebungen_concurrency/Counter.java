package concurrency.uebungen_concurrency;

public class Counter extends Thread {

    boolean[] b_arr;

    int counter=0;

    int from, to;

    long oldTime;
    long newTime;

    public Counter(boolean[] b_arr,int from, int to) {
        this.b_arr = b_arr;
        this.from = from;
        this.to = to;

    }

    public void run() {
        oldTime = System.nanoTime();
        for(int i = from; i < to; i++){
            if(b_arr[i]) {
                counter++;
            }
        }
        newTime = System.nanoTime();
    }

    public int getCounter() {
        return counter;
    }

    public long getTime(){
        return newTime-oldTime;
    }

}
