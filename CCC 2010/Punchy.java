import java.util.*;

public class Punchy {
    public static void main(String[] args){
        ArrayList<String> values = new ArrayList<>();
        values.add("A"); values.add("0"); values.add("B"); values.add("0");
        Scanner in = new Scanner(System.in);
        while (true) {
            String[] aLine = in.nextLine().strip().split(" ");
            int index;
            if (aLine[0].equals("7")) {
                break;
            }
            switch (aLine[0]) {
                case "1":
                    index = values.indexOf(aLine[1]);
                    values.set(index + 1, Integer.toString(Integer.parseInt(aLine[2])));
                    break;
                case "2":
                    index = values.indexOf(aLine[1]);
                    System.out.println(values.get(index + 1));
                    break;
                case "3":
                    index = values.indexOf(aLine[1]);
                    values.set(index + 1,
                            Integer.toString(
                                    Integer.parseInt(values.get(index + 1)) + Integer.parseInt(values.get(values.indexOf(aLine[2]) + 1))));
                    break;
                case "4":
                    index = values.indexOf(aLine[1]);
                    values.set(index + 1,
                            Integer.toString(
                                    Integer.parseInt(values.get(index + 1)) * Integer.parseInt(values.get(values.indexOf(aLine[2]) + 1))));
                    break;
                case "5":
                    index = values.indexOf(aLine[1]);
                    values.set(index + 1,
                            Integer.toString(
                                    Integer.parseInt(values.get(index + 1)) - Integer.parseInt(values.get(values.indexOf(aLine[2]) + 1))));
                    break;
                case "6":
                    index = values.indexOf(aLine[1]);
                    values.set(index + 1,
                            Integer.toString(
                                    Integer.parseInt(values.get(index + 1)) / Integer.parseInt(values.get(values.indexOf(aLine[2]) + 1))));
                    break;
            }
        }
    }
}
