import java.util.*;

public class NextInLine {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int youngest = Integer.parseInt(in.nextLine());
        int middle = Integer.parseInt(in.nextLine());
        System.out.println(middle + (middle - youngest));
    }
}
