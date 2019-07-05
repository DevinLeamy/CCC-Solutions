import java.util.*;

public class Calendar {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("First Day: ");
        int firstDay = Integer.parseInt(in.nextLine()) - 1;
        System.out.println("Number of days: ");
        int numDays = Integer.parseInt(in.nextLine());

        String[] week = {"Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat"};
        String[][] days = new String[5][7];
        for (String[] row: days){
            Arrays.fill(row, " ");
        }

        int currentDate = 1;

        for (int i = 0; i < days.length; i++){
            for (int day = 0; day < days[i].length; day++){
                if (i == 0){
                    if (day >= (firstDay)){
                        days[i][day] = String.valueOf(currentDate) ;
                        currentDate++;
                    }
                } else {
                    days[i][day] = String.valueOf(currentDate);
                    currentDate++;
                }
                if (currentDate > numDays){
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(week));
        for (String[] row: days){
            System.out.println(Arrays.toString(row));
        }
    }
}
