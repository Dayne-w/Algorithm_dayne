import java.io.*;
import java.util.*;

public class Main {

    static int K, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int[] lanArr = new int[K];

        for(int i = 0; i < K; i++) {
            lanArr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(lanArr);

        System.out.print(binarySearch(lanArr));
    }

    public static long binarySearch(int[] lanArr) {
        long low = 1;
        long high = lanArr[K-1];
        long mid;
        while(low <= high) {
            long sum = 0;
            mid = (low + high) / 2;
            for(int i = 0; i < K; i++) {
                sum += lanArr[i] / mid;
            }
            if(sum >= N) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }

        }
        return low-1;
    }

}