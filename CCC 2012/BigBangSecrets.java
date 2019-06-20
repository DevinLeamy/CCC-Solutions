import java.util.*;

public class BigBangSecrets {
    public static void main(String[] args){
        String alphabet = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
        Scanner in = new Scanner(System.in);
        int k = Integer.parseInt(in.nextLine());
        String cypherd = in.nextLine();
        String print = "";
        for (int i = 0; i < cypherd.length(); i++){
            int steps = (3 * (i + 1)) + k;
            int index = alphabet.indexOf(cypherd.charAt(i));
            print += String.valueOf(alphabet.charAt((index + steps) % 26));
        }
        System.out.println(print);


    }
}
