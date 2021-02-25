import java.util.*;

public class Jerseys {
    private static boolean fits(String available, String desired) {
        if (available == null) {
            return false;
        }
        if (desired.equals("S")) {
            return true;
        }
        switch (desired) {
            case "L":
                return (available.equals("L"));
            case "M":
                return (available.equals("M") || available.equals("L"));
        }
        return true;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int numJerseys = Integer.parseInt(in.nextLine());
        int numAthletes = Integer.parseInt(in.nextLine());

        String[] jerseys = new String[numJerseys];
        for (int i = 0; i < numJerseys; i++){
            jerseys[i] = in.nextLine();
        }
        int counter = 0;
        for (int i = 0; i < numAthletes; i++){
            String[] request = in.nextLine().split(" ");
            String size = request[0];
            int numIndex = Integer.parseInt(request[1]) - 1;

            if (fits(jerseys[numIndex], size) && jerseys[numIndex] != null ){
                jerseys[numIndex] = null;
                counter++;
            }
        }
        System.out.println(counter);
    }
}
