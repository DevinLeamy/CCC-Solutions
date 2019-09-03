//Uses Kruskal's Minimum Spanning Tree Algorithm

import java.util.*;
import java.io.*;

public class MaximumStrategicSavingsV2 {
    static class DisjointSet
    {
        int[] depth, parent;
        int N;

        private DisjointSet(int N)
        {
            depth = new int[N];
            parent = new int[N];
            this.N = N;
            makeSet();
        }

        void makeSet()
        {
            for (int i = 0; i < N; i++)
            {
                parent[i] = i;
            }
        }

        int findSet(int x)
        {
            if (parent[x] != x)
            {
                parent[x] = findSet(parent[x]);
            }
            return parent[x];
        }

        void union(int x, int y)
        {
            int xRep = findSet(x), yRep = findSet(y);

            if (xRep == yRep)
            {
                return;
            }

            if (depth[xRep] < depth[yRep])
            {
                parent[xRep] = yRep;
            } else if (depth[yRep] < depth[xRep])
            {
                parent[yRep] = xRep;
            } else {
                parent[yRep] = xRep;
                depth[xRep] = depth[xRep] + 1;
            }
        }
    }
    private static int binarySearch(List<long[]> edges, long weight, int l, int h)
    {
        while (h >= l)
        {
            int  mid = (l + h) / 2;
            if (edges.get(mid)[0] == weight)
            {
                return mid;
            }
            if (edges.get(mid)[0] > weight)
            {
                h = mid-1;
                continue;
            }
            l = mid+1;
        }
        return -1;
    }
    private static void put(List<long[]> edges, long[] edge, TreeSet<Long> recordedWeights)
    {
        try{
            long num = recordedWeights.floor(edge[0]);
            int index = binarySearch(edges, num, 0, edges.size() - 1);
            edges.add(index + 1, edge);
        } catch (NullPointerException e)
        {
            edges.add(0, edge);
        }
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
        List<long[]> edges = new ArrayList<>();
        long totalCost = 0;
        long bestCost = 0;
        TreeSet<Long> recordedWeights = new TreeSet<>();
        for (int i = 0; i < P; i++)
        {
            line = new StringTokenizer(in.readLine());
            a = Long.parseLong(line.nextToken()) - 1;
            b = Long.parseLong(line.nextToken()) - 1;
            c = Long.parseLong(line.nextToken());
            if (a != b)
            {
                long[] edge = {c, Long.max(a, b), Long.min(a, b), 1};
                put(edges, edge, recordedWeights);
                recordedWeights.add(c);
            }
            totalCost += (c * N);
        }
        for (int i = 0; i < Q; i++)
        {
            line = new StringTokenizer(in.readLine());
            d = Long.parseLong(line.nextToken()) - 1;
            e = Long.parseLong(line.nextToken()) - 1;
            f = Long.parseLong(line.nextToken());
            if (d != e)
            {
                long[] edge = {f, Long.max(d, e), Long.min(d, e), 0};
                put(edges, edge, recordedWeights);
                recordedWeights.add(f);
            }
            totalCost += (f * M);
        }
        DisjointSet disjointSet = new DisjointSet((int) (N * M));
        while (edges.size() > 1)
        {
            long[] edge = edges.get(0);
            edges.remove(0);
            if (edge[3] == 0)
            {
                int planetOne = (int) edge[1];
                int planetTwo = (int) edge[2];
                for (int j = 0; j < M; j++)
                {
                    if (disjointSet.findSet(j + (planetOne * (int)M)) != disjointSet.findSet((j + (planetTwo * (int)M))))
                    {
                        bestCost += edge[0];
                        disjointSet.union(j + (planetOne * (int)M), j + (planetTwo * (int)M));
                    }
                }
            } else {
                int cityOne = (int) edge[1];
                int cityTwo = (int) edge[2];
                for (int j = 0; j < N; j++)
                {
                    if (disjointSet.findSet(cityOne) != disjointSet.findSet(cityTwo))
                    {
                        disjointSet.union(cityOne, cityTwo);
                        bestCost += edge[0];
                    }
                    cityOne += M;
                    cityTwo += M;
                }
            }
        }
        System.out.println(totalCost - bestCost);
    }
}
