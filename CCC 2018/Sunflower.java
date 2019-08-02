import java.io.*;

public class Sunflower {
    private static int getTopLeft(String[][] grid, int N){
        int[] cTopLeft = {0, 0}, cTopRight = {0, N - 1};
        int[] cBottomLeft = {N - 1, 0}, cBottomRight = {N - 1, N - 1};
        int[][] corners = {cTopLeft, cBottomLeft, cBottomRight, cTopRight};
        for (int i = 0; i < 4; i++){
            int[] corner = corners[i];
            int cornerV = Integer.parseInt(grid[corner[0]][corner[1]]);
            switch (i){
                case 0:
                    if (cornerV < Integer.parseInt(grid[1][0]) && cornerV < Integer.parseInt(grid[0][1])){
                        return i;
                    }
                    break;
                case 1:
                    if (cornerV < Integer.parseInt(grid[N - 2][0]) && cornerV < Integer.parseInt(grid[N - 1][1])){
                        return i;
                    }
                    break;
                case 2:
                    if (cornerV < Integer.parseInt(grid[N - 2][N - 1]) && cornerV < Integer.parseInt(grid[N - 1][N - 2])){
                        return i;
                    }
                    break;
                case 3:
                    if (cornerV < Integer.parseInt(grid[0][N - 2]) && cornerV < Integer.parseInt(grid[1][N - 1])){
                        return i;
                    }
                    break;
            }
        }
        return -1;
    }
    private static String[][] rotate(String[][] grid, int Z, int N){
        String[][] newGrid;
        while (Z > 0) {
            newGrid = new String[N][N];
            for (int i = 0; i < N; i++) {
                String[] line = new String[N];
                for (int j = N - 1; j >= 0; j--) {
                    line[N - 1 - j] = grid[j][i];
                }
                newGrid[i] = line;
            }
            grid = newGrid.clone();
            Z--;
        }
        return grid;
    }
    private static String[][] solve(String[][] grid, int N){
        int corner = getTopLeft(grid, N);
        return rotate(grid, corner, N);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        String[][] grid = new String[N][N];
        for (int i = 0; i < N; i++){
            String[] line = in.readLine().split(" ");
            grid[i] = line;
        }
        String[][] output = solve(grid, N);
        for (int i = 0; i < N; i++){
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < N; j++){
                line.append(output[i][j] + " ");
            }
            System.out.println(line.toString());
        }
    }
}
