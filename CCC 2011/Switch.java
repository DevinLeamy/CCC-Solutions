//13/15 on the online grader because of efficiency 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;

public class Switch {
    static class FastReader{
        BufferedReader br;
        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }
    private static void turnOfLights(boolean[] lights){
        int counter = 0;
        int startI = 0;
        for (int i = 0; i < lights.length; i++){
            if (lights[i]){
                counter++;
            } else{
                if (counter >= 4){
                    for (int x = startI; x < i; x++){
                        lights[x] = false;
                    }
                }
                counter = 0;
                startI = i;
            }
        }
        if (counter >= 4){
            for (int x = startI; x < lights.length; x++){
                lights[x] = false;
            }
        }
    }
    private static boolean check(boolean[] lights){
        for (int i = 0; i < lights.length; i++){
            if (lights[i]){
                return false;
            }
        }
        return true;
    }
    private static boolean placeLight(int index, boolean[] set){
        try {
            if (set[index - 1]){
                return true;
            }
        } catch (ArrayIndexOutOfBoundsException e){ }
        try{
            if (set[index + 1]){
                return true;
            }
        } catch (ArrayIndexOutOfBoundsException e){ }
        return false;
    }
    private static boolean[] copy(boolean[] og){
        boolean[] output = new boolean[og.length];
        for (int i = 0; i < og.length; i++){
            output[i] = og[i];
        }
        return output;
    }
    public static void main(String[] args){
        FastReader in = new FastReader();
        int numLights = Integer.parseInt(in.nextLine());
        boolean[] lights = new boolean[numLights];
        for (int i = 0; i < numLights; i++){
            int light = Integer.parseInt(in.nextLine());
            if (light == 0){
                lights[i] = false;
            } else {
                lights[i] = true;
            }
        }
        ArrayList<boolean[]> queue = new ArrayList<>();
        queue.add(lights);
        int counter = 0;
        ArrayList<String> checked = new ArrayList<>();
        checked.add(Arrays.toString(lights));
        boolean[] newArray;
        while (true){
            ArrayList<boolean[]> next = new ArrayList<>();
            for (boolean[] set: queue) {
                if (check(set)){
                    System.out.println(counter);
                    System.exit(0);
                }
            }
            for (boolean[] set: queue){
                for (int i = 0; i < numLights; i++){
                    if (!set[i]) {
                        if (placeLight(i, set)) {
                            newArray = set.clone();
                            newArray[i] = true;
                            if (!checked.contains(Arrays.toString(newArray))) {
                                turnOfLights(newArray);
                                checked.add(Arrays.toString(newArray));
                                next.add(newArray.clone());
                            }
                            newArray[i] = false;
                        }
                    }
                }
            }
            counter++;
            queue = new ArrayList<>(next);
        }
    }
}
