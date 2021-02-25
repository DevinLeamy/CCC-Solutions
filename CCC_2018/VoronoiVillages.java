import java.math.BigDecimal;
import java.util.*;
import java.io.*;

public class VoronoiVillages {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        double[] V = new double[N];
        for (int i = 0; i < N; i++){
            V[i] = Double.parseDouble(in.readLine());
        }
        Arrays.sort(V);
        double currentMin = Double.MAX_VALUE;
        for (int i = 0; i < N; i++){
            try {
                double left = (V[i] - V[i - 1])/2;
                double right = (V[i + 1] - V[i])/2;
                double size = right + left;
                if (size < currentMin){
                    currentMin = size;
                }
            } catch (ArrayIndexOutOfBoundsException aioobe){ }
        }
        String remainder = "";
        BigDecimal output = new BigDecimal(currentMin);
        if (output.remainder(new BigDecimal(1)).equals( new BigDecimal(0))){
            remainder = ".0";
        }
        System.out.println(output.toString() + remainder);
    }
}
