// 13/15 on Online Grader

import java.util.*;
import java.io.*;

public class WhoIsTaller {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(line.nextToken()); //Number of class mates
        int M = Integer.parseInt(line.nextToken()); //Number of comparisons
        List<int[]> comparisons = new ArrayList<>();
        for (int i = 0; i < M; i++){
            StringTokenizer comp = new StringTokenizer(in.readLine());
            int taller = Integer.parseInt(comp.nextToken()) - 1; //Taller person
            int other = Integer.parseInt(comp.nextToken()) - 1;
            comparisons.add(new int[] {taller, other});
        }
        StringTokenizer lastLine = new StringTokenizer(in.readLine());
        int A = Integer.parseInt(lastLine.nextToken()) - 1;
        int B = Integer.parseInt(lastLine.nextToken()) - 1;
        //Q: Is "A" taller than "B"?
        Solver input = new Solver();
        System.out.println(input.solve(N, M, comparisons, A, B));
    }
}
class Solver {
    public static String solve(int N, int M, List<int[]> comparisons, int A, int B) {
        ArrayList<Integer> currentChildren = new ArrayList<>();
        currentChildren.add(A);
        ArrayList<Integer> currentParents = new ArrayList<>();
        currentParents.add(A);

        //Under index i are the nodes larger then i
        ArrayList<Integer>[] largerThen = new ArrayList[N];
        for (int i = 0; i < N; i++){
            largerThen[i] = new ArrayList<>();
        }
        for (int[] comparison: comparisons){
            int bigger = comparison[0];
            int other = comparison[1];
            largerThen[other].add(bigger);
        }
        //Under index i are the nodes smaller then i
        ArrayList<Integer>[] smallerThen = new ArrayList[N];
        for (int i = 0; i < N; i++){
            smallerThen[i] = new ArrayList<>();
        }
        for (int[] comparison: comparisons){
            int bigger = comparison[0];
            int other = comparison[1];
            smallerThen[bigger].add(other);
        }
        //Get A's child nodes
        while (currentChildren.size() > 0){
            ArrayList<Integer> next = new ArrayList<>();
            for (int num: currentChildren){
                ArrayList<Integer> set = smallerThen[num];
                if (set.size() == 0){
                    continue;
                }
                for (int x: set){
                    if (x == B){
                        return "yes";
                    }
                    next.add(x);
                }
            }
            currentChildren = new ArrayList<>(next);
        }
        //Get A's parent nodes
        while (currentParents.size() > 0){
            ArrayList<Integer> next = new ArrayList<>();
            for (int num: currentParents){
                ArrayList<Integer> set = largerThen[num];
                if (set.size() == 0){
                    continue;
                }
                for (int x: set){
                    if (x == B){
                        return "no";
                    }
                    next.add(x);
                }
            }
            currentParents = new ArrayList<>(next);
        }
        return "unknown";
    }
}

