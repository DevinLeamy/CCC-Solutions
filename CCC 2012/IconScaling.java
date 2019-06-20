import java.util.*;

public class IconScaling {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int scale = Integer.parseInt(in.nextLine());
        String star = "*";
        String x = "X";
        String none = " ";

        for (int i = 0; i < scale - 1; i++){
            star += "*";
            x += "X";
            none += " ";
        }
        for (int i = 0; i < scale; i++){
            System.out.println(star + x + star);
        }
        for (int i = 0; i < scale; i++){
            System.out.println(none + x + x);
        }
        for (int i = 0; i < scale; i++){
            System.out.println(star + none + star);
        }
    }
}
