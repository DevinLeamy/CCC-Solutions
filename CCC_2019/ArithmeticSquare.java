import java.util.*;
import java.io.*;

public class ArithmeticSquare {
    private static String[] newValues(String[] oldValues)
    {
        for (int i = 0; i < 3; i++)
        {
            try {
                if (oldValues[i].equals("X")) {
                    switch (i)
                    {
                        case 0:
                            oldValues[0] = String.valueOf(Integer.parseInt(oldValues[1]) - (Integer.parseInt(oldValues[2]) - Integer.parseInt(oldValues[1])));
                        case 1:
                            oldValues[1] = String.valueOf(Integer.parseInt(oldValues[0]) + ((Integer.parseInt(oldValues[2]) - Integer.parseInt(oldValues[0]))/2));
                        case 2:
                            oldValues[2] = String.valueOf(Integer.parseInt(oldValues[1]) + ((Integer.parseInt(oldValues[1]) - Integer.parseInt(oldValues[0]))));
                    }
                    return oldValues;
                }
            } catch (NumberFormatException nfe)
            {
                break;
            }
        }
        return new String[0];
    }
    private static boolean fixed(String[][] box)
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (box[i][j].equals("X"))
                {
                    return false;
                }
            }
        }
        return true;
    }
    private static void put(String[][] box)
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (box[i][j].equals("X"))
                {
                    try {
                        if (Integer.parseInt(box[i + 2][j]) % 2 == 1)
                        {
                            box[i][j] = "1";
                            return;
                        }
                    } catch (Exception e) { }
                    try {
                        if (Integer.parseInt(box[i - 2][j]) % 2 == 1)
                        {
                            box[i][j] = "1";
                            return;
                        }
                    } catch (Exception e) { }
                    try {
                        if (Integer.parseInt(box[i][j + 2]) % 2 == 1)
                        {
                            box[i][j] = "1";
                            return;
                        }
                    } catch (Exception e) { }
                    try {
                        if (Integer.parseInt(box[i][j - 2]) % 2 == 1)
                        {
                            box[i][j] = "1";
                            return;
                        }
                    } catch (Exception e) { }
                    box[i][j] = "0";
                    return;
                }
            }
        }
    }
    private static void print(String[][] box)
    {
        for (int i = 0; i < 3; i++)
        {
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < 3; j++)
            {
                line.append(box[i][j]);
                line.append(" ");
            }
            System.out.println(line.toString());
        }
    }
    public static void main(String[] args) throws IOException
    {
        String[][] box = new String[3][3];
        for (int i = 0; i < 3; i++)
        {
            StringTokenizer line = new StringTokenizer(in.readLine());
            for (int j = 0; j < 3; j++)
            {
                box[i][j] = line.nextToken();
            }
        }
        String[] newValues;
        String[] get = new String[3];
        while (!fixed(box))
        {
            boolean fixed = false;
            for (int i = 0; i < 6; i++)
            {
                switch (i)
                {
                    case 0:
                        get[0] = box[0][0]; get[1] = box[0][1]; get[2] = box[0][2];
                        newValues = newValues(get);
                        if (newValues.length > 0)
                        {
                            box[0][0] = newValues[0];
                            box[0][1] = newValues[1];
                            box[0][2] = newValues[2];
                            fixed = true;
                        }
                        break;
                    case 1:
                        get[0] = box[1][0]; get[1] = box[1][1]; get[2] = box[1][2];
                        newValues = newValues(get);
                        if (newValues.length > 0)
                        {
                            box[1][0] = newValues[0];
                            box[1][1] = newValues[1];
                            box[1][2] = newValues[2];
                            fixed = true;
                        }
                        break;
                    case 2:
                        get[0] = box[2][0]; get[1] = box[2][1]; get[2] = box[2][2];
                        newValues = newValues(get);
                        if (newValues.length > 0)
                        {
                            box[2][0] = newValues[0];
                            box[2][1] = newValues[1];
                            box[2][2] = newValues[2];
                            fixed = true;
                        }
                        break;
                    case 3:
                        get[0] = box[0][1]; get[1] = box[1][1]; get[2] = box[2][1];
                        newValues = newValues(get);
                        if (newValues.length > 0)
                        {
                            box[0][1] = newValues[0];
                            box[1][1] = newValues[1];
                            box[2][1] = newValues[2];
                            fixed = true;
                        }
                        break;
                    case 4:
                        get[0] = box[0][0]; get[1] = box[1][0]; get[2] = box[2][0];
                        newValues = newValues(get);
                        if (newValues.length > 0)
                        {
                            box[0][0] = newValues[0];
                            box[1][0] = newValues[1];
                            box[2][0] = newValues[2];
                            fixed = true;
                        }
                        break;
                    case 5:
                        get[0] = box[0][2]; get[1] = box[1][2]; get[2] = box[2][2];
                        newValues = newValues(get);
                        if (newValues.length > 0)
                        {
                            box[0][2] = newValues[0];
                            box[1][2] = newValues[1];
                            box[2][2] = newValues[2];
                            fixed = true;
                        }
                        break;
                }
            }
            if (!fixed)
            {
                put(box);
            }
        }
        print(box);
    }
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
}
