package collections.uebung1_2;


import java.util.*;

public class Collections_Test {

    public static void main(String[] args){

        ArrayList<Person> al = new ArrayList<>();
        for(int i = 0;i<200;i++){
            al.add(createRandomPerson());
        }
        System.out.println(al.toString());
        Collections.sort(al);
        System.out.println(al.toString());
        Collections.sort(al, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int i = o2.geburtsJahr-o1.geburtsJahr;
                if(i == 0){
                    int x = o1.name.compareToIgnoreCase(o2.name);
                    if(x == 0){
                        return o1.vorname.compareToIgnoreCase(o2.vorname);
                    }
                    return x;
                }
                return i;
            }
        });
        System.out.println(al);
    }


    public static Person createRandomPerson(){
        Random r = new Random();
        Person p = new Person();
        p.geburtsJahr = r.nextInt(20)+1999;
        switch(r.nextInt(5)){
            case 0:
                p.name = "Muster";
                break;
            case 1:
                p.name = "Müller";
                break;
            case 2:
                p.name = "Meier";
                break;
            case 3:
                p.name = "Sieber";
                break;
            default:
                p.name = "Frei";
        }
        switch(r.nextInt(5)){
            case 0:
                p.vorname = "Hans";
                break;
            case 1:
                p.vorname = "Klaus";
                break;
            case 2:
                p.vorname = "Peter";
                break;
            case 3:
                p.vorname = "Josh";
                break;
            default:
                p.vorname = "Otto";
        }
        return  p;
    }
}
