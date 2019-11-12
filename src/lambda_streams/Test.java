package lambda_streams;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test{

    public static void main(String[] args) {
        aufgabe2();
    }

    public static void aufgabe1(){
        //funktioniert nicht -> Typ falsch
        //final LongBinaryOperator v1= (long x,Long y) -> {return x+y; };

        //iO
        final LongBinaryOperator v2= (long x,long y) -> {return x+y; };
        System.out.println("v2 :" +v2.applyAsLong(1L,2L));

        //iO
        final LongBinaryOperator v3= (long x,long y) ->x+y;
        System.out.println("v3 :" +v3.applyAsLong(2L,3L));

        //Typenbezeichnung nur einmal weggelassen
        //final LongBinaryOperator v4= (long x,y) ->x+y;

        //iO
        final LongBinaryOperator v5= (x,y) ->x+y;

        //Bei 2 Parametern muss eine Klammer verwendet werden
       // final LongBinaryOperator v6= x,y->x+y;


    }

    public static void aufgabe2(){
        String s = "Test";
        final Runnable runner = () -> {
            System.out.println("Hello from lambda world!"+s);
        };
        new Thread(runner).start();

    }

    public static void aufgabe3(){
        final List<String> names= Arrays.asList("Josef","JÖrg","Jürgen");

        final Comparator<String> byLength= new Comparator<String>(){
            @Override
            public int compare(final String str1,final String str2){
                return Integer.compare(str1.length(),str2.length());}};

        final Comparator<String> byLengthLambda =(str1,str2) ->{
            return Integer.compare(str1.length(), str2.length());};

        final Comparator<String> byLengthMethod = Comparator.comparingInt(String::length);

        final Comparator<String> caseInsensitive = new Comparator<String>(){
            @Override
            public int compare(final String str1,final String str2){
                return str1.compareToIgnoreCase(str2);}};
        Collections.sort(names,byLength);
        System.out.println(names);
        Collections.sort(names,caseInsensitive);
        System.out.println(names);
    }

    public static void aufgabe5(){
        final FileFilter directoryFilter = new FileFilter(){
            @Override
            public boolean accept(final File pathname){
                return pathname.isDirectory();
            }
        };

        final FileFilter pdfFileFilter = new FileFilter(){
            @Override
            public boolean accept(final File pathname){
                return (pathname.isFile() && pathname.getName().toLowerCase().endsWith(".pdf"));
            }
        };
    }

}
