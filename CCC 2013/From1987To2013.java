import java.util.*;

public class From1987To2013 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String start = String.valueOf(Integer.parseInt(in.nextLine()) + 1);
        while (true){
            boolean good = true;
            ArrayList<String> uniq = new ArrayList<>();
            for (int i = 0; i < start.length();i++){
                if (uniq.contains(String.valueOf(start.charAt(i)))){
                    good = false;
                    break;
                } else {
                    uniq.add(String.valueOf(start.charAt(i)));
                }
            }
            if (good){
                System.out.println(start);
                break;
            }
            start = String.valueOf(Integer.parseInt(start) + 1);
        }
    }
}
