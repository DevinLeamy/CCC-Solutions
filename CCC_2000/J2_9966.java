import java.util.*;

public class J2_9966 {
    private static boolean flip(String num){
        String output = "";
        for (int i = 0; i < num.length(); i++){
            String character = String.valueOf(num.charAt(i));
            if (character.equals("5") || character.equals("4") || character.equals("3") || character.equals("2") || character.equals("7")){
                return false;
            }
            switch (character){
                case "6":
                    character = "9";
                    break;
                case "9":
                   character = "6";
                   break;
                case "8":
                    break;
            }
            output = character + output;
        }
        return num.equals(output);
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the lower bound of the interval: ");
        int start = Integer.parseInt(in.nextLine());
        System.out.println("Enter the upper bound of the interval: ");
        int upper = Integer.parseInt(in.nextLine());
        int counter = 0;
        for (int i = start; i < upper; i++){
            String num = String.valueOf(i);
            if ((flip(num))){
                System.out.println(num);
                counter++;
            }
        }
        System.out.println("The number of rotatable numbers is: ");
        System.out.println(counter);
    }
}
