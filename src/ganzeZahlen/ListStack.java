package ganzeZahlen;

public class ListStack<E> {

    private Node<E> root;
    private int size = 0;

    public ListStack(){

    }

    public boolean push(final E element){
        size++;
        if(root==null){
            root = new Node<>();
            root.data = element;
            return true;
        }
        Node<E> cache;
        cache = root;
        while(cache.next!=null){
            cache = cache.next;
        }
        cache.next = new Node();
        cache.next.data = element;
        return true;
    }

    public E pop(){
        if(root== null){
            return null;
        }
        size--;
        Node<E> cache = root;
        if(cache.next==null){
            root = null;
            return cache.data;
        }
        while(cache.next!=null){
            if(cache.next.next!=null){
                cache = cache.next;
            }else{
                break;
            }
        }
        Node<E> c = cache.next;
        cache.next = null;
        return c.data;
    }

    public E top(){
        Node<E> cache;
        cache = root;
        while(cache.next!=null){
            cache = cache.next;
        }
        return cache.data;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return root==null;
    }

    private class Node<E> {
        public E data;
        public Node next;
    }

}



