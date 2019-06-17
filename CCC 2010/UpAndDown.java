import java.util.*;

public class UpAndDown {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> byronSteps = new ArrayList<>();
        ArrayList<Integer> nikkySteps = new ArrayList<>();

        nikkySteps.add(Integer.parseInt(in.nextLine()));
        nikkySteps.add(Integer.parseInt(in.nextLine()));

        byronSteps.add(Integer.parseInt(in.nextLine()));
        byronSteps.add(Integer.parseInt(in.nextLine()));

        int steps = Integer.parseInt(in.nextLine());

        int byronDistance = (steps / (byronSteps.get(0) + byronSteps.get(1))) * (byronSteps.get(0) - byronSteps.get(1));
        int byronRemaining = steps % (byronSteps.get(0) + byronSteps.get(1));
        byronDistance = (byronRemaining > byronSteps.get(0))?
                byronDistance + byronSteps.get(0) - (byronRemaining - byronSteps.get(0)):
                byronDistance + byronRemaining;

        int nikkyDistance = (steps / (nikkySteps.get(0) + nikkySteps.get(1))) * (nikkySteps.get(0) - nikkySteps.get(1));
        int nikkyRemaining = steps % (nikkySteps.get(0) + nikkySteps.get(1));
        nikkyDistance = (nikkyRemaining > nikkySteps.get(0))?
                nikkyDistance + nikkySteps.get(0) - (nikkyRemaining - nikkySteps.get(0)):
                nikkyDistance + nikkyRemaining;

        if (nikkyDistance == byronDistance){
            System.out.println("Tied");
        } else {
            System.out.println(
                    (nikkyDistance > byronDistance) ? "Nikky" : "Byron"
            );
        }

    }
}