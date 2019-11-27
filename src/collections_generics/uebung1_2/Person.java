package collections_generics.uebung1_2;

public class Person implements Comparable<Person>{


    String name;
    String vorname;
    int geburtsJahr;
    public Person(){

    }

    public Person(String vorname, String name, int geburtsJahr){
        this.name = name;
        this.vorname = vorname;
        this.geburtsJahr = geburtsJahr;
    }

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

    public void setName(String name) {
        this.name = name;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public void setGeburtsJahr(int geburtsJahr) {
        this.geburtsJahr = geburtsJahr;
    }
}
