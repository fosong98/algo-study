import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        int[] coll = new int[N + 1];
        StringTokenizer st = new StringTokenizer(reader.readLine());

        coll[1] = Integer.parseInt(st.nextToken());
        int maxLength = 1;

        while (st.hasMoreTokens()) {
            int next = Integer.parseInt(st.nextToken());

            if (coll[maxLength] < next) {
                coll[++maxLength] = next;
            } else {
                int l = binarySearch(coll, maxLength, next);
                if (l != -1)
                    coll[l] = next;
            }
        }
        System.out.println(maxLength);
    }

    public static int binarySearch(int[] coll, int length, int number) {
        int min = 1;
        int max = length + 1;

        int cur = (min + max) / 2;
        int prev = Integer.MAX_VALUE;

        while (cur != prev) {
            int curLengthValue = coll[cur];
            int prevLengthValue = coll[cur - 1];

            if (curLengthValue == number)
                return -1;

            if (prevLengthValue < number && number < curLengthValue)
                return cur;

            prev = cur;
            if (number > curLengthValue) {
                min = cur;
                cur = (cur + max) / 2;
            } else {
                max = cur;
                cur = (cur + min) / 2;
            }
        }

        return -1;
    }
}
