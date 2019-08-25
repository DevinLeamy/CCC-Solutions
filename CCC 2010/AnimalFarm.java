import java.util.*;
import java.io.*;

public class AnimalFarm {
    private static int getMin(boolean[] added, ArrayList<String> allCorners, ArrayList< ArrayList<int[] > > pens)
    {
        int min = 5001;
        int FP = -1;
        int[] indexandpsofe = new int[4];
        for (int i = 0; i < added.length; i++)
        {
            if (added[i]) {
                if (i == added.length - 1) {

                    for (int z = 0; z < pens.size(); z++)
                    {
                        if (!added[z]) {
                            ArrayList<int[]> zedges = pens.get(z);
                            for (int w = 0; w < zedges.size(); w++)
                            {
                                int[] zedge = zedges.get(w);
                                int[] zcorners = {zedge[0], zedge[1]};
                                if (allCorners.contains(Arrays.toString(zcorners)))
                                {
                                    if (min > (zedge[2]))
                                    {
                                        min = zedge[2];
                                        FP = z;
                                        indexandpsofe[0] = -1;
                                        indexandpsofe[1] = z;
                                        indexandpsofe[2] = -1;
                                        indexandpsofe[3] = w;
                                    }
                                }
                            }
                        }
                    }

                } else
                {
                    ArrayList<int[]> edges = pens.get(i);
                    for (int j = 0; j < edges.size(); j++)
                    {
                        int[] edge = edges.get(j);
                        int[] corners = {edge[0], edge[1]};
                        if (allCorners.contains(Arrays.toString(corners)))
                        {
                            if (min > edge[2] && !added[added.length - 1])
                            {
                                min = edge[2];
                                FP = i;
                                indexandpsofe[1] = i;
                                indexandpsofe[3] = j;
                                indexandpsofe[0] = -1;
                                indexandpsofe[2] = -1;

                            }
                        } else
                        {
                            for (int z = 0; z < pens.size(); z++)
                            {
                                if (!added[z])
                                {
                                    ArrayList<int[]> zedges = pens.get(z);
                                    for (int w = 0; w < zedges.size(); w++)
                                    {
                                        int[] zedge = zedges.get(w);
                                        if (edge[0] == zedge[0] && edge[1] == zedge[1])
                                        {
                                            if (min > zedge[2])
                                            {
                                                min = zedge[2];
                                                FP = z;
                                                indexandpsofe[0] = w;
                                                indexandpsofe[1] = i;
                                                indexandpsofe[2] = z;
                                                indexandpsofe[3] = j;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        pens.get(indexandpsofe[1]).remove(indexandpsofe[3]);
        try {
            pens.get(indexandpsofe[2]).remove(indexandpsofe[0]);
        } catch (IndexOutOfBoundsException aioobe)
        {
            added[added.length - 1] = true;
        }
        added[FP] = true;
        return min;
    }
    private static boolean done(boolean[] check)
    {
        for (int i = 0; i < check.length; i++)
        {
            if (!check[i])
            {
                if (i != check.length - 1)
                {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(in.readLine());
        ArrayList< ArrayList<int[]> > pens = new ArrayList<>();
        ArrayList<String> allCorners = new ArrayList<>();
        for (int i = 0; i < M; i++)
        {
            ArrayList<int[]> edges = new ArrayList<>();
            StringTokenizer line = new StringTokenizer(in.readLine());
            int E = Integer.parseInt(line.nextToken());
            int[] corners = new int[E];
            for (int j = 0; j < E; j++)
            {
                corners[j] = Integer.parseInt(line.nextToken());
            }
            for (int j = 0; j < E; j++)
            {
                int[] edge = new int[3];
                edge[0] = Integer.max(corners[j], corners[(j + 1) % E]);
                edge[1] = Integer.min(corners[j], corners[(j + 1) % E]);
                int[] corner = {edge[0], edge[1]};
                if (allCorners.contains(Arrays.toString(corner)))
                {
                    allCorners.remove(Arrays.toString(corner));
                } else {
                    allCorners.add(Arrays.toString(corner));
                }
                edge[2] = Integer.parseInt(line.nextToken());
                edges.add(edge);
            }
            pens.add(edges);
        }
        boolean[] added = new boolean[M+1];
        added[0] = true;
        int cost = 0;

        while (!done(added))
        {
            cost += getMin(added, allCorners, pens);
        }
        System.out.println(cost);
    }
}
