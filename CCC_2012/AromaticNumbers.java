import java.util.*;

public class AromaticNumbers {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        HashMap<String, Integer> roman = new HashMap<>();
        roman.put("I", 1); roman.put("V", 5); roman.put("X", 10);
        roman.put("L", 50); roman.put("C", 100); roman.put("D", 500);
        roman.put("M", 1000);

        String aromatic = in.nextLine();

        int romanValue = roman.get(String.valueOf(aromatic.charAt(1)));
        int total = 0;
        int current = 0;
        while (true) {
            try {
                if (roman.get(String.valueOf(aromatic.charAt(current + 3))) > romanValue) {
                    total -= Integer.parseInt(String.valueOf(aromatic.charAt(current))) * roman.get(String.valueOf(aromatic.charAt(current + 1)));

                } else {
                    total += Integer.parseInt(String.valueOf(aromatic.charAt(current))) * roman.get(String.valueOf(aromatic.charAt(current + 1)));
                }
            } catch (StringIndexOutOfBoundsException SIOOBE){
                total += Integer.parseInt(String.valueOf(aromatic.charAt(current))) * roman.get(String.valueOf(aromatic.charAt(current + 1)));
                break;
            }
            romanValue = roman.get(String.valueOf(aromatic.charAt(current + 3)));
            current += 2;
        }
        System.out.println(total);
    }
}
