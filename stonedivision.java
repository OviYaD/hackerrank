import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'stoneDivision' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. LONG_INTEGER n
     *  2. LONG_INTEGER_ARRAY s
     */

   
public static long stoneDivision(long sizeOfPile, List<Long> querySet, Map<Long, Long> dp) {

        if (sizeOfPile == 0 || sizeOfPile == 1) {
            return 0;
        }

        if (dp.containsKey(sizeOfPile)) {
            return dp.get(sizeOfPile);
        }

        long max = 0;

        for (long query : querySet) {
            long sum = 0;
            if (sizeOfPile % query != 0 || sizeOfPile == query) {
                continue;
            }

            long numberOfPiles = sizeOfPile/query;
            sum += stoneDivision(query, querySet, dp) * numberOfPiles;
            sum += 1;
            max = Math.max(max, sum);
        }

        dp.put(sizeOfPile, max);

        return max;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            long n = Long.parseLong(firstMultipleInput[0]);

            int m = Integer.parseInt(firstMultipleInput[1]);

            String[] sTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
Map<Long, Long> dp= new HashMap<>();;
            List<Long> s = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                long sItem = Long.parseLong(sTemp[i]);
                s.add(sItem);
            }

            long result = Result.stoneDivision(n, s,dp);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
