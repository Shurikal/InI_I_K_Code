package ganzeZahlen;

public class OutputStreamTest {
    //https://docs.oracle.com/javase/tutorial/essential/io/formatting.html
    //https://docs.oracle.com/javase/8/docs/api/java/util/Formatter.html#syntax

    public static void main(String[] args){
        int i = 16;
        double d = 1231.2323;
        double dm = -1231.2323;
        String octal = String.format("%o",i);   //oktal
        String hex = String.format("%x",i);

        String left = String.format("%1$-20f | %2$-20f ",d,dm);
        String right = String.format("%1$20f | %2$20f",d,dm);
        String vor = String.format("%1$+20f | %2$+20f",d,dm);
        String nullen = String.format("%1$020f | %2$020f",d,dm);
        String gruppen = String.format("%1$+,20f | %2$+,20f",d,dm);

        System.out.println("Die Zahl ist dezimal: "+ i+ " oktal: " + octal +" hex: "+ hex);
        System.out.println(left);
        System.out.println(right);
        System.out.println(vor);
        System.out.println(nullen);
        System.out.println(gruppen);

        System.out.println((short)1234L);
    }
}
