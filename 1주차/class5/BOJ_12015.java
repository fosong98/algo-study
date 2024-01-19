import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        Memory memory = new Memory(N);

        StringTokenizer st = new StringTokenizer(reader.readLine());
        while (N-- > 0) {
            memory.add(Integer.parseInt(st.nextToken()));
        }

        System.out.println(memory.getLongestSequenceLength());
    }

    static class Memory {
        int[][] coll;
        int N;
        int next = 0;
        int tail = Integer.MAX_VALUE;

        Memory(int N) {
            this.coll = new int[N][2];
            this.N = N;
        }

        void add(int num) {

            if (tail > num) {
                coll[next][0] = num;
                coll[next][1] = 1;
                tail = num;
                next++;
                return;
            }

            for (int i = 0; i < next; ++i) {
                if (coll[i][0] < num) {
                    coll[i][0] = num;
                    coll[i][1]++;
                }
            }

            coll[next][0] = tail;
            coll[next][1] = 1;
            next++;
        }

        int getLongestSequenceLength() {
            int max = 0;
            for (int i = 0; i < next; ++i) {
                max = Math.max(max, coll[i][1]);
            }
            return max;
        }
    }
}
