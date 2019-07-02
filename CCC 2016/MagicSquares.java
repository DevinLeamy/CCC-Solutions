import java.util.*;

public class MagicSquares {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        boolean magic = true;
        String[] lineOne = in.nextLine().split(" ");
        String[] lineTwo = in.nextLine().split(" ");
        String[] lineThree = in.nextLine().split(" ");
        String[] lineFour = in.nextLine().split(" ");
        int total = Integer.parseInt(lineOne[0]) + Integer.parseInt(lineTwo[0]) +
                Integer.parseInt(lineThree[0]) + Integer.parseInt(lineFour[0]);
        String[][] lines = {lineOne, lineTwo, lineThree, lineFour};

        for (int i = 0; i < 4; i++){
            if ((Integer.parseInt(lineOne[i]) + Integer.parseInt(lineTwo[i]) +
                    Integer.parseInt(lineThree[i]) + Integer.parseInt(lineFour[i])) != total){
                magic = false;
                break;
            }
            int temp = 0;
            for (String num: lines[i]){
                temp += Integer.parseInt(num);
            }
            if (temp != total){
                magic = false;
                break;
            }

        }


        System.out.println(
                (magic)? "magic":"not magic"
        );

    }
}
