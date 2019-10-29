package collections.uebung1_2;

public class Person implements Comparable<Person>{
    String name;
    String vorname;
    int geburtsJahr;

    @Override
    public int compareTo(Person o) {
        int i = name.compareToIgnoreCase(o.name);
        if(i == 0){
            return vorname.compareToIgnoreCase(o.vorname);
        }
        return i;
    }

    @Override
    public String toString(){
        return (vorname + " " + name + " " + geburtsJahr);
    }
}
