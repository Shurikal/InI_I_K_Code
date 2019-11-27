package concurrency.uebung_ringbuffer;

public class Producer extends Thread {
    RingBuffer ringBuffer;

    public Producer(RingBuffer ringBuffer){
        super("Producer");
        this.ringBuffer = ringBuffer;
    }

    @Override
    public void run(){
        while(true){
            int data = (int)(Math.random()*100);
            ringBuffer.put(data);
            try{
                Thread.sleep(1000);
            }catch(Exception ignored){}
        }
    }
}
