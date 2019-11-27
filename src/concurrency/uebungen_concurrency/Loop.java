package concurrency.uebungen_concurrency;

public class Loop extends Thread
{

    int t;
    long old_time;

    public Loop(String name, int t)  {
        super(name);
        this.t = t;
    }

    public void run()  {
        old_time = System.nanoTime();
        for(int i = 1; i <= 10; i++)  {
            System.out.println(System.nanoTime()-old_time);
            old_time = System.nanoTime();
            System.out.print(getName() + " (" + i + ") ");
            try {
				Thread.sleep(t);
			} catch (InterruptedException e) {
			}
        }
    }

    public static void main(String[] args)
    {
        Loop t1 = new Loop("a",1);
        Loop t2 = new Loop("b",2);
        Loop t3 = new Loop("c",3);
        t1.start(); 
        t2.start();
        t3.start();
    }
}