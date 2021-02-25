import java.util.*;

public class ColdCompress {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        for (int i = 0; i < N; i++){
            StringBuilder output = new StringBuilder();
            String line = in.nextLine();
            String current = String.valueOf(line.charAt(0));
            int count = 0;
            for (int x = 0; x < line.length(); x++){
                String character = String.valueOf(line.charAt(x));
                if (character.equals(current)){
                    count++;
                    continue;
                }
                output.append(count);
                output.append(" ");
                output.append(current);
                output.append(" ");
                count = 1;
                current = character;
            }
            output.append(count);
            output.append(" ");
            output.append(current);
            System.out.println(output.toString());
        }
    }
}
