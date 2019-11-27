package concurrency.uebung_ringbuffer;

public class Consumer extends Thread {

    RingBuffer ringBuffer;

    public Consumer(RingBuffer ringBuffer){
        super("Consumer");
        this.ringBuffer = ringBuffer;
    }

    @Override
    public void run(){
        while(true){

            ringBuffer.get();
            try{
                Thread.sleep(2000);
            }catch(Exception ignored){}
        }
    }
}
