import java.io.*;
import java.util.*;

public class ExactlyElectric {
    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer start = new StringTokenizer(in.readLine());
        int X = Integer.parseInt(start.nextToken()); int Y = Integer.parseInt(start.nextToken());
        StringTokenizer end = new StringTokenizer(in.readLine());
        int XF = Integer.parseInt(end.nextToken()); int YF = Integer.parseInt(end.nextToken());
        int C = Integer.parseInt(in.readLine());
        C -= Integer.max(X, XF) - Integer.min(X, XF);
        C -= Integer.max(Y, YF) - Integer.min(Y, YF);
        if (C < 0)
        {
            System.out.println("N");
        } else {
            System.out.println((C % 2 == 0)? "Y": "N");
        }
    }
}
