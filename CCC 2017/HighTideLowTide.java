import java.io.*;
import java.util.*;

public class HighTideLowTide {
    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[] finalOrder = new int[N];
        int[] order = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(order);
        int high = N/2 + (N % 2);
        int low = high - 1;
        for (int i = 0; i < N + 2; i += 2)
        {
            try {
                finalOrder[i] = order[low];
                finalOrder[i + 1] = order[high];
                low--;
                high++;
            } catch (ArrayIndexOutOfBoundsException aioobe)
            {
                break;
            }
        }
        StringBuilder output = new StringBuilder();
        for (int num: finalOrder)
        {
            output.append(num);
            output.append(" ");
        }
        System.out.println(output.toString());
    }
}
