import java.util.*;
import java.io.*;

public class AreWethereYet {
    private static int[][] getDistances(int[] D){
        int[][] distancesFrom = new int[5][5];
        for (int i = 0; i < 5; i++){
            int[] distances = new int[5];
            distances[i] = 0;
            for (int j = i; j < 4; j++){
                distances[j + 1] = distances[j] + D[j];
            }
            for (int j = i; j > 0; j--){
                distances[j - 1] = distances[j] + D[j - 1];
            }
            distancesFrom[i] = distances;
        }
        return distancesFrom;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] D = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] distances = getDistances(D);
        for (int i = 0; i < 5; i++){
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < 5; j++){
                line.append(distances[i][j]);
                line.append(" ");
            }
            System.out.println(line.toString());
        }

    }
}
