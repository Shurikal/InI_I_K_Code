package concurrency.dining_philosophers;

public class Philosopher extends Thread {
    int number;
    private PhilosopherState state;
    private long lastEatTime;
private Table table;

        public Philosopher(Table table,int number){
        super(""+number);
        this.number = number;
        this.state = PhilosopherState.waiting;
        this.lastEatTime =0;
        this.table = table;
    }

    @Override
    public void run() {
        lastEatTime = System.currentTimeMillis();
        while (true) {
            think(number);
            this.state = PhilosopherState.waiting;
            table.takeFork(number);

            eat(number);
            table.putFork(number);

            try {
                Thread.sleep((int)(Math.random()*1000));
            } catch (Exception ignored) {

            }
        }
    }

    public void think(int number){
        System.out.println(Thread.currentThread().getName()+" is thinking");
        try {
            Thread.sleep((int)(Math.random()*1000));
        } catch (Exception ignored) {

        }
    }

    public void eat(int number) {
        System.out.println(Thread.currentThread().getName()+" is eating, last time: "+ (System.currentTimeMillis()-lastEatTime)+"ms ago.");
        lastEatTime = System.currentTimeMillis();
        try {
            Thread.sleep((int)(Math.random()*1000));
        } catch (Exception ignored) {

        }
    }


    enum PhilosopherState{
        waiting,
        thinking,
        eating
    }

}
