//C.Bach, 11.11.2015

package concurrency.ex05_synchronized;


public class Bank {
	public  Account[] account;


	public Bank() {
		account = new Account[100];
		for (int i = 0; i < account.length; i++) {
			account[i] = new Account();
		}
	}


	//unguenstig: nur ein Thread kann die Bank nutzen
	public synchronized void transferMoney_Variante1(int accountNumber, float amount) {
		float oldBalance = account[accountNumber].getBalance(); 
		float newBalance = oldBalance + amount; 
		account[accountNumber].setBalance(newBalance); 
	}


	//ubesser: jedes Account kann nur einmal genutzt werden
	public void transferMoney(int accountNumber, float amount) {
		synchronized (account[accountNumber]) {
			float oldBalance = account[accountNumber].getBalance();
			float newBalance = oldBalance + amount;
			account[accountNumber].setBalance(newBalance);
		}
	}
}

