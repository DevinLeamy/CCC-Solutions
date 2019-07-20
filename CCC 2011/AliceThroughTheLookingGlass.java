import java.util.*;
import java.lang.Math;

public class AliceThroughTheLookingGlass {
    public static String magnifie(int magnification, int currentX, int currentY, boolean[][] original){
        boolean[][] current = Arrays.stream(original).toArray(boolean[][]::new);
        for (int i = 1; i < magnification; i++){
            Double myDouble = Math.pow(5, i+1);
            boolean[][] magnified = new boolean[myDouble.intValue()][myDouble.intValue()];
            for (int x = 0; x < magnified.length; x++){
                Arrays.fill(magnified[x], Boolean.FALSE);
            }
            for (int w = 0; w < current.length; w++){
                for (int x = 0; x < current.length; x++){
                    if (current[w][x]){
                        int minX;
                        int minY;
                        int maxX;
                        int maxY;

                        if (x == 0){
                            minX = x + 4;
                            maxX = x + 9;
                        } else {
                            minX = 4 * x + x;
                            maxX = (4 * x + x) + 4;
                        }
                        if (w == 0){
                            minY = 0;
                            maxY = 4;
                        } else{
                            minY = w * 4 + w;
                            maxY = (w * 4 + w) + 4;
                        }
                        for (int startY = minY; startY <= maxY; startY++) {
                            for (int startX = minX; startX <= maxX; startX++) {
                                magnified[startY][startX] = true;
                                if (startY == maxY && startX != maxX && startX != minX){
                                    magnified[startY + 1][startX] = true;
                                    if (startX == maxX - 2){
                                        magnified[startY+2][startX] = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
           current = Arrays.stream(magnified).toArray(boolean[][]::new);
        }
        if (current[currentY][currentX]){
            return "crystal";
        } else {
            return "empty";
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int numValues = Integer.parseInt(in.nextLine());
        boolean[][] cristal = {
                {false, true, true, true, false},
                {false, false, true, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false}
        };
        for (int i = 0; i < numValues; i++){
            String[] values = in.nextLine().split(" ");
            int magnification = Integer.parseInt(values[0]);
            int currentX = Integer.parseInt(values[1]);
            int currentY = Integer.parseInt(values[2]);
            System.out.println(magnifie(magnification, currentX, currentY, cristal));
        }
    }
}
