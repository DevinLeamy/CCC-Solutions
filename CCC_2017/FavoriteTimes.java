import java.io.*;

public class FavoriteTimes {
    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        long D = Integer.parseInt(in.readLine());
        int count = 0;
        count += ((D/720) * 31);
        D = D % 720;
        int[] current = {1, 2, 0, 0};
        for (int i = 0; i < D; i++)
        {
            current[3]+= 1;
            if (current[3] == 10)
            {
                current[3] = 0;
                current[2] += 1;
                if (current[2] == 6) {
                    current[2] = 0;
                    current[1]++;
                    if (current[1] == 10) {
                        current[1] = 0;
                        current[0] = 1;
                    } else if (current[1] == 3 && current[0] == 1) {
                        current[0] = 0;
                        current[1] = 1;
                    }
                }
            }
            if (current[0] == 0)
            {
                if (current[3] - current[2] == current[2] - current[1])
                {
                    count++;
                }
            } else if (current[3] - current[2] == current[2] - current[1] && current[2] - current[1] == current[1] - current[0]){
                count++;

            }
        }
        System.out.println(count);
    }
}
