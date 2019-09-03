//Uses Prim's Minimum Spanning Tree Algorithm. Passes 16/22 test cases

import java.util.*;
import java.io.*;

public class MaximumStrategicSavings {
    private static long[] getMin(long[][] keys, boolean[][] added)
    {
        long min = Long.MAX_VALUE;
        int[] add = {-1, -1};
        for (int i = 0; i < keys.length; i++)
        {
            for (int j= 0; j < keys[0].length; j++)
            {
                if (!added[i][j])
                {
                    if (keys[i][j] < min)
                    {
                        min = keys[i][j];
                        add[0] = i;
                        add[1] = j;
                    }
                }
            }
        }
        return new long[] {min, add[0], add[1]};
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line = new StringTokenizer(in.readLine());
        long N, M, P, Q, a, b, c, d, e, f;
        N = Long.parseLong(line.nextToken());
        M = Long.parseLong(line.nextToken());
        P = Long.parseLong(line.nextToken());
        Q = Long.parseLong(line.nextToken());
        ArrayList< ArrayList< long[] > > adjp = new ArrayList<>();
        ArrayList< ArrayList <long[] > > adjt = new ArrayList<>();

        for (int i = 0; i < M; i++)
        {
            adjp.add(new ArrayList<>());
        }
        for (int i = 0; i < N; i++)
        {
            adjt.add(new ArrayList<>());
        }
        long totalCost = 0L;
        for (int i = 0 ;i < P; i++)
        {
            line = new StringTokenizer(in.readLine());
            a = Long.parseLong(line.nextToken()) - 1;
            b = Long.parseLong(line.nextToken()) - 1;
            c = Long.parseLong(line.nextToken());
            if (a != b)
            {
                adjp.get((int) a).add(new long[]{b, c});
                adjp.get((int) b).add(new long[]{a, c});
            }
            totalCost += c * N;
        }



        for (int i = 0; i < Q; i++)
        {
            line = new StringTokenizer(in.readLine());
            d = Long.parseLong(line.nextToken()) - 1;
            e = Long.parseLong(line.nextToken()) - 1;
            f = Long.parseLong(line.nextToken());
            if (d != e)
            {
                adjt.get((int) d).add(new long[]{e, f});
                adjt.get((int) e).add(new long[]{d, f});
            }
            totalCost += f * M;
        }
        boolean[][] added = new boolean[(int)N][(int)M];
        long[][] keys = new long[(int)N][(int)M];
        for (int i = 0; i < N; i++)
        {
            Arrays.fill(keys[i], Long.MAX_VALUE);
        }
        keys[0][0] = 0L;
        long bestCost = 0L;
        for (int i = 0; i < M * N; i++)
        {
            long[] output = getMin(keys, added);
            bestCost += output[0];
            long C = output[2];
            long S = output[1];
            added[(int)S][(int)C] = true;
            for (long[] other: adjp.get((int)C))
            {
                long P1 = other[0];
                if (!added[(int)S][(int)P1])
                {
                    if (keys[(int)S][(int)P1] > other[1])
                    {
                        keys[(int)S][(int)P1] = other[1];
                    }
                }
            }
            for (long[] other: adjt.get((int)S))
            {
                long P1 = other[0];
                if (!added[(int)P1][(int)C])
                {
                    if (keys[(int)P1][(int)C] > other[1])
                    {
                        keys[(int)P1][(int)C] = other[1];
                    }
                }
            }
        }
        System.out.println(totalCost - bestCost);
    }
}
