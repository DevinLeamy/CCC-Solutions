import java.util.*;

public class SlotMachine {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("How many quarters does Martha have in the jar?");
        int numQuarters = Integer.parseInt(in.nextLine());
        System.out.println("How many times has the first machine been played since paying out?");
        int machineOneGames = Integer.parseInt(in.nextLine());
        System.out.println("How many times has the second machine been played since paying out?");
        int machineTwoGames = Integer.parseInt(in.nextLine());
        System.out.println("How many times has the third machine been played since paying out?");
        int machineThreeGames = Integer.parseInt(in.nextLine());
        int counter = 0;

        while (numQuarters > 0){
            int machine = counter % 3;
            switch (machine){
                case 0:
                    machineOneGames++;
                    if (machineOneGames % 35 == 0){
                        numQuarters += 30;
                    }
                    numQuarters--;
                    break;
                case 1:
                    machineTwoGames++;
                    if (machineTwoGames % 100 == 0){
                        numQuarters += 60;
                    }
                    numQuarters--;
                    break;
                case 2:
                    machineThreeGames++;
                    if (machineThreeGames % 10 == 0){
                        numQuarters += 9;
                    }
                    numQuarters--;
                    break;
            }
            counter++;
        }
        System.out.println("Martha plays " + counter + " times before going broke.");
    }
}
