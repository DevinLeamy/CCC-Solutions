import java.util.*;

public class WaitTime {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int numMessages = Integer.parseInt(in.nextLine());
        String[] messages = new String[numMessages];
        for (int i = 0; i < numMessages; i++){
            messages[i] = in.nextLine(); }

        ArrayList<String> waitTime = new ArrayList<>();
        int currentTime = 0;
        HashMap<Integer, Integer> queue = new HashMap<>();

        for (int i = 0; i < numMessages; i++){
            String command = messages[i].split(" ")[0];
            int magnitude = Integer.parseInt(messages[i].split(" ")[1]);
            switch (command){
                case "W":
                    currentTime += (magnitude - 1);
                    break;
                case "R":
                    queue.put(magnitude, currentTime);
                    currentTime++;
                    break;
                case "S":
                    boolean found = false;
                    for (int key:queue.keySet()){
                        if (key == magnitude){
                            waitTime.add((key + " " + (currentTime - queue.get(key))));
                            queue.remove(key, queue.get(key));
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        waitTime.add(magnitude + " -9");
                        break;
                    }
                    currentTime++;
            }
        }
        if (queue.size() > 0){
            for (int key : queue.keySet()){
                waitTime.add(key + " " + -1);
            }
        }

        for (int i = 0; i < waitTime.size(); i++){
            for (int x = 0; x < waitTime.size(); x++){

                String[] one = waitTime.get(i).split(" ");
                String[] two = waitTime.get(x).split(" ");
                if (one[0].equals(two[0]) && !waitTime.get(i).equals(waitTime.get(x))){
                        waitTime.set(x, (one[0] + " " + (Integer.parseInt(one[1]) + Integer.parseInt(two[1]))));
                        waitTime.remove(waitTime.get(i));
                }
            }
        }
        Collections.sort(waitTime);
        ArrayList<String> printed = new ArrayList<>();
        for (String output:waitTime){
            if (!printed.contains(output)){
                System.out.println(output);
                printed.add(output);
            }
        }
    }
}
