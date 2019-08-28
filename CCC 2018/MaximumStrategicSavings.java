//Used Prim's algorithm. Passes 15/22 test cases

import java.io.*;
import java.util.*;

public class MaximumStrategicSavings {
    private static long[] findMin(boolean[][] added, long[][] keys)
    {
        long currentMin = Long.MAX_VALUE;
        int[] addit = {-1, -1};
        for (int i = 0; i < keys.length; i++)
        {
            for (int j = 0; j < keys[0].length; j++)
            {
                if (!added[i][j])
                {
                    if (currentMin > keys[i][j])
                    {
                        currentMin = keys[i][j];
                        addit[0] = i;
                        addit[1] = j;
                    }
                }
            }
        }
        return new long[] {currentMin, addit[0], addit[1]};
    }
    private static long solve(int N, int M, List<long[]>[] flights, List<long[]>[] portals)
    {
        boolean[][] added = new boolean[N][M];
        long totalCost = 0L;
        long[][] keys = new long[N][M];
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < M; j++)
            {
                keys[i][j] = Long.MAX_VALUE;
            }
        }
        keys[0][0] = 0;
        for (int i = 0; i < (N * M); i++)
        {
            long[] result = findMin(added, keys);
            totalCost += result[0];
            int P = (int) result[1];
            int C = (int) result[2];

            added[P][C] = true;
            for (long[] flight: flights[C])
            {
                long C2 = flight[0];
                long cost = flight[1];
                if (!added[P][(int)C2])
                {
                    keys[P][(int) C2] = (keys[P][(int) C2] > cost)? cost : keys[P][(int) C2];
                }
            }
            for (long[] portal: portals[P])
            {
                long P2 = portal[0];
                long cost = portal[1];
                if (!added[(int) P2][C])
                {
                    keys[(int) P2][C] = (keys[(int) P2][C] > cost) ? cost : keys[(int) P2][C];
                }
            }
        }
        return totalCost;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer lineOne = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(lineOne.nextToken());
        int M = Integer.parseInt(lineOne.nextToken());
        int P = Integer.parseInt(lineOne.nextToken());
        int Q = Integer.parseInt(lineOne.nextToken());
        List<long[]>[] flights = new ArrayList[M];
        List<long[]>[] portals = new ArrayList[N];
        Arrays.setAll(flights, ArrayList::new);
        Arrays.setAll(portals, ArrayList::new);

        HashMap<String, Long> planes = new HashMap<>();
        HashMap<String, Long> teleporters = new HashMap<>();
        long totalCost = 0L;

        //Flights travel between cities on the same planet
        for (int i = 0; i < P; i++)
        {
            long[] flight = Arrays.stream(in.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            if (flight[0] != flight[1])
            {
                String pare = Long.max(flight[0], flight[1]) + " " + Long.min(flight[0], flight[1]);
                if (planes.containsKey(pare))
                {
                    if (planes.get(pare) > flight[2])
                    {
                        planes.replace(pare, flight[2]);
                    }
                } else {
                    planes.put(pare, flight[2]);
                }
            }
            totalCost += (flight[2] * N);
        }
        for (String key: planes.keySet())
        {
            String[] split = key.split(" ");
            int C1 = Integer.parseInt(split[0]) - 1;
            int C2 = Integer.parseInt(split[1]) - 1;
            long cost = planes.get(key);
            flights[C1].add(new long[] {C2, cost});
            flights[C2].add(new long[] {C1, cost});
        }

        //Portal travel between the same cities on different planets
        for (int i = 0; i < Q; i++)
        {
            long[] portal = Arrays.stream(in.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            if (portal[0] != portal[1])
            {
                String pare = Long.max(portal[0], portal[1]) + " " + Long.min(portal[0], portal[1]);
                if (teleporters.containsKey(pare))
                {
                    if (teleporters.get(pare) > portal[2])
                    {
                        teleporters.replace(pare, portal[2]);
                    }
                } else {
                    teleporters.put(pare, portal[2]);
                }
            }
            totalCost += (portal[2] * M);
        }
        for (String key: teleporters.keySet())
        {
            String[] split = key.split(" ");
            int P1 = Integer.parseInt(split[0]) - 1;
            int P2 = Integer.parseInt(split[1]) - 1;
            long cost = teleporters.get(key);
            portals[P1].add(new long[] {P2, cost});
            portals[P2].add(new long[] {P1, cost});
        }

        long mostEffective = solve(N, M, flights, portals);
        System.out.print((totalCost - mostEffective));
    }
}