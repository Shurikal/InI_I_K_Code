package exceptions;

public class Fehler {
    public static void main(String[] args) {
        //div0();
        //outOfBounds();
        Date a = new Date(29, "Feb", 2005);
        Date b = new Date(32, "Dez", 192);
    }

    public static void div0(){
        double d =1/0;
    }

    public static void outOfBounds(){
        int[] i = new int[0];
        i[1]= 0;
    }


}
