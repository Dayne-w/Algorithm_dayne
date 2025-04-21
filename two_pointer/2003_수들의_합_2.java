import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static ArrayList<Integer> nums = new ArrayList<>();
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int inputNum = Integer.parseInt(st.nextToken());
            nums.add(inputNum);
        }
        nums.add(0);

        int left = 0;
        int right = 0;
        int sum = 0;

        while(left <= N && right <= N) {
            if(sum >= M) {
                sum -= nums.get(left++);
            }else {
                sum += nums.get(right++);
            }
            if(sum == M) answer++;
        }



        System.out.println(answer);
    }
}