package gleitKomma;

public class Test {

    public static void main(String[] args){
        float myFloat = 123.456f;
        double myDouble = 123456.789d;
        System.out.println(String.format("%1e",myFloat));
        System.out.println(String.format("%1f",myFloat));
        System.out.println(String.format("%1g",myFloat));
        System.out.println(String.format("%1a",myFloat));

        System.out.println(String.format("%1e",myDouble));
        System.out.println(String.format("%1.2f",myDouble));
        System.out.println(String.format("%1g",myDouble));
        System.out.println(String.format("%1a",myDouble));
    }
}
