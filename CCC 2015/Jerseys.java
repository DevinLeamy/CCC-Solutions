//Got 12/15 on the Online Grade due to inefficency 

import java.util.*;

public class Jerseys {
    private static boolean smaller(String shirtIn, String next){
        if (next.equals("S")){
            return true;
        }
        switch (shirtIn){
            case "L":
                return (next.equals("M"));
        }
        return false;
    }
    private static boolean fits(String available, String desired) {
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
            HashMap<Integer, String> record = new HashMap<>();

            String[] sizes = new String[numJerseys];
            ArrayList<String> requests = new ArrayList<>();
            ArrayList<Integer> checked = new ArrayList<>();
            for (int i = 0; i < numJerseys; i++) {
                sizes[i] = in.nextLine();
            }
            for (int i = 0; i < numAthletes; i++) {
                String[] request = in.nextLine().split(" ");
                int num = Integer.parseInt(request[1]);
                String size = request[0];
                if (record.keySet().contains(num)){
                    if (smaller(record.get(num), size)){
                        record.replace(num, record.get(num), size);
                    }
                } else{
                    record.put(num, size);
                }
            }
            for (int key:record.keySet()){
                requests.add(record.get(key) + " " + key);
            }
            int satisfied = 0;
            for (int i = 0; i < requests.size(); i++) {
                int num = Integer.parseInt(requests.get(i).split(" ")[1]);
                String size = requests.get(i).split(" ")[0];
                try {
                    String shirtSize = sizes[num - 1];
                    if (fits(shirtSize, size) && !checked.contains(num - 1)) {
                        satisfied++;
                        checked.add(num - 1);
                    }
                } catch (ArrayIndexOutOfBoundsException aioobe) {
                    aioobe.printStackTrace();
                }
            }
            System.out.println(satisfied);
    }
}
