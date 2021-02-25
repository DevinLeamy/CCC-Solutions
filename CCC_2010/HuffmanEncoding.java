//Problem 2 . Completed
import java.util.*;

public class HuffmanEncoding {
    public static void main(String[] main){
        ArrayList<String> charaters = new ArrayList<>();
        ArrayList<String> values = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int counter = Integer.parseInt(in.nextLine());

        for (int i = 0; i < counter; i++){
            String[] characterValue = in.nextLine().split(" ");
            charaters.add(characterValue[0]);
            values.add(characterValue[1]);

        }
        String code = in.nextLine();
        String compare = "";
        String output = "";

        for (int i = 0; i < code.length() + 1; i++){
            if (values.contains(compare)){
                int index = values.indexOf(compare);
                output += charaters.get(index);
                compare = "";
            }
            try {
                compare += code.charAt(i);
            } catch (StringIndexOutOfBoundsException SIOOBE){
                break;
            }
        }
        System.out.println(output);
    }
}
