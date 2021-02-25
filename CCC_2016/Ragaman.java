import java.util.*;

public class Ragaman {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String A = in.nextLine();
        String B = in.nextLine();

        int counter = 0;
        int L = A.length();
        for (int i = 0; i < L; i++){
            String character = String.valueOf(B.charAt(i));
            if (character.equals("*")) {
                counter++;
                continue;
            }
            int hold = A.length();
            A = A.replaceFirst(character, "");
            if (hold == A.length()){
                System.out.println("N");
                System.exit(0);
            }
        }
        if (counter == A.length()){
            System.out.println("A");
        }
    }
}
