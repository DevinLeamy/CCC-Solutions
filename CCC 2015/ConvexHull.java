//Receives 13/15 on the Online Grader due to incorrect answers

import java.io.*;
import java.util.*;

public class ConvexHullV2 {
    static class FastReader{
        BufferedReader br;
        FastReader()
        {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String nextLine() throws IOException
        {
            return br.readLine();
        }
    }
    private static int K;
    private static int M;
    private static int N;
    private static int getMin(int[] timeKeys, int[] hullKeys, boolean[] added){
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < N; i++) {
            if (!added[i]) {
                int key = timeKeys[i];
                if (key < min && hullKeys[i] > 0) {
                    min = key;
                    minIndex = i;
                }
            }
        }
        return minIndex;
    }
    private static void findShortest(ArrayList<int[]> routes, int[] timeKeys, int[] hullKeys, int[] parentNodes, boolean[] added, int destination){
        for (int counter = 0; counter < N; counter++){
            int u = getMin(timeKeys, hullKeys, added);
            if (u == -1){
                System.out.println(-1);
                System.exit(0);
            }
            added[u] = true;
            if (u == destination){
                System.out.println(timeKeys[u]);
                System.exit(0);
            }
            if (counter == (N-1)){
                System.out.println(-1);
            }
            int currentT = timeKeys[u];
            int currentH = hullKeys[u];
            for (int[] route: routes){
                int newTime = route[2] + currentT;
                int newHull = currentH - route[3];
                int A = route[0];
                int B = route[1];
                if (A == u && !added[B]){
                    if (newTime < timeKeys[B] && newHull > 0){
                        parentNodes[B] = u;
                        hullKeys[B] = newHull;
                        timeKeys[B] = newTime;
                    }
                } else if (B == u && !added[A]){
                    if (newTime < timeKeys[A] && newHull > 0){
                        parentNodes[A] = u;
                        hullKeys[A] = newHull;
                        timeKeys[A] = newTime;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        FastReader in = new FastReader();
        StringTokenizer lineOne = new StringTokenizer(in.nextLine());
        K = Integer.parseInt(lineOne.nextToken()); //Hull
        N = Integer.parseInt(lineOne.nextToken()); //Islands
        M = Integer.parseInt(lineOne.nextToken()); //Routes

        ArrayList<int[]> routes = new ArrayList<>();
        for (int i = 0; i < M; i++){
            StringTokenizer line = new StringTokenizer(in.nextLine());
            int A = Integer.parseInt(line.nextToken()) - 1;
            int B = Integer.parseInt(line.nextToken()) - 1;
            int T = Integer.parseInt(line.nextToken()); //Time
            int H = Integer.parseInt(line.nextToken()); //Hull
            routes.add(new int[] {A, B, T, H});
        }
        StringTokenizer lastLine = new StringTokenizer(in.nextLine());
        int start = Integer.parseInt(lastLine.nextToken()) - 1;
        int destination = Integer.parseInt(lastLine.nextToken()) - 1;

        int[] parentNodes = new int[N];
        int[] timeKeys = new int[N];
        int[] hullKeys = new int[N];
        boolean[] added = new boolean[N];

        for (int i = 0; i < N; i++){
            timeKeys[i] = Integer.MAX_VALUE;
            hullKeys[i] = Integer.MIN_VALUE;
            added[i] = false;
        }
        parentNodes[start] = -1;
        timeKeys[start] = 0;
        hullKeys[start] = K;
        findShortest(routes, timeKeys, hullKeys, parentNodes, added, destination);
    }
}
