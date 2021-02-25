import java.util.*;

public class EnglishOrFrench {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numLines = Integer.parseInt(in.nextLine());
        ArrayList<String> lines = new ArrayList<>();
        for (int i = 0; i < numLines; i++) {
            lines.add(in.nextLine());
        }

        int countT = 0;
        int countS = 0;

        for (String line : lines) {
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == 'T' || line.charAt(i) == 't') {
                    countT += 1;
                } else if (line.charAt(i) == 'S' || line.charAt(i) == 's') {
                    countS += 1;
                }
            }
        }
        if (countS >= countT){
            System.out.println("French");
        } else {
            System.out.println("English");
        }
    }
}
