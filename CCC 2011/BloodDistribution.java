import java.util.*;

public class BloodDistribution {
    public static int[] distributeBlood(
            int oBlood, int oUnits, int aBlood, int aUnits, int bBlood, int bUnits, int abBlood, int abUnits, int counter
    ){
        int[] bloods = {oUnits, oBlood, aUnits, aBlood, bUnits, bBlood, abUnits, abBlood};
        for (int i = 0; i < bloods.length; i+=2) {
            if (bloods[i] >= bloods[i + 1] && bloods[i] > 0 && bloods[i + 1] > 0) {
                counter += bloods[i + 1];
                bloods[i] -= bloods[i + 1];
                bloods[i + 1] = 0;
            } else if (bloods[i] < bloods[i + 1] && bloods[i] > 0 && bloods[i + 1] > 0) {
                counter += bloods[i];
                bloods[i + 1] -= bloods[i];
                bloods[i] = 0;
            }
        }
        if (bloods[0] > 0 && (bloods[3] > 0 || bloods[5] > 0 || bloods[7] > 0)){
            for (int count = 3; count  < 9; count += 2) {
                if (bloods[0] >= bloods[count]){
                    counter += bloods[count];
                    bloods[0] -= bloods[count];
                    bloods[count] = 0;
                } else {
                    counter += bloods[0];
                    bloods[count] -= bloods[0];
                    bloods[0] = 0;
                }
            }
        }
        if (bloods[7] > 0 && (bloods[0] > 0 || bloods[2] > 0 || bloods[4] > 0)){
            for (int count = 0; count < 6; count += 2) {
                if (bloods[count] >= bloods[7]){
                    counter += bloods[7];
                    bloods[count] -= bloods[7];
                    bloods[7] = 0;
                } else {
                    counter += bloods[count];
                    bloods[7] -= bloods[count];
                    bloods[count] = 0;
                }
            }
        }
        return new int[] {
                bloods[0], bloods[1],
                bloods[2], bloods[3],
                bloods[4], bloods[5],
                bloods[6], bloods[7],
                counter };
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        String[] units = in.nextLine().split(" ");
        int oNegativeUnits = Integer.parseInt(units[0]); int oPositiveUnits = Integer.parseInt(units[1]);

        int aNegativeUnits = Integer.parseInt(units[2]); int aPositiveUnits = Integer.parseInt(units[3]);

        int bNegativeUnits = Integer.parseInt(units[4]); int bPositiveUnits = Integer.parseInt(units[5]);

        int abNegativeUnits = Integer.parseInt(units[6]); int abPositiveUnits = Integer.parseInt(units[7]);

        String[] values = in.nextLine().split(" ");
        int oNegative = Integer.parseInt(values[0]); int oPositive = Integer.parseInt(values[1]);

        int aNegative = Integer.parseInt(values[2]); int aPositive = Integer.parseInt(values[3]);

        int bNegative = Integer.parseInt(values[4]); int bPositive = Integer.parseInt(values[5]);

        int abNegative = Integer.parseInt(values[6]); int abPositive = Integer.parseInt(values[7]);

        int counter = 0;

        int[] negatives = distributeBlood(
                oNegative, oNegativeUnits,
                aNegative, aNegativeUnits,
                bNegative, bNegativeUnits,
                abNegative, abNegativeUnits,
                counter
        );

        int[] results = distributeBlood(
                oPositive, oPositiveUnits + negatives[0],
                aPositive, aPositiveUnits + negatives[2],
                bPositive, bPositiveUnits + negatives[4],
                abPositive, abPositiveUnits + negatives[6],
                negatives[8]
        );
        System.out.println(results[8]);
    }
}
