import java.util.*;

public class ZeroThatOut {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int K = Integer.parseInt(in.nextLine());
        ArrayList<Integer> values = new ArrayList<>();
        while (K > 0){
            int num = Integer.parseInt(in.nextLine());
            if (num == 0){
                values.remove(values.size() - 1);
            } else {
                values.add(num);
            }
            K--;
        }
        int total = 0;
        for (int num: values){
            total += num;
        }
        System.out.println(total);
    }
}
