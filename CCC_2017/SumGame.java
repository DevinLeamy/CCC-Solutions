import java.io.*;
import java.util.*;

public class SumGame {
    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        StringTokenizer aG = new StringTokenizer(in.readLine());
        StringTokenizer bG = new StringTokenizer(in.readLine());
        int a = 0, b = 0;
        int K = 0;
        for (int i = 0; i < N; i++)
        {
            a += Integer.parseInt(aG.nextToken());
            b += Integer.parseInt(bG.nextToken());
            if (a == b)
            {
                K = (i + 1);
            }
        }
        System.out.println(K);
    }
}
