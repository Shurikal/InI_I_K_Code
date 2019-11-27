package concurrency.uebung_ringbuffer;

public class RingBuffer<T> {

    Element head, tail;
    Semaphore free,filled;

    public RingBuffer(int size){
        free = new Semaphore(size);
        filled = new Semaphore(0);
        head = new Element();
        tail = head;
        for(int i= 1; i< size;i++){
            head.next = new Element();
            head = head.next;
        }
        head.next = tail;
        head = tail;
    }

    public void put(T t){
        free.p();
        if(head.next.data !=null){
            System.out.println("Full!");

        }
        System.out.println(Thread.currentThread().getName()+ " puts "+ t);
        head.data = t;
        head = head.next;
       filled.v();
    }

    public T get(){
        filled.p();
        if(tail.data !=null) {
            T data = (T) tail.data;
            System.out.println(Thread.currentThread().getName()+ " gets "+ data);
            tail.data = null;
            tail = tail.next;
            free.v();
            return data;
        }
        free.v();
        return null;
    }

    private class Element<T>{
        T data;
        Element next;
    }
}
