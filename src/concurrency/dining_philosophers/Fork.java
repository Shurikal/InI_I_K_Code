package concurrency.dining_philosophers;

public class Fork {

    private int index;

    public Fork(int index){
        this.index = index;
    }

    public int getIndex(){
        return index;
    }
}
