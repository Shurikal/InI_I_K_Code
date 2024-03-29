package collections_generics.bsp5_Generics;

public class Box<T> {
	private T boxedT;
	
	public Box() {
		boxedT = null;
	}
	
	public Box(T t) {
		box(t);
	}
	
	public void box(T t) {
		boxedT = t;
	}
	
	public T unbox() {
		return boxedT;
	}
	
	public String toString() {
		return "boxed: " + boxedT.toString();
	}
	
}
