//C.Bach, 11.11.2015

package concurrency.ex05_synchronized;

public class Banking {
	public static void main(String[] args) {
		Bank myBank = new Bank();
		
		Thread t1 = new Clerk("Andrea M�ller", myBank);
		Thread t2 = new Clerk("Petra Schmitt", myBank);
		
		t1.start(); t2.start();
	}
}