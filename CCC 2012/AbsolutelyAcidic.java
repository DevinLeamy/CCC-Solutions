import java.util.*;

public class AbsolutelyAcidic {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> readings = new ArrayList<>();
        ArrayList<Integer> largest = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();
        Set<Integer> unique = new HashSet<>();
        HashMap<Integer, Integer> valuesAndFrequency = new HashMap<>();
        int sensors = Integer.parseInt(in.nextLine());

        for (int i = 0; i < sensors; i++) {
            readings.add(Integer.parseInt(in.nextLine()));
        }
        unique.addAll(readings);
        for (int x : unique) {
            valuesAndFrequency.put(x, Collections.frequency(readings, x)); }

        ArrayList<Integer> values = new ArrayList<>(valuesAndFrequency.values());
        Collections.sort(values);

        for (int key: valuesAndFrequency.keySet()){
            if (valuesAndFrequency.get(key).equals(values.get(values.size()-1))){
                largest.add(key);
            }
            try {
                if (valuesAndFrequency.get(key).equals(values.get(values.size()-2))){
                    second.add(key);
                }
            } catch (IndexOutOfBoundsException IOOBE){
                continue;
            }
        }
        int gap = 0;
        Collections.sort(largest);
        Collections.sort(second);

        if (largest.size() > 1){
            System.out.println(largest.get(largest.size() - 1) - largest.get(0));
        } else{
            for (int i: second){
                gap = (gap < Math.abs(largest.get(0) - i))? Math.abs(largest.get(0) - i): gap;
            }System.out.println(gap);
        }
    }
}
