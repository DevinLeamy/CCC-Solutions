import java.util.*;

public class SpeedFinesAreNotFine {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the speed limit: ");
        int speedLimit = Integer.parseInt(in.nextLine());
        System.out.println("Enter the recorded speed of the car: ");
        int speedOfTheCar = Integer.parseInt(in.nextLine());
        int overBy = speedOfTheCar - speedLimit;
        if (overBy <= 0){
            System.out.println("Congratulations, you are within the speed limit!");
        } else if (overBy <= 20){
            System.out.println("You are speeding and your fine is $100.");
        } else if (overBy <= 30){
            System.out.println("You are speeding and your fine is $270.");
        } else {
            System.out.println("You are speeding and your fine is $500.");
        }

    }
}
