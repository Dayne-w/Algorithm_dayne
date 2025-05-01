import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int K;
    static ArrayList<Integer> arr = new ArrayList<>();
    static int evenCnt = 0;
    static int oddCnt = 0;
    static int start = 0, end = 0;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        while(end < arr.size()) {
            if(arr.get(end) % 2 != 0) {
                if(K > oddCnt) {
                    oddCnt++;
                    end++;
                }else {
                    // oddCnt가 K보다 작아질 때까지, 짝수면 evenCnt-- 홀수면 oddCnt--
                    while(K == oddCnt) {
                        if(arr.get(start) % 2 == 0) {
                            evenCnt--;
                        }else {
                            oddCnt--;
                        }
                        start++;
                    }
                    // 새롭게 추가된 홀수 반영
                    oddCnt++;
                    end++;
                }
            }else {
                evenCnt++;
                answer = Math.max(answer, evenCnt);
                end++;
            }
        }

        System.out.print(answer);
    }
}