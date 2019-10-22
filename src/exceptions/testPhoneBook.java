package exceptions;

public class testPhoneBook {

	public static void main(String[] args) throws Exception {

		PhoneBook phoneBook = new PhoneBook(5);
		phoneBook.enter("Martin Messmer", 3_610_810);
		phoneBook.enter("Martin Messmer", 3_610_123); // Doppelter Eintrag
		phoneBook.enter("Chris", 1_234_567);
		phoneBook.enter("Schmidi", 7456123);
		phoneBook.enter("Philipp", 6543219);
		phoneBook.enter("Mazenauer", 9632581);

		int number = phoneBook.lookup("Martin Messmer");
		System.out.println("Martin Messmer: " + number);

		phoneBook.enter("Gabriel", 1478523); // Overflow
		phoneBook.enter("Christian", 123); // No valid PhoneNumber
		phoneBook.enter("Christian", 321321352); // No valid PhoneNumber
		
		System.out.println("Chris: " + phoneBook.lookup("Chris"));
	}
}

