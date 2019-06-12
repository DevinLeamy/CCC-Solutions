//Problem 3 . Completed

import java.util.*;

public class Punchy {
    public static void main(String[] args)
    {

        int A = 0;
        int B = 0;
      Scanner in = new Scanner(System.in);
      while (true) {
          String[] line = in.nextLine().split(" ");
          if (line[0].equals("7")) {
              break;
          }
          if (line[0].equals("1")) {
              if (line[1].equals("A")) {
                  A = Integer.parseInt(line[2]);
              } else {
                  B = Integer.parseInt(line[2]);
              }
          } else if (line[0].equals("2"))
          {
              System.out.println((line[1].equals("A"))? A:B);
          } else if (line[0].equals("3"))
          {
              if (line[1].equals("A"))
              {
                  A += ((line[2].equals("A"))? A:B);
              } else {B += ((line[2].equals("A"))? A:B);}
          }
          else if (line[0].equals("4"))
          {
              if (line[1].equals("A"))
              {
                  A *= ((line[2].equals("A"))? A:B);
              } else {B *= ((line[2].equals("A"))? A:B);}
          }else if (line[0].equals("5"))
          {
              if (line[1].equals("A"))
              {
                  A -= ((line[2].equals("A"))? A:B);
              } else {B -= ((line[2].equals("A"))? A:B);}
          }
          else if (line[0].equals("6"))
          {
              if (line[1].equals("A"))
              {
                  A /= ((line[2].equals("A"))? A:B);
              } else {B /= ((line[2].equals("A"))? A:B);}
          }
      }
    }
}
