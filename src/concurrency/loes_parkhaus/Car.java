package concurrency.loes_parkhaus;

class Car extends Thread {
	private ParkingGarageFair garage;

	public Car(String name, ParkingGarageFair garage) {
		super(name);
		this.garage = garage;
	}

	public void run() {
		while (true) {
			try { sleep((int)(Math.random() * 5000)); } catch (InterruptedException e) {}
			
			garage.enter();
			//System.out.println(getName() + ": eingefahren; verf�gbar: " + garage.getPlaces());
			
			try { sleep((int)(Math.random() * 10000)); } catch (InterruptedException e) {}
			
			//System.out.println(getName() + ": ausgefahren; verf�gbar:" + garage.getPlaces());
			garage.leave();
		}
	}
	
	public String toString() {
		return getName();
	}
}
