import java.io.*;
import java.util.*;

public class TheGenevaConfection {
    static class FastReader{
        BufferedReader br;
        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String nextLine()
        {
            String str = "";
            try{
                str = br.readLine();
            } catch (IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }
    public static void main(String[] args){
        FastReader in = new FastReader();
        int T = Integer.parseInt(in.nextLine());
        for (int i = 0; i < T; i++){
            int N = Integer.parseInt(in.nextLine());
            int current = 1;
            ArrayList<Integer> branch = new ArrayList<>();
            branch.add(0);
            int currentL = 0;
            ArrayList<Integer> set = new ArrayList<>();
            for (int x = 0; x < N; x++){
                set.add(Integer.parseInt(in.nextLine()));
            }
            boolean good = true;
            Collections.reverse(set);
            for (int x = 0; x < N; x++){
                int cart = set.get(x);
                if (cart == current){
                    current++;
                } else{
                    if (branch.get(0) == current){
                        branch.remove(0);
                    } else{
                        if (branch.size() == 1){
                            currentL = cart;
                            branch.add(0, cart);
                        } else{
                            if (cart > currentL){
                                System.out.println("N");
                                good = false;
                                break;
                            }
                        }

                    }
                }
            }
            if (good){
                System.out.println("Y");
            }
        }
    }
}
