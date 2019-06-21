import java.util.*;

public class RotatingLetters {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String letters = "IOSHZXN";
        String input = in.nextLine();

        boolean good = true;
        for (int i = 0; i < input.length(); i++){
            if (!letters.contains(String.valueOf(input.charAt(i)))){
                good = false;
                System.out.println("NO");
                break;
            }
        }
        if (good){
            System.out.println("YES");
        }
    }
}
