package collections_generics.uebung_Generics;

import java.util.Collection;
import java.util.function.Predicate;

public class MyUtilities {

    public static <T> T[] swap(T[] array,int a,int b) {
        T cache = array[a];
        array[a] = array[b];
        array[b] = cache;
        return array;
        }

     public static <T> int count(Collection<T> c, Predicate<T> p){
        int counter = 0;
        for(T t : c){
            if(p.test(t)){
                counter++;
            }
        }
        return counter;
     }

     public static <T extends Comparable<? super T>> T find(T[] array,int von, int bis){
         T cache = array[0];
        for(T t : array){
            if(cache.compareTo(t) < 0){
                cache = t;
            }
        }
        return cache;
     }
}
