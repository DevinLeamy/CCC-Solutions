import java.util.*;
import java.io.*;

public class RoboThieves {
    private static void fill(String[][] grid, boolean[][] visited, int x, int y){
        for (int i = 0; i < 4; i++) {
            int currentA = 0;
            while (true) {
                try {
                    String room;
                    switch (i) {
                        case 0:
                            room = grid[x - currentA][y];
                            if (room.equals("W")) {
                                currentA += 101;
                            } else {
                                visited[x - currentA][y] = true;
                            }
                            currentA++;
                            break;
                        case 1:
                            room = grid[x + currentA][y];
                            if (room.equals("W")) {
                                currentA += 101;
                            } else {
                                visited[x + currentA][y] = true;
                            }
                            currentA++;
                            break;
                        case 2:
                            room = grid[x][y + currentA];
                            if (room.equals("W")) {
                                currentA += 101;
                            } else {
                                visited[x][y + currentA] = true;
                            }
                            currentA++;
                            break;
                        case 3:
                            room = grid[x][y - currentA];
                            if (room.equals("W")) {
                                currentA += 101;
                            } else {
                                visited[x][y - currentA] = true;
                            }
                            currentA++;
                            break;
                    }
                } catch (ArrayIndexOutOfBoundsException aioobe) {
                    break;
                }
            }
        }
    }
    private static int[] newPosition(String[][] grid, int[] current, String room){
        int x = current[0], y = current[1];
        switch (room) {
            case "L":
                return newPosition(grid, new int[]{x, y - 1}, grid[x][y - 1]);
            case "D":
                return newPosition(grid, new int[]{x + 1, y}, grid[x + 1][y]);
            case "U":
                return newPosition(grid, new int[]{x - 1, y}, grid[x - 1][y]);
            case "R":
                return newPosition(grid, new int[]{x, y + 1}, grid[x][y + 1]);
            case ".":
                return current;
        }
        return new int[] {};
    }
    private static List<int[]> getMoves(String[][] grid, int[] current, List<int[]> shifts){
        List<int[]> moves = new ArrayList<>();
        String movements = "LRUD";
        int x = current[0], y = current[1];
        for (int[] shift: shifts){
            int newX = x + shift[0];
            int newY = y + shift[1];
            if (newX == grid.length || newY == grid[0].length || newX < 0 || newY < 0){
                continue;
            }
            String room = grid[newX][newY];
            if (movements.contains(room)){
                int[] pos = newPosition(grid, new int[] {newX, newY}, room);
                if (pos.length != 0){
                    moves.add(new int[] {pos[0], pos[1]});
                }
            } else if (room.equals(".")){
                moves.add(new int[]{newX, newY});
            }
        }
        return moves;
    }
    private static void solve(String[][] grid, int[] start, boolean[][] visited, int[][] distance){
        List<int[]> next = new ArrayList<>();
        List<int[]> shifts = new ArrayList<>();
        shifts.add(new int[] {0, 1}); shifts.add(new int[] {1, 0});
        shifts.add(new int[] {-1, 0}); shifts.add(new int[] {0, -1});
        next.add(start);
        int currentDistance = 0;
        while (next.size() > 0){
            List<int[]> add = new ArrayList<>();
            for (int[] move: next){
                int x = move[0];
                int y = move[1];
                if (!visited[x][y]) {
                    String room = grid[x][y];
                    if (room.equals(".")){
                        int hold = distance[x][y];
                        if (hold == -1){
                            distance[x][y] = currentDistance;
                        } else if (currentDistance < hold) {
                            distance[x][y] = currentDistance;
                        }
                    }
                    visited[move[0]][move[1]] = true;
                    List<int[]> moves = getMoves(grid, move, shifts);
                    add.addAll(moves);
                }
            }
            currentDistance++;
            next = new ArrayList<>(add);
        }
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (distance[i][j] != 0){
                    System.out.println(distance[i][j]);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer NM = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(NM.nextToken()), M = Integer.parseInt(NM.nextToken());
        String[][] grid = new String[N][M];
        boolean[][] visited = new boolean[N][M];
        int[][] distance = new int[N][M];
        int[] start = new int[2];
        for (int i = 0; i < N; i++){
            String[] line = in.readLine().split("");
            for (int j = 0; j < M; j++){
                String nextToken = line[j];
                if (nextToken.equals("S")){
                    start[0] = i;
                    start[1] = j;
                } else if (nextToken.equals(".")){
                    distance[i][j] = -1;
                }
                grid[i][j] = nextToken;
            }
        }
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (grid[i][j].equals("C")){
                    fill(grid, visited, i, j);
                }
            }
        }
        solve(grid, start, visited, distance);
    }
}
