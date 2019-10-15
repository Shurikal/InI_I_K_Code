package chars;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReplaceTabs {
    private static final int tabs = 12;

    public static void main(String[] args) {
        plot();
    }

    public static void plot(){
        int counter = 0;
        try {
            InputStream is = new FileInputStream("C://Users/xy/Desktop/Test.txt");
            int cAsInt = is.read();

            while(cAsInt != -1){

                if(counter < tabs){
                    if(cAsInt == '\t'){
                        while(counter < tabs){
                            System.out.print('-');
                            counter ++;
                        }
                        counter =0;
                    }else if(cAsInt == '\n') {
                        System.out.println();
                        counter = 0;
                    }else{
                        System.out.print((char)cAsInt);
                        counter ++;
                    }
                }else{
                    counter =0;
                }
                cAsInt = is.read();
            }
        }catch(Exception e){

        }
    }

}
