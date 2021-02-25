import java.util.*;

public class ArrivalTime {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] time = in.nextLine().split(":");
        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);
        minute += (hour * 60);
        int duration = 0;
        int hold = minute;
        int distance = 0;
        while (distance < 120){
            if (minute >= 420 && minute < 600){
                minute += 2;
                duration += 2;
            } else if (minute >= 900 && minute < 1140){
                minute += 2;
                duration += 2;
            } else {
                minute++;
                duration++;
            }
            distance++;
        }
        int HH = (duration + hold) / 60;
        String printHours;
        HH = HH % 24;
        if (HH < 10){
            printHours = "0" + HH;
        } else {
            printHours = "" + HH;
        }
        int minutes = (duration + hold)%60;
        String printMin;
        if (minutes < 10){
            printMin = "0" + minutes;
        } else {
            printMin = "" + minutes;
        }
        System.out.println(printHours + ":" + printMin);






    }
}
