import java.util.*;
import java.io.*;

public class Main {

    static long N;
    static long M;
    static long answer;
    static ArrayList<Long> TreeArr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            TreeArr.add(Long.parseLong(st.nextToken()));
        }

        System.out.print(upperBound());
    }

    public static long upperBound() {
        long low = 0;
        long high = 2000000000;
        long mid;
        while(low < high) {
            long sum = 0;
            mid = (low + high) / 2;
            for(long n : TreeArr) {
                if(n >= mid) sum += (n - mid);
            }
            if(M > sum) {
                high = mid;
            }else {
                low = mid + 1;
            }
        }

        return low-1;
    }
}