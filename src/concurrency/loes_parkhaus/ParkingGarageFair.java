package concurrency.loes_parkhaus;

public class ParkingGarageFair
{
    private int places;
    private int nextWaitingNumber;
    private int nextEnteringNumber;

    public ParkingGarageFair(int places)
    {
        if(places < 0)
        {
            throw new IllegalArgumentException("Parameter < 0");
        }
        this.places = places;
        this.nextWaitingNumber = 0;
        this.nextEnteringNumber = 0;
    }

    public synchronized void enter()
    {
        int myNumber = nextWaitingNumber++; // diese lokale Variabel ist Thread-spezifisch!
        while(myNumber != nextEnteringNumber || places == 0) {
            try { wait(); } catch(InterruptedException e) {}
        }
        places--;
        nextEnteringNumber++;
        notifyAll(); // wichtig !!!!
    }

    public synchronized void leave() {
        places++;
        notifyAll(); // wichtig !!!!
    }
}