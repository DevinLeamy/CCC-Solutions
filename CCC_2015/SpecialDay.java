import java.util.*;

public class SpecialDay {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int month = Integer.parseInt(in.nextLine());
        int day = Integer.parseInt(in.nextLine());
        if (month == 2 && day == 18) {System.out.println("Special");}
        else if (month == 2 && day > 18) {System.out.println("After");}
        else {
            System.out.println((month >= 3)? "After":"Before");
        }
    }
}
