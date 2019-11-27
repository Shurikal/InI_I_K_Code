//C.Bach, 11.11.2015

package concurrency.ex05_synchronized;

import java.util.Random;

public class Clerk extends Thread {
	private Bank bank;
	private Random randomWaitTime;

	public Clerk(String name, Bank bank) {
		super(name);
		this.bank = bank;
		
		randomWaitTime = new Random();
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			/*
			 * Kontonummer einlesen; simuliert durch Wahl einer Zufallszahl zwischen 0 und 99
			 */
			int accountNumber = (int) (Math.random() * 100);

			/*
			 * �berweisungsbetrag einlesen; simuliert durch Wahl einer Zufallszahl zwischen -500 und +499
			 */
			float amount = (int) (Math.random() * 1000) - 500;

			bank.transferMoney(accountNumber, amount);
			
			System.out.println("" + System.currentTimeMillis() + ": " + Thread.currentThread().getName() + " transfer "+ amount + " to " + accountNumber + 
					"; new balance: " + bank.account[accountNumber].getBalance());
			
			
			try {
				Thread.sleep(randomWaitTime.nextInt(1000));
			} catch (InterruptedException e) {
			}

		}
	}
}

