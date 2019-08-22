import java.io.*;

public class QuadrantSelection {
    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(in.readLine());
        int Y = Integer.parseInt(in.readLine());
        if (X < 0 && Y < 0)
        {
            System.out.println(3);
        } else if (X < 0)
        {
            System.out.println(2);
        } else if (Y < 0)
        {
            System.out.println(4);
        } else {
            System.out.println(1);
        }
    }
}
