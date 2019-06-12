//Problem 2 . Completed
import java.util.*;

public class UpAndDown {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int[] movements = new int[4];
        int counter = 0;
        while (counter < 4)
        {
            movements[counter] = in.nextInt();
            counter++;
        }

        int repeat = in.nextInt();
        //Steps per cycle
        int nikkyCycle = movements[0] + movements[1];
        int byronCycle = movements[2] + movements[3];
        System.out.println(nikkyCycle + " " + byronCycle);
        //Distance per cycle
        int nDis = movements[0] - movements[1];
        int bDis = movements[2] - movements[3];
        System.out.println(nDis + " " + bDis);
        //Number of complete cycles
        int nCycles = repeat / nikkyCycle;
        int bCycles = repeat / byronCycle;
        System.out.println(nCycles + " " + bCycles);
        //Distance traveled
        int traveledN = nCycles * nDis;
        int traveledB = bCycles * bDis;
        //Remaining steps
        int remainN = repeat % nikkyCycle;
        int remainB = repeat % byronCycle;
        System.out.println(remainB + " " + remainN);
        //Total distance traveled
        traveledN = (remainN <= movements[0])? traveledN + remainN: traveledN + movements[0] - (remainN - movements[0]);
        traveledB = (remainB <= movements[2])? traveledB + remainB: traveledB + movements[2] - (remainB - movements[2]);

        if (traveledB == traveledN) {System.out.println("Tied");}
        else {
            System.out.println((traveledB > traveledN)? "Byron": "Nikky");
        }



    }
}
