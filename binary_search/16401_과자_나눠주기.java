import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static ArrayList<Integer> snacks = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            snacks.add(Integer.parseInt(st.nextToken()));
        }

        snacks.sort(Comparator.naturalOrder());

        System.out.println(binarySearch());
    }

    public static long binarySearch() {
        long low = 0;
        long high = 1000000000;
        while (low < high) {
            long mid = (low + high) / 2;
            long cnt = 0;
            for(int i = 0; i < snacks.size(); i++) {
                int snackLen = snacks.get(i);
                if(mid == 0) return 0;
                cnt += snackLen / mid;
            }

            if(cnt >= N) {
                low = mid + 1;
            }else {
                high = mid;
            }
        }

        return low-1;
    }
}