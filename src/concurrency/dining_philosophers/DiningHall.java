package concurrency.dining_philosophers;

public class DiningHall {

    public static void main(String[] args) {
        int number = 6;
        Table table = new Table(number);
        for(int i = 0; i< number;i++){
            new Philosopher(table,i).start();
        }
    }
}
