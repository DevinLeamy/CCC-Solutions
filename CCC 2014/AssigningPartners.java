import java.util.*;

public class AssigningPartners {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int numPeople = Integer.parseInt(in.nextLine());

        StringTokenizer firstLine = new StringTokenizer(in.nextLine());
        StringTokenizer secondLine = new StringTokenizer(in.nextLine());

        String print = "good";

        ArrayList<String> pairs = new ArrayList<>();

        while (firstLine.hasMoreTokens()){
            String firstPerson = firstLine.nextToken();
            String secondPerson = secondLine.nextToken();
            if (firstPerson.equals(secondPerson)){ print = "bad"; }
            List<String> sortMe = new ArrayList<>();
            sortMe.add(firstPerson);
            sortMe.add(secondPerson);

            Collections.sort(sortMe);

            pairs.add(sortMe.get(0) + " " + sortMe.get(1));
        }

        Set<String> setPairs = new HashSet<>();

        setPairs.addAll(pairs);

        if (setPairs.size() != (numPeople / 2)){
            print = "bad";
        }
        System.out.println(print);




    }
}
