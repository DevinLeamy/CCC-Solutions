import java.util.*;

public class MultipleChoice {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int numQuestions = Integer.parseInt(in.nextLine());
        ArrayList<String> students = new ArrayList<>();
        ArrayList<String> correct = new ArrayList<>();
        int counter = 0;

        for (int i = 0; i < numQuestions; i++){
            students.add(in.nextLine());
        }
        for (int i = 0; i < numQuestions; i++){
            correct.add(in.nextLine());
        }
        for (int i = 0; i < numQuestions; i++){
            if (students.get(i).equals(correct.get(i))){
                counter++;
            }
        }
        System.out.println(counter);
    }
}
