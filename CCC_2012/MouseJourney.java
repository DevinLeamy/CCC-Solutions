import java.util.*;

public class MouseJourney {
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        String[] RaC = in.nextLine().split(" ");
        int rows = Integer.parseInt(RaC[0]);
        int cols = Integer.parseInt(RaC[1]);
        int numCats = Integer.parseInt(in.nextLine());
        boolean[][] cages = new boolean[cols][rows];
        int[][] movesTaken = new int[cols][rows];

        for (int i = 0; i < numCats; i++) {
            String[] line = in.nextLine().split(" ");
            cages[Integer.parseInt(line[1]) - 1][Integer.parseInt(line[0]) - 1] = true;
        }
        movesTaken[0][0] = 1; //Start
        for (int currentC = 0; currentC < cols; currentC++) {
            for (int currentR = 0; currentR < rows; currentR++) {
                if (currentC == 0 && currentR == 0){ continue; }
                if (!cages[currentC][currentR]) {
                    int movesFromCurrent = 0;
                    try {
                        if (!cages[currentC - 1][currentR]) {
                            int vec1 = movesTaken[currentC - 1][currentR];
                            movesFromCurrent += vec1;
                        }
                    } catch (ArrayIndexOutOfBoundsException aioobe) {
                    }
                    try {
                        if (!cages[currentC][currentR - 1]) {
                            int vec2 = movesTaken[currentC][currentR - 1];
                            movesFromCurrent += vec2;
                        }
                    } catch (ArrayIndexOutOfBoundsException aioobe) {
                    }
                    movesTaken[currentC][currentR] = movesFromCurrent;
                }
            }
        }
        System.out.println(movesTaken[cols - 1][rows - 1]);
    }
}
