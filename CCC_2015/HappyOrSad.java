import java.util.*;

public class HappyOrSad {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String characters = in.nextLine();

        int happy = 0;
        int sad = 0;

        for (int i = 0; i < characters.length(); i++){
            if (String.valueOf(characters.charAt(i)).equals(":")){
                try {
                    if (String.valueOf(characters.charAt(i + 1)).equals("-") &&
                            String.valueOf(characters.charAt(i + 2)).equals(")")){
                        happy++;
                    } else if (String.valueOf(characters.charAt(i + 1)).equals("-") &&
                            String.valueOf(characters.charAt(i + 2)).equals("(")){
                        sad++;
                    }
                } catch (StringIndexOutOfBoundsException SIOOBE){
                    break;
                }
            }
        }
        if (happy == 0 & sad == 0){
            System.out.println("none");
        } else if (happy == sad){
            System.out.println("unsure");
        } else {
            System.out.println((happy > sad)? "happy": "sad");
        }
    }
}
