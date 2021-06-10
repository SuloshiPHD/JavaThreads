package CoderByte;

import java.util.Scanner;
import java.util.StringTokenizer;

public class findLongestString {
    public static String LongestWord(String sen) {

        // code goes here
    /* Note: In Java the return type of a function and the
       parameter types being passed are defined, so this return
       call must match the return type of the function.
       You are free to modify the return type. */
        String longest = " ";
        StringTokenizer st = new StringTokenizer(sen, " \t\n!@#$%^&*()\\/'\"-_+=.,");

        while (st.hasMoreTokens()) {

            String tok = st.nextToken();
            if(tok.length()>longest.length()) {
                longest = tok;
            }
        }
        return longest;

    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(LongestWord(s.nextLine()));
    }
}
