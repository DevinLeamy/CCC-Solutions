import java.util.*;

public class PiDay {
    public static int position(int pieces, int pos, int numPeople, int consumed, int counter, int[] people){
        if (pos == (numPeople)){
            if (consumed == pieces){
                counter += 1;
                return counter;
            } else{
                return counter;
            }
        }
        else if (consumed > pieces){
            return counter;
        } else {
            int max = ((pieces - consumed) / (numPeople - pos)) + 1;
            if (pos == 0){
                for (int i = 1; i < max ; i++) {
                    people[pos] = i;
                    counter = position(pieces, pos + 1, numPeople, consumed + i, counter, people);
                }
            } else {
                for (int i = people[pos - 1]; i < max; i++) {
                    people[pos] = i;
                    if (people[pos - 1] <= people[pos]) {
                        counter = position(pieces, pos + 1, numPeople, consumed + i, counter, people);
                    }
                }
            }
        }
        return counter;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int pieces = Integer.parseInt(in.nextLine());
        int numPeople = Integer.parseInt(in.nextLine());
        int[] people = new int[numPeople];
        Arrays.fill(people, pieces);
        if (pieces == numPeople) {
            System.out.println(1);
        } else if (numPeople == 1) {
            System.out.println(1);
        } else {
            System.out.println(position(pieces, 0, numPeople, 0, 0, people));
        }
    }
}
