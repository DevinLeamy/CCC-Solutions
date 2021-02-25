import java.util.*;
import java.io.*;

public class ChooseYourOwnPath {
    private static List<Integer> getPages(int page, int[][] pages){
        List<Integer> output = new ArrayList<>();
        int[] set = pages[page];
        for (int i = 0; i < set.length; i++){
            output.add(set[i]);
        }
        if (output.size() == 0){
            output.add(-1);
        }
        return output;
    }
    private static boolean check(boolean[] reachable){
        for (boolean x: reachable){
            if (!x){
                return false;
            }
        }
        return true;
    }
    private static String[] solve(int[][] pages, boolean[] reachable){
        List<Integer> nextPages = new ArrayList<>();
        String[] output = new String[2];
        int currentShortest = Integer.MAX_VALUE;
        int current = 0;
        nextPages.add(0);
        while (nextPages.size() > 0){
            List<Integer> add = new ArrayList<>();
            for (int page: nextPages){
                if (page == -1){
                    if (current < currentShortest){
                        currentShortest = current;
                    }
                    continue;
                }
                if (!reachable[page]) {
                    reachable[page] = true;
                } else{
                    continue;
                }
                add.addAll(getPages(page, pages));
            }
            nextPages = new ArrayList<>(add);
            current++;
        }
        output[0] = (check(reachable))? "Y":"N";
        output[1] = String.valueOf(currentShortest);
        return output;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[][] pages = new int[N][N];
        boolean[] reachable = new boolean[N];
        for (int i = 0; i < N; i++){
            StringTokenizer line = new StringTokenizer(in.readLine());
            int M = Integer.parseInt(line.nextToken());
            int[] travelTo = new int[M];
            for (int j = 0; j < M; j++){
                travelTo[j] = Integer.parseInt(line.nextToken()) - 1;
            }
            pages[i] = travelTo;
        }
        String[] output = solve(pages, reachable);
        System.out.println(output[0]);
        System.out.println(output[1]);
    }
}
