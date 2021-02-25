import java.util.*;

public class BabblingBrooks {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int numStreams = Integer.parseInt(in.nextLine());
        ArrayList<Integer> streams = new ArrayList<>();
        for (int i = 1; i <= numStreams; i++){
            int flow = Integer.parseInt(in.nextLine());
            streams.add(flow);
        }
        int lineOne = Integer.parseInt(in.nextLine());
        while (lineOne != 77){
            int stream;
            switch (lineOne){
                case 88:
                    stream = Integer.parseInt(in.nextLine());
                    streams.set(stream, ((streams.get(stream - 1) + streams.get(stream))));
                    streams.remove(stream - 1);
                    break;
                case 99:
                    stream = Integer.parseInt(in.nextLine());
                    int percentage = Integer.parseInt(in.nextLine());
                    int rightStreamFlow = (streams.get(stream - 1) * (100 - percentage)) /100;
                    streams.set(stream - 1, ((streams.get(stream - 1) * percentage))/100);
                    streams.add(stream, rightStreamFlow);
                    break;
            }
            lineOne = Integer.parseInt(in.nextLine());
        }
        String output = "";
        for (int i: streams){
            output += (i + " ");
        }
        System.out.println(output.strip());
    }
}
