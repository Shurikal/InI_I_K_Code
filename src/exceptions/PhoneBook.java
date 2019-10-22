package exceptions;

public class PhoneBook {
	private Entry[] entries;
	private int nEntries;

	public PhoneBook(int size) {
		entries = new Entry[size];
		nEntries = 0;
	}

	public void enter(String name, int phone) throws OverflowException,NoPhoneNumberException{
		if(nEntries >= entries.length){
			throw new OverflowException("Zu viele Einträge");
		}
		if(phone>9_999_999 || phone <1_000_000){
			throw new NoPhoneNumberException("Das ist keine zulässige Nummer" + phone);
		}

		try {
			if (nEntries < entries.length && lookup(name) == -1) {

			}else{
				System.out.println("Name ist schon vorhanden!");
			}
		}catch (NameNotFoundException e){
			entries[nEntries] = new Entry(name, phone);
			nEntries++;
		}

	}

	public int lookup(String name) throws NameNotFoundException{
		int i;
		for (i = 0; i < nEntries; i++) {
			if (name.equals(entries[i].getName())) {
				return entries[i].getPhone();
			}
		}
		throw new NameNotFoundException(name + "Wurde nicht gefunden");
	}

	public class OverflowException extends Exception {
		public OverflowException(String s){
			super(s);
		}
	}

	public class NoPhoneNumberException extends Exception{
		public NoPhoneNumberException(String s){
			super(s);
		}
	}

	public class NameNotFoundException extends Exception{
		public NameNotFoundException(String s){
			super(s);
		}
	}
}
