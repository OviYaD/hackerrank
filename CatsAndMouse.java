import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the catAndMouse function below.
    static String catAndMouse(int x, int y, int z) {
        int a=z-x;
        if(a<0)
        a*=-1;
        int b=z-y;
        if(b<0)
        b*=-1;
        if(a>b)
        return "Cat B";
        else if(b>a)
        return "Cat A";
        else if(b==a)
        return "Mouse C";
        return "";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] xyz = scanner.nextLine().split(" ");

            int x = Integer.parseInt(xyz[0]);

            int y = Integer.parseInt(xyz[1]);

            int z = Integer.parseInt(xyz[2]);

            String result = catAndMouse(x, y, z);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
