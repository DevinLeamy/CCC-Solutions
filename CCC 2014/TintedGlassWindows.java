import java.io.*;
import java.util.*;



public class TintedGlassWindows {
    private static class Coord{
        long x, y1, y2, tint;
        Coord(long x, long y1, long y2, long tint)
        {
            this.x = x;
            this.y1 = y1;
            this.y2 = y2;
            this.tint = tint;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        ArrayList<Long> yValues = new ArrayList<>();
        ArrayList<Coord> events = new ArrayList<>();
        StringTokenizer line;
        long x1, x2, y1, y2, tint;
        long T = Long.parseLong(in.readLine());
        for (int i = 0; i < N; i++)
        {
            line = new StringTokenizer(in.readLine());
            x1 = Long.parseLong(line.nextToken());
            y1 = Long.parseLong(line.nextToken());
            x2 = Long.parseLong(line.nextToken());
            y2 = Long.parseLong(line.nextToken());
            tint = Long.parseLong(line.nextToken());
            events.add(new Coord(x1, y1, y2, tint));
            events.add(new Coord(x2, y1, y2, -tint));
            yValues.add(y1);
            yValues.add(y2);
        }
        yValues = new ArrayList<>(new HashSet<>(yValues));
        Collections.sort(yValues);
        Collections.sort(events, (a, b) -> Long.compare(a.x, b.x));
        long[] costs = new long[yValues.size()];
        long output = 0;

        HashMap<Long, Integer> compressed = new HashMap<>();
        for (int i = 0; i < yValues.size(); i++)
        {
            compressed.put(yValues.get(i), i);
        }
        for (int i = 0; i < events.size(); i++)
        {
            for (int j = compressed.get(events.get(i).y1); j < compressed.get(events.get(i).y2); j++)
            {
                costs[j] += events.get(i).tint;
            }
            for (int j = 0; j < yValues.size(); j++)
            {
                if (costs[j] >= T)
                {
                    output += (events.get(i+1).x - events.get(i).x) * (yValues.get(j+1) - yValues.get(j));
                }
            }
        }
        System.out.println(output);
    }
}