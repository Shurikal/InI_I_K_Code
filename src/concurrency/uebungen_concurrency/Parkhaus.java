package concurrency.uebungen_concurrency;

public class Parkhaus {

    private int maxSpace;
    private int availableSpace;

    private Auto[] autos;

    public Parkhaus(int maxSpace){
        this.maxSpace = maxSpace;
        availableSpace = maxSpace;
    }

    public synchronized void einfahren(){
        try {
            while (availableSpace <= 0) {
                wait();
            }
        }catch(Exception ignored){}
        availableSpace--;
        System.out.println("Auto "+ Thread.currentThread().getName()+" ist eingefahren!");
    }

    public synchronized void ausfahren(){
        availableSpace++;
        System.out.println("Auto "+ Thread.currentThread().getName()+" ist ausgefahren!");
        notify();
    }

}
