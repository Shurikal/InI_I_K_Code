//C.Bach, 11.11.2015

package concurrency.ex04_Termination;

public class StopThreadByInterruptSleep extends Thread {
	public StopThreadByInterruptSleep(String name) {
		super(name);
	}

	public void run() {
		int i = 0;
		try {
			while (!isInterrupted()) {
				i++;
				System.out.println(getName() + ": Hallo Welt (" + i + ")");
				sleep(10);
			}
		} catch (InterruptedException ex) {
			System.out.println(getName() + ":  in InterruptedException-Hander: " + ex.getMessage());
		}
		System.out.println(getName() + ":  terminiert.");
	}

	public static void main(String[] args) {
		StopThreadByInterruptSleep st = new StopThreadByInterruptSleep("T1");
		st.start(); // lass st etwas laufen

		try {
			Thread.sleep(55);
		} catch (InterruptedException e) {
		}
		System.out.println(Thread.currentThread().getName() + ": Interrupt Anforderung wird an Thread " + st.getName()
				+ " gesendet.");
		st.interrupt();
		System.out.println(Thread.currentThread().getName() + ": Interrupt Anforderung wurde an Thread " + st.getName()
				+ " gesendet.");

		try {
			st.join();
		} catch (InterruptedException e) {
		}
		System.out.println("Thread " + st.getName() + " wurde beendet. Join mit Thread "
				+ Thread.currentThread().getName() + " erfolgt.");

		System.out.println("Thread " + Thread.currentThread().getName() + " terminiert.");
	}
}