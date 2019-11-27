package concurrency.uebungen_concurrency;

import java.util.Random;

public class Auto extends Thread {

    private Parkhaus ph;

    public Auto(Parkhaus ph,String name){
        this.ph = ph;

        super.setName(name);
    }

    public void run(){
        Random r = new Random();
        try {
            sleep(r.nextInt(1000));


            while(!isInterrupted()){
                ph.einfahren();
                sleep(r.nextInt(10000));
                ph.ausfahren();
                sleep(r.nextInt(1000));
            }

        }catch(Exception ignored){}

    }

}
