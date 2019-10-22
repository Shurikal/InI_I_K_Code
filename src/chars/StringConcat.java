package chars;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class StringConcat {
    public static void main(String[] args) {
        new StringConcat().textAnalyse();
    }

    public static String cut(String s, int from, int to){
        if(s == null ||from > s.length() || to > s.length() || from < 0 || to < 0 || to < from){
            return s;
        }
        StringBuilder sb = new StringBuilder(s);
        sb.delete(from,to);
        return sb.toString();
    }

    public static void test() {
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("C://Users/Chris/Desktop/Test.txt")));
            String s = "";
            char c;
            long t = System.currentTimeMillis();

            int cAsInt = in.read();
            while (cAsInt != -1) {
                s = s + (char) cAsInt;

                cAsInt = in.read();
            }

            t = System.currentTimeMillis() - t;
            System.out.println(t);

            in.close();

        } catch (Exception e) {

        }
    }
    public static void test2() {
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                    new FileInputStream("C://Users/Chris/Desktop/Test.txt")));
            StringBuilder s = new StringBuilder();
            char c;
            long t = System.currentTimeMillis();

            int cAsInt = in.read();
            while (cAsInt != -1) {
                s.append((char)cAsInt);

                cAsInt = in.read();
            }

            t = System.currentTimeMillis() - t;
            System.out.println(t);

            in.close();

        } catch (Exception e) {

        }
    }

    public void paliTest(){
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("C://Users/Chris/Desktop/Test.txt")));

            StringBuilder s = new StringBuilder("");
            int cAsInt = in.read();
            while (cAsInt != -1) {
                if(Buchstaben.isLetter((char)cAsInt)) {
                    s.append(Buchstaben.toLowerCase((char)cAsInt));
                }
                cAsInt = in.read();
            }

            in.close();
            int h = s.length()/2+1;
            int i = 0;
            boolean b = true;
            while(i < h){
               b&= s.charAt(i) == s.charAt(s.length()-1-i);

                i++;
            }
            System.out.println(b);

        } catch (Exception e) {
           e.printStackTrace();

        }
    }

    public void textAnalyse(){
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("C://Users/Chris/Desktop/Test.txt")));

            StringBuilder s = new StringBuilder("");

            int[] arr = new int[65534];
            int cAsInt = in.read();
            while (cAsInt != -1) {
                arr[cAsInt]++;
                cAsInt = in.read();
            }

            for(int i = 0;i<arr.length;i++){
                if(arr[i]>0){
                    System.out.println("Der char '"+ (char)i+ "' ist " + arr[i] + " mal vorhanden");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
