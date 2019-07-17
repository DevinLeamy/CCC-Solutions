import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Firehose{
    private static void bubbleSort(int[] houses){
        for (int i = 0; i < houses.length - 1; i++){
            for (int j = 0; j < houses.length - i - 1; j++){
                if (houses[j] > houses[j+1]){
                    int temp = houses[j];
                    houses[j] = houses[j+1];
                    houses[j+1] = temp;
                }
            }
        }
    }
    private static void orderHouses(int[] houses){
        int firstHouse = houses[0];
        if (firstHouse != 0){
            for (int i = 0; i < houses.length; i++){
                houses[i] = houses[i] - firstHouse;
            }
        }
    }

    private static int findMin(int diameter, int[] houses, int nWater){
        int i;
        int counter = 0;
        int numHouses= houses.length;
        while (counter != nWater){
            counter = 0;
            i = 0;
            while (i <= (numHouses - 1)){
                try {
                    int lowerBound = houses[i];
                    int higherBound = (houses[i] + diameter);
                    i = check(houses, lowerBound, higherBound, i);
                    counter++;
                } catch (ArrayIndexOutOfBoundsException e){break;}

            }
            if (counter > nWater) {diameter++;}
            else{diameter--;}
        }
        while (counter == nWater){
            diameter--;
            counter = 0;
            i = 0;
            while (i <= (numHouses - 1)){
                try {
                    int lowerBound = houses[i];
                    int higherBound = (houses[i] + diameter);
                    i = check(houses, lowerBound, higherBound, i);
                    counter++;
                } catch (ArrayIndexOutOfBoundsException aioobe){break;}
            }
        }
        return (1 + diameter);
    }
    private static int check(int[] houses, int lowerBound, int higherBound, int i){
        for (int x = i; x < houses.length; x++){
            int house = houses[x];
            if (!(lowerBound <= house && house <= higherBound)){
                return x;
            }
        }
        return -1;
    }



   /*
   Starting from the first house check what houses are covered by the current diameter, then go to the
   next house that is not covered and do the same with a given diameter. If the number of hoses required to
   cover all the houses is greater then the number of hoses, the hose size must be increased. Otherwise,
   decrease the size of the hose in tell it doesn't work with the given number of hoses. Print the radius of the
   working hose.

    */



    private static int CIRCUMFERENCE = 1000000;
    static class FastReader{
        BufferedReader br;
        public FastReader(){
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
    public static void main(String[] args){
        FastReader in = new FastReader();
        int nHouses = Integer.parseInt(in.nextLine());
        int[] houses = new int[nHouses];
        for (int i = 0; i < nHouses; i++){
            houses[i] = Integer.parseInt(in.nextLine());
        }
        int nWater = Integer.parseInt(in.nextLine());
        if (nWater >= nHouses){
            System.out.println(0);
        } else {
            bubbleSort(houses);
            orderHouses(houses);
            int diameter = CIRCUMFERENCE / nWater;
            int min = findMin(diameter, houses, nWater);
            System.out.println((min + 1) / 2);
        }
    }
}
