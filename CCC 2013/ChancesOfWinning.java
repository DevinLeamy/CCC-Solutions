import java.io.*;
import java.util.*;

public class ChancesOfWinning {
    static class FastReader{
        BufferedReader br;
        FastReader()
        {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String nextLine(){
            String str = "";
            try{
                str = br.readLine();
            } catch (IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }
    private static int count = 0;
    private static boolean check(int[] teams, int T){
        int score = teams[T];
        for (int i = 0; i < 4; i++){
            if (teams[i] >= score && i != T){
                return false;
            }
        }
        return true;
    }
    private static void calculatePossibleScore(ArrayList<String> gamesToPlay, int[] teams, int T){
        if (gamesToPlay.size() == 0){
            if (check(teams, T)){
                count++;
            }
            return;
        }
        String[] game = gamesToPlay.get(0).split(" ");
        gamesToPlay.remove(0);
        int team1 = Integer.parseInt(game[0]);
        int team2 = Integer.parseInt(game[1]);
        int[][] addTo = {{0, 3}, {3, 0}, {1, 1}};
        int[] clone = teams.clone();
        ArrayList<String> hold = new ArrayList<>(gamesToPlay);
        for (int i = 0; i < 3; i++){
            gamesToPlay = new ArrayList<>();
            gamesToPlay.addAll(hold);
            teams = clone.clone();
            int[] add = addTo[i];
            teams[team1] += add[0];
            teams[team2] += add[1];
            calculatePossibleScore(gamesToPlay, teams, T);
        }
    }
    public static void main(String[] args){
        FastReader in = new FastReader();
        int T = Integer.parseInt(in.nextLine()) - 1;
        int G = Integer.parseInt(in.nextLine());
        int[] team = new int[4];
        ArrayList<String> games = new ArrayList<>();
        games.add(0 + " " + 1);
        games.add(0 + " " + 2);
        games.add(0 + " " + 3);
        games.add(1 + " " + 2);
        games.add(1 + " " + 3);
        games.add(2 + " " + 3);
        for (int i = 0; i < G; i++){
            StringTokenizer line = new StringTokenizer(in.nextLine());
            int team1 = Integer.parseInt(line.nextToken()) - 1;
            int team2 = Integer.parseInt(line.nextToken()) - 1;
            int score1 = Integer.parseInt(line.nextToken());
            int score2 = Integer.parseInt(line.nextToken());
            if (team1 < team2){
                games.remove(team1 + " " + team2);
            } else {
                games.remove(team2 + " " + team1);
            }
            if (score1 == score2){
                team[team1] += 1;
                team[team2] += 1;
            } else {
                team[team1] += (score1 > score2)? 3: 0;
                team[team2] += (score2 > score1)? 3: 0;
            }
        }
        calculatePossibleScore(games, team, T);
        System.out.println(count);
    }
}
