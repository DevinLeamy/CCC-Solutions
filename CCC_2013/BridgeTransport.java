import java.util.*;

public class BridgeTransport {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int maxWeight = Integer.parseInt(in.nextLine());
        int numCars = Integer.parseInt(in.nextLine());
        ArrayList<Integer> cars = new ArrayList<>();
        for (int i = 0; i < numCars; i++){
            cars.add(Integer.parseInt(in.nextLine()));
        }
        int totalWeight = 0;

        int firstCar = 0;

        int totalCars = 0;

        while (totalWeight <= maxWeight){
            boolean greater = false;
            if (totalCars == 0) {
                for (int i = 0; i < 4; i++) {
                    if (totalWeight + cars.get(i) <= maxWeight) {
                        totalWeight += cars.get(i);
                        totalCars += 1;
                    } else {
                        greater = true;
                        break;
                    }
                }
            }
            else {
                if (cars.size() == firstCar + 4){break;}
                if (totalWeight - cars.get(firstCar) + cars.get(firstCar + 4) <= maxWeight) {
                    totalWeight -= cars.get(firstCar);
                    totalWeight += cars.get(firstCar + 4);
                    totalCars++;
                    firstCar++;
                }  else {
                    break;
                }

            }
            if (greater) {break;}
        }
        System.out.println(totalCars);
    }
}
