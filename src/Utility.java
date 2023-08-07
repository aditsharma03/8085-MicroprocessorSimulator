import java.util.NoSuchElementException;
import java.util.Scanner;

public class Utility {

    public static boolean isHexData(String str) {
        try{
            Integer.parseInt(str, 16);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public static String getInstructionFromCLI(String hex_address) throws NoSuchElementException {
        Scanner sc = new Scanner(System.in);
        System.out.printf("%s :  ", hex_address.toUpperCase());
        String instruction = sc.nextLine();
        instruction = instruction.strip();
        instruction = instruction.toUpperCase();
        
        return instruction;
    }

    public static String formatData(String str) {
        int len = str.length();
        if( len == 1 || len == 3 ){
            return "0"+str;
        }

        return str;
    }

    public static int hexToInt( String str ){
        return Integer.parseInt( str, 16 );
    }
    public static String intToHex( int num ){
        return Integer.toHexString( num );
    }


    public static String addition(String a, String b) {
        int len1 = a.length(), len2 = b.length();
        String ans = "";

        int i=len1-1, j=len2-1;
        while( i>=0 && j>=0 ){

            char digit1 = a.charAt(i), digit2 = b.charAt(j);

            ans = intToHex( hexToInt(""+digit1)+ hexToInt(""+digit2) )+ ans;

            i--;
            j--;
        }

        return ans;
    }

    public static String subtraction(String a, String b) {

        String ans = intToHex( hexToInt(a) - hexToInt(b) );

        return ans;
    }
}
