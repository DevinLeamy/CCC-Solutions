import java.io.*;

public class OccupyParking {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        String[] T = in.readLine().split("");
        String[] Y = in.readLine().split("");
        int count = 0;
        for (int i = 0; i < N; i++){
            String ST = T[i];
            String SY = Y[i];
            if (ST.equals("C") && SY.equals("C")){
                count++;
            }
        }
        System.out.println(count);
    }
}
