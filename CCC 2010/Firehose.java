//Problem 3

import java. util.*;


public class Firehose {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int counter = Integer.parseInt(in.nextLine());
        ArrayList<Integer> addies = new ArrayList<>();
        for (int i = 0; i < counter;i++){
            int addy = Integer.parseInt(in.nextLine());
            addies.add(addy);
        }
        int fireHydrants = Integer.parseInt(in.nextLine());
        int circumference = 1000000;
        Set<Integer> sToB = new HashSet<>();

        sToB.addAll(addies);

        ArrayList<Integer> sorted = new ArrayList<>();

        sorted.addAll(sToB);


        ArrayList<Integer> differences = new ArrayList<>();

        int jump = (addies.size() % 2 == 1)? addies.size() / fireHydrants: addies.size() / fireHydrants;

        for (int i = 0; i < sorted.size(); i++){
            if (i == 0) {
                differences.add(sorted.get(i + jump) - sorted.get(sorted.get(i)));
                continue;
            }
            try {
                differences.add(sorted.get(sorted.size() % i + jump) - sorted.get(sorted.size() % i));
            } catch (ArrayIndexOutOfBoundsException AIOOBE) {
                break;
            }
        }

        sorted.addAll(sToB);

        Set<Integer> sort = new HashSet<>();

        sort.addAll(differences);

        ArrayList<Integer> sortedDifferences = new ArrayList<>();

        sortedDifferences.addAll(sort);

        System.out.println(sortedDifferences.get(sortedDifferences.size() - 1) / fireHydrants);
    }
}
