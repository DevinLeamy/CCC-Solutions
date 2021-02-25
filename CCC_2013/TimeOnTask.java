import java.util.*;

public class TimeOnTask {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int time = Integer.parseInt(in.nextLine());
        int numChores = Integer.parseInt(in.nextLine());
        ArrayList<Integer> chores = new ArrayList<>();

        for (int i = 0; i < numChores; i++){
            chores.add(Integer.parseInt(in.nextLine()));
        }
        int current = 0;
        int counter = 0;
        Collections.sort(chores);
        while (time >= 0){
            time -= chores.get(current);

            current++;
            counter++;
        }
        System.out.println(counter - 1);
    }
}
