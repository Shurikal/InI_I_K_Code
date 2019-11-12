package collections_generics.bsp6_Generics_BoundedTypes;

public class Test_2_GenericMethods {
	
	//generische Methode, die nur Typen T akzeptiert, die das Interface Comparable implementieren
	public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {
	    int count = 0;
	    for (T e : anArray) {
	        if (e.compareTo(elem) > 0) {
	            count++;
	        }
	    }
	    return count;
	}
	
	public static void main(String[] args) {
		/*
		Article[] l = new Article[2]; l[0] = new Article(1234, 50); l[1] = new Article(4567, 50);
		System.out.println("Array  enth�lt " + countGreaterThan(l, new Article(2222, 25)) +
				" Elemente, die gr�sser sind.");
		*/

		Integer[] a = {20, 1, 34, 45, 9};
		
		System.out.println("Array {20, 1, 34, 45, 9} enth�lt " + countGreaterThan(a, 9) +
				" Elemente, die gr�sser als 9 sind.");
		

		
		String[] s = {"Meier", "M�ller", "Bach", "Schmid"};
		
		System.out.println("Array {\"Meier\", \"M�ller\", \"Bach\", \"Schmid\"} enth�lt " + countGreaterThan(s, "Mi") +
				" Elemente, die gr�sser als \"Mi\" sind.");

	}

}
