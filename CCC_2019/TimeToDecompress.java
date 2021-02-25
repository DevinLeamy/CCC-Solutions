import java.util.*;

public class TimeToDecompress {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        for (int i = 0; i < N; i++){
            StringTokenizer L = new StringTokenizer(in.nextLine());
            int C = Integer.parseInt(L.nextToken());
            String S = L.nextToken();
            StringBuilder output = new StringBuilder();
            for (int x = 0; x < C; x++){
                output.append(S);
            }
            System.out.println(output.toString());
        }
    }
}
