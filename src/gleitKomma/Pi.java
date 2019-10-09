package gleitKomma;

public class Pi {

    public static void main(String[] args){
        System.out.println(pi(32000));
        System.out.println(pi());
    }

    public static double pi(int t){
        boolean b = true;
        double d = 0d;
        for(int i = 0;i<=t;i++){
            if(b){
                d = d + (1/((2d*i)+1d));
            }else{
                d = d - (1/((2d*i)+1d));
            }

            b = !b;
        }
        System.out.println("Error: " + (Math.PI-4*d));
        return 4*d;
    }

    public static double pi(){
        boolean b = true;
        double d = 0d;
        int i = 0;
        while(Math.abs(Math.PI-4*d)>Math.pow(10,-5)){
            if(b){
                d = d + (1/((2d*i)+1d));
            }else{
                d = d - (1/((2d*i)+1d));
            }
            i++;
            b = !b;
        }
        System.out.println("Error: " + (Math.PI-4*d));
        return 4*d;
    }
}
