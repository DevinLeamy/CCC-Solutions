import java.util.*;

public class Rovarspraket {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String original = in.nextLine();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String vowels = "aeiou";
        String print = "";
        for (int i = 0; i < original.length(); i++){
            if (vowels.contains(String.valueOf(original.charAt(i)))){
                print += String.valueOf(original.charAt(i));
            } else{
                print += String.valueOf(original.charAt(i));
                int hold = i;
                int below = 100;
                int above = 100;
                int differenceA = 0;
                int differenceB = 0;
                int indexLet = alphabet.indexOf(String.valueOf(original.charAt(i)));
                while (true){
                    indexLet--;
                    differenceB++;
                    try {
                        if (vowels.contains(String.valueOf(alphabet.charAt(indexLet)))) {
                            below = indexLet;
                            break;
                        }
                    } catch (StringIndexOutOfBoundsException SIOOBE){
                        break;
                    }
                }

                i = hold;
                indexLet = alphabet.indexOf(String.valueOf(original.charAt(i)));
                while (true){
                    indexLet++;
                    differenceA++;
                    try {
                        if (vowels.contains(String.valueOf(alphabet.charAt(indexLet)))) {
                            above = indexLet;
                            break;
                        }
                    } catch (StringIndexOutOfBoundsException SIOOBE){
                        break;
                    }
                }
                i = hold;
                indexLet = alphabet.indexOf(String.valueOf(original.charAt(i)));
                if (above == 100 || below == 100){
                    print += (above < below)? String.valueOf(alphabet.charAt(above)):String.valueOf(alphabet.charAt(below));
                } else {
                    if (differenceB <= differenceA) {
                        print += String.valueOf(alphabet.charAt(below));
                    } else {
                        print += String.valueOf(alphabet.charAt(above));
                    }
                }
                if (String.valueOf(original.charAt(i)).equals("z")){
                    print += "z";
                } else{
                    int index = alphabet.indexOf(String.valueOf(original.charAt(i)));
                    while (true){
                        index++;
                        if (!vowels.contains(String.valueOf(alphabet.charAt(index)))){
                            break;
                        }
                    }
                    print += String.valueOf(alphabet.charAt(index));
                }


            }
        }
        System.out.println(print);

    }
}
