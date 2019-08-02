import java.io.*;

public class TelemarketerOrNot {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N1 = Integer.parseInt(in.readLine());
        boolean ignore = false;
        if (N1 == 8 || N1 == 9){
            int N2 = Integer.parseInt(in.readLine());
            int N3 = Integer.parseInt(in.readLine());
            if (N2 == N3){
                int N4 = Integer.parseInt(in.readLine());
                if (N4 == 9 || N4 == 8){
                    System.out.println("ignore");
                    ignore = true;
                }
            }
        }
        if (!ignore){
            System.out.println("answer");
        }
    }
}
