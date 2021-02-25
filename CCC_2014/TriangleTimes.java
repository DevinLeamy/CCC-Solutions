import java.util.*;

public class TriangleTimes {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int first = Integer.parseInt(in.nextLine());
        int second = Integer.parseInt(in.nextLine());
        int third = Integer.parseInt(in.nextLine());

        if (first + second + third != 180){
            System.out.println("Error");
        } else if (first != second && second != third && third != first){
            System.out.println("Scalene");
        } else if (first == second && second == third){
            System.out.println("Equilateral");
        } else {
            System.out.println("Isosceles");
        }
    }
}
