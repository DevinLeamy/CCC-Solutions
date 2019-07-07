//I Did Not Independently Come Up with the Idea of using a TreeSet

import java.util.*;

public class Gates {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int numGates = Integer.parseInt(in.nextLine());
        int numPlanes = Integer.parseInt(in.nextLine());
        TreeSet<Integer> docked = new TreeSet<>();
        int counter = 0;
        for (int i = 1; i <= numGates; i++){
            docked.add(i);
        }
        for (int i = 0; i < numPlanes; i++){
            int gate = Integer.parseInt(in.nextLine());
            if (docked.floor(gate) == null){
                break;
            }
            docked.remove(docked.floor(gate));
            counter++;
        }
        System.out.println(counter);
    }
}
