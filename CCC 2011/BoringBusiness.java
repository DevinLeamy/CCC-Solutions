import java.util.*;

public class BoringBusiness {
    public static String travel(String direction, String position, int magnitude, ArrayList<String> collect){
        int currentX = Integer.parseInt(position.split(" ")[0]);
        int currentY = Integer.parseInt(position.split(" ")[1]);

        boolean safe = true;
        switch (direction){
            case "l":
                for (int i = 0; i < magnitude; i++){
                    currentX -= 1;
                    if (collect.contains(currentX + " " + currentY)){
                        collect.add(currentX + " " + currentY);
                        safe = false;
                    } else {
                        collect.add(currentX + " " + currentY);
                    }
                }
                break;
            case "r":
                for (int i = 0; i < magnitude; i++){
                    currentX += 1;
                    if (collect.contains(currentX + " " + currentY)){
                        collect.add(currentX + " " + currentY);
                        safe = false;
                    } else {
                        collect.add(currentX + " " + currentY);
                    }
                }
                break;
            case "d":
                for (int i = 0; i < magnitude; i++){
                    currentY -= 1;
                    if (collect.contains(currentX + " " + currentY)){
                        collect.add(currentX + " " + currentY);
                        safe = false;
                    } else {
                        collect.add(currentX + " " + currentY);
                    }
                }
                break;
            case "u":
                for (int i = 0; i < magnitude; i++){
                    currentY += 1;
                    if (collect.contains(currentX + " " + currentY)){
                        collect.add(currentX + " " + currentY);
                        safe = false;
                    } else {
                        collect.add(currentX + " " + currentY);
                    }
                }
                break;
        }
        return (safe)? "safe": "DANGER";

    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ArrayList<String> travesed = new ArrayList<>();
        String start = "0 -1";
        travesed.add(start);
        travel("d", start, 2, travesed);
        travel("r", travesed.get(travesed.size() - 1), 3, travesed);
        travel("d", travesed.get(travesed.size() - 1), 2, travesed);
        travel("r", travesed.get(travesed.size() - 1), 2, travesed);
        travel("u", travesed.get(travesed.size() - 1), 2, travesed);
        travel("r", travesed.get(travesed.size() - 1), 2, travesed);
        travel("d", travesed.get(travesed.size() - 1), 4, travesed);
        travel("l", travesed.get(travesed.size() - 1), 8, travesed);
        travel("u", travesed.get(travesed.size() - 1), 2, travesed);

        String[] command = in.nextLine().split(" ");

        while (!command[0].equals("q")){
            String direction = command[0];
            int magnitude = Integer.parseInt(command[1]);

            String condition = travel(direction, travesed.get(travesed.size() - 1), magnitude, travesed);
            String[] end = travesed.get(travesed.size() -1).split(" ");
            String print = end[0] + " " + end[1] + " " + condition;
            System.out.println(print);
            if (condition.equals("DANGER")) {break; }
            command = in.nextLine().strip().split(" ");
        }
    }
}
