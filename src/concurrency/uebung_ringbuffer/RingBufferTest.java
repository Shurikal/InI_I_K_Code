package concurrency.uebung_ringbuffer;

public class RingBufferTest {

    public static void main(String[] args) {
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(10);
        new Producer(ringBuffer).start();
        new Consumer(ringBuffer).start();
    }
}
