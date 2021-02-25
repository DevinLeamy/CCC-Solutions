import java.util.*;

public class WinningScore {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int A = 0;
        int B = 0;
        A += (3 * Integer.parseInt(in.nextLine()));
        A += (2  * Integer.parseInt(in.nextLine()));
        A += Integer.parseInt(in.nextLine());

        B += (3 * Integer.parseInt(in.nextLine()));
        B += (2  * Integer.parseInt(in.nextLine()));
        B += Integer.parseInt(in.nextLine());

        if (A == B) {System.out.println("T");}
        else {System.out.println((A > B)? "A":"B");}
    }
}
