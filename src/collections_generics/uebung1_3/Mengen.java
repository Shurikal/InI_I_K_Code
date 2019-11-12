package collections_generics.uebung1_3;

import java.util.HashSet;

public class Mengen {
    public static void main(String[] args){
        HashSet<Integer> a = new HashSet<>();
        HashSet<Integer> b = new HashSet<>();

        for (int i = 1; i < 8; i++) {
            a.add(i);
        }
        for (int i = 4; i < 13; i += 2) {
            b.add(i);
        }
        System.out.println("A :"+ a);
        System.out.println("B :" +b);

        HashSet<Integer> result = new HashSet<>();
        result.addAll(a);
        result.retainAll(b);
        System.out.println("Schnittmenge: " + result);
        result.addAll(a);
        result.addAll(b);
        System.out.println("Vereinigugnsmenge "+ result);
        result.removeAll(b);
        System.out.println("A ohne B :" + result);
    }
}
