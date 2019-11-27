package concurrency.uebungen_concurrency;

public class Parkhaussimulation {

    private Parkhaus ph;
    private Auto[] autos;

    public static void main(String[] args) {
        new Parkhaussimulation();
    }

    public Parkhaussimulation(){
        ph = new Parkhaus(5);
        autos = new Auto[10];

        int i = 1 ;

        for(Auto a : autos){
            a = new Auto(ph,""+i);
            a.start();
            i++;
        }
    }
}
