import java.util.*;

public class WhichAlien {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("How many antennas?");
        int antennas = Integer.parseInt(in.nextLine());
        System.out.println("How many eyes?");
        int eyes = Integer.parseInt(in.nextLine());

        if (antennas >= 3 && eyes <= 4){
            System.out.println("TroyMartian");
        }
        if (antennas <= 6 && eyes >= 2){
            System.out.println("VladSaturnian");
        }
        if (antennas <= 2 && eyes <= 3){
            System.out.println("GraemeMercurian");
        }

    }
}
