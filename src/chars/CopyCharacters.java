package chars;

public class CopyCharacters {

    public static void main(String[] args) {
        try {
            int cAsInt = System.in.read();
            while (cAsInt != -1) {
                char c = (char) cAsInt;
                if(c=='\r' || c=='\n'){

                }else{
                    System.out.print(c);
                }
                cAsInt = System.in.read();
            }
        }catch(Exception e){}
    }
}
