package chars;

public class Buchstaben {

    public static void main(String[] args) {
        for(char c= ' '; c<128; c++){
            System.out.print("Character "+ c);
            System.out.print(" Code: "+(int)c);
            System.out.print(" isUpper? "+isUpperCase(c));
            System.out.print(" isLower? "+isLowerCase(c));
            System.out.print(" isLetter? "+isLetter(c));
            System.out.print(" isNumber? "+isDigit(c));
            System.out.print(" toUpper: "+toUpperCase(c));
            System.out.print(" toLower: "+toLowerCase(c));
            System.out.println();
        }
    }

    public static int anzKB(){
        int a = 'a';
        int z = 'z';
        return z-a+1;
    }

    public static int toInt(char c){
        return (int) c -'0';
    }

    public static int diff(){
        return 'a'-'A';
    }

    public static char plus3(){
        return (char) ('c'+3);
    }

    public static boolean isUpperCase(char c){
        return (c >= 'A' && c<= 'Z');
    }

    public static boolean isLowerCase(char c){
        return (c>='a' && c<= 'z');
    }

    public static boolean isLetter(char c){
        return isLowerCase(c) && isLowerCase(c);
    }

    public static boolean isDigit(char c){
        return (c>='0' && c <='9');
    }

    public static char toUpperCase(char c){
        if(isLowerCase(c)){
            return (char) (c-32);
        }
        return c;
    }

    public static char toLowerCase(char c){
        if(isUpperCase(c)){
            return (char) (c+32);
        }
        return c;
    }
}
