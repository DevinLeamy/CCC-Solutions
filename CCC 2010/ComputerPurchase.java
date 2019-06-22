//Problem 1 . Completed (Refactor??)

//My Name chef

import java.util.*;

public class ComputerPurchase {


    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        int counter = Integer.parseInt(in.nextLine());

        if (counter == 0){
            boolean doNothing = true;
        }
        else {
            ArrayList<String> computers = new ArrayList<>();


            for (int i = 0; i < counter; i++) {
                String[] computerDetails = in.nextLine().strip().split(" ");
                int R = Integer.parseInt(computerDetails[1]);
                int S = Integer.parseInt(computerDetails[2]);
                int D = Integer.parseInt(computerDetails[3]);

                int speed = (2 * R) + (3 * S) + D;

                computers.add(computerDetails[0] + " " + speed);
            }
            if (computers.size() == 1) {
                System.out.println(computers.get(0).split(" ")[0]);
            }
            else {
                String fastest = computers.get(0);
                String second = computers.get(1);


                int firstSpeed = Integer.parseInt(fastest.split(" ")[1]);
                String nameFirst = fastest.split(" ")[0];

                int secondSpeed = Integer.parseInt(second.split(" ")[1]);
                String nameSecond = second.split(" ")[0];


                if (firstSpeed <= secondSpeed) {
                    if (firstSpeed == secondSpeed) {
                        if (nameFirst.compareTo(nameSecond) > 0) {
                            String t = fastest;
                            fastest = second;
                            second = t;
                        }
                    } else {
                        String t = fastest;
                        fastest = second;
                        second = t;
                    }
                }
                for (int i = 2; i < computers.size(); i++) {
                    int value = Integer.parseInt(computers.get(i).split(" ")[1]);
                    int secondValue = Integer.parseInt(second.split(" ")[1]);
                    int firstValue = Integer.parseInt(fastest.split(" ")[1]);
                    String valueName = computers.get(i).split(" ")[0];
                    String secondName = second.split(" ")[0];
                    String firstName = fastest.split(" ")[0];
                    int temp;
                    String tempName;

                    if (value >= secondValue) {
                        if (value >= firstValue) {
                            if (value == firstValue) {

                                if (firstName.compareTo(valueName) > 0) {
                                    tempName = fastest;
                                    fastest = computers.get(i);
                                    second = tempName;
                                } else {
                                    second = computers.get(i);
                                }

                            } else {
                                tempName = fastest;
                                fastest = computers.get(i);
                                second = tempName;
                            }
                        } else {
                            if (value == secondValue) {

                                if (secondName.compareTo(valueName) > 0) {
                                    second = computers.get(i);
                                }

                            } else {
                                second = computers.get(i);
                            }
                        }
                    }
                }

                System.out.println(fastest.split(" ")[0]);
                System.out.println(second.split(" ")[0]);
            }
        }
    }
}
