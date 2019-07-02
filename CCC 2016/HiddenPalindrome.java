import java.util.*;

public class HiddenPalindrome {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String word = in.nextLine();
        int shortest = 1;
        for (int i = 0; i < word.length(); i++){
            String temp = "";
            String reversed = "";
            for (int x = 0; x < (word.length() - i); x++){
                temp += String.valueOf(word.charAt(i + x));
                reversed = String.valueOf(word.charAt(i + x)) + reversed;
                if (temp.equals(reversed)){
                    if (temp.length() > shortest){
                        shortest = temp.length();
                    }
                }
            }
        }
        System.out.println(shortest);

    }
}
