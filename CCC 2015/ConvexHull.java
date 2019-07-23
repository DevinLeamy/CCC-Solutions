//Due to efficientcy this receives 8/15 on the online grader

import java.io.*;
import java.util.*;


public class ConvexHull {
    static class FastReader{
        BufferedReader br;
        FastReader()
        {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }
    private static final FastReader in = new FastReader();
    private static final StringTokenizer lineOne = new StringTokenizer(in.nextLine());
    private static final int K = Integer.parseInt(lineOne.nextToken()); //Size of the hull
    private static final int N = Integer.parseInt(lineOne.nextToken()); //Number of islands
    private static final int M = Integer.parseInt(lineOne.nextToken()); //Number of sea routes
    private static HashMap<Integer, String> islands = new HashMap<>();
    private static void initializeIslands(){
        for (int i = 1; i <= N; i++){
            islands.put(i, 1000000 + " " + -1);
        }
    }
    private static int shortest = 1000000000;
    private static ArrayList<int[]> getMoves(int current, int hull, HashMap<int[], int[]> routes, int time){
        ArrayList<int[]> moves = new ArrayList<>();
        ArrayList<int[]> keys = new ArrayList<>(routes.keySet());
        for (int i = 0; i < routes.size(); i++){
            int[] key = keys.get(i);
            int[] TandH = routes.get(keys.get(i));
            int H = TandH[1];
            if (key[0] == current){
                if ((hull - H) > 0){
                    moves.add(new int[] {key[1], (time + TandH[0]), (hull - H) });
                }
            } else if (key[1] == current){
                if ((hull - H) > 0){
                    moves.add(new int[] {key[0], (time + TandH[0]), (hull - H)});
                }
            }
        }
        return moves;
    }
    private static void findShortest(int current, int time, HashMap<int[], int[]> routes, ArrayList<Integer> traveled, int destination, int hull){
        if (time > shortest){
            return;
        }
        if (current == destination){
            if (time < shortest){
                shortest = time;
            }
            return;
        }
        String[] currentTandH = islands.get(current).split(" ");
        if (time <= Integer.parseInt(currentTandH[0]) && hull >= Integer.parseInt(currentTandH[1])){
            islands.replace(current, time + " " + hull);
        } else if (time > Integer.parseInt(currentTandH[0])){
            return;
        }
        traveled.add(current);
        ArrayList<Integer> hold = new ArrayList<>(traveled);
        ArrayList<int[]> moves = getMoves(current, hull, routes, time);
        if (moves.size() == 0){
            return;
        }
        for (int[] move: moves){
            traveled = new ArrayList<>();
            traveled.addAll(hold);
            if (!traveled.contains(move[0])) {
                findShortest(move[0], move[1], routes, traveled, destination, move[2]);
            }
        }
        traveled = new ArrayList<>();
        traveled.addAll(hold);
        traveled.add(current);
    }
    public static void main(String[] args){
        initializeIslands();
        ArrayList<Integer> findIndex = new ArrayList<>();
        ArrayList<int[]> keys = new ArrayList<>();
        ArrayList<int[]> values = new ArrayList<>();
        for (int i = 0; i < M; i++){
            StringTokenizer line = new StringTokenizer(in.nextLine());
            int A = Integer.parseInt(line.nextToken());
            int B = Integer.parseInt(line.nextToken());
            int T = Integer.parseInt(line.nextToken()); //Time
            int H = Integer.parseInt(line.nextToken()); //Wear on hull

            findIndex.add(T);
            Collections.sort(findIndex);
            int[] putKey = {i, A, B};
            int[] putValue = {T, H};
            keys.add(findIndex.indexOf(T), putKey);
            values.add(putValue);
        }
        HashMap<int[], int[]> routes = new HashMap<>();

        for (int i = 0; i < keys.size(); i++){
            int[] key = keys.get(i);
            int[] value = values.get(key[0]);
            int[] newKey = new int[] {key[1], key[2]};
            routes.put(newKey, value);
        }
        StringTokenizer lastLine = new StringTokenizer(in.nextLine());
        int A = Integer.parseInt(lastLine.nextToken());
        int B = Integer.parseInt(lastLine.nextToken());

        findShortest(A, 0, routes, new ArrayList<>(), B, K);
        System.out.println(
                (shortest == 1000000000)? -1: shortest
        );
    }
}
