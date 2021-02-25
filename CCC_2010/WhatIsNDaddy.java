//Problem 1 . Completed

import java.util.*;

public class WhatIsNDaddy {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int counter = 0;
        for (int i = 0; i < 6; i++)
        {
          if (num - i <= 5 && i <= num-i){
              counter++;
          }
        }
        System.out.println(counter);
    }
}
