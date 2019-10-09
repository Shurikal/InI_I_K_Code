package gleitKomma;

public class Zins {

    public static void main(String[] args){
        zins(100, 1, 10);

    }

    public static void zins(double kapital, double zins, int zeit){
        System.out.println("Kapitalwert: \t\t"+ String.format("%1.2f",kapital));
        System.out.println("Zins in %: \t\t\t"+ String.format("%1.2f",zins));
        for(int i = 1; i<=zeit;i++){
            kapital = kapital * (1+(zins/100d));
            int ikapital = (int) (kapital *20);
            double dkapital = ikapital / 20d;
            System.out.println("Das Kapital am Ende des "+ i+". Jahres beträgt: \t\t"+ String.format("%1.2f",dkapital));
        }
    }
}
