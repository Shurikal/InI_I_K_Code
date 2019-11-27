package collections_generics.uebung_Generics;

import collections_generics.uebung1_2.Person;

public class SortedListTest {

    public static void main(String[] args){
        MySortedList<Integer> list1 = new MySortedList<>();

        list1.add(1);
        list1.add(200);
        list1.add(12);
        list1.add(2000);
        list1.add(12);
        list1.add(5);
        list1.forEach(System.out::println);

        System.out.println(list1.findIndex(12,0,list1.size()));

        MySortedList<Person> list2 = new MySortedList<>();
        Person p = new Person("Hans","Maier",2001);
        Person p2 = new Person("Klaus","Bucher",2002);
        Person p3 = new Person("Franz","Meier",2003);
        list2.add(p);
        list2.add(p2);
        list2.add(p3);
        list2.forEach(System.out::println);
        p2.setName("Zor");
        list2.elementChanged(p2);
        list2.forEach(System.out::println);
    }
}
