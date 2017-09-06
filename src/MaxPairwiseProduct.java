import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    static long getMaxPairwiseProduct(int[] numbers) {
        long result = 0;
        int n = numbers.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                long temp = Long.valueOf(numbers[i]) * Long.valueOf(numbers[j]);
                if (temp > result) {
                    result = temp;
                }
            }
        }
        return result;
    }

    static long getMaxPairwiseProductFast(int[] numbers) {

        if(numbers == null) {
            return 1;
        }

        int n = numbers.length;
        int indexOfMax1 = -1;
        for(int i = 0; i < n; i++) {
            if(indexOfMax1 == -1 || numbers[i] > numbers[indexOfMax1]) {
                indexOfMax1 = i;
            }
        }

        int indexOfMax2 = -1;
        for(int j = 0; j < n; j++) {
            if((numbers[j] != numbers[indexOfMax1])
                && (indexOfMax2 == -1 || numbers[j] > numbers[indexOfMax2])) {
                indexOfMax2 = j;
            }
        }

        // depends on kind of data - boundary values
        long valueMax1 = 1;
        if(indexOfMax1 != -1) {
            valueMax1 = Long.valueOf(numbers[indexOfMax1]);
        }

        long valueMax2 = 1;
        if(indexOfMax2 != -1) {
            valueMax2 = Long.valueOf(numbers[indexOfMax2]);
        }
        return valueMax1 * valueMax2;
    }


    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        //System.out.println(getMaxPairwiseProduct(numbers));
        System.out.println(getMaxPairwiseProductFast(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}