import java.util.*;

public class Unfriend {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] friends = {1, 1, 1, 1, 1, 1, 1};
        int numFriends = Integer.parseInt(in.nextLine());
        for (int i = 1; i < numFriends; i++){
            int friend = Integer.parseInt(in.nextLine());
            friends[friend] = friends[friend] * (1 + friends[i]);
        }
        System.out.println(friends[numFriends]);




    }
}
