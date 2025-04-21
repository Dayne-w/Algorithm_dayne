import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static ArrayList<Integer> nums = new ArrayList<>();
    static boolean[] visited = new boolean[100001];
    static long answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int inputNum = Integer.parseInt(st.nextToken());
            nums.add(inputNum);
        }

        int left = 0, right = 0;

        while(right < N) {
            if(!visited[nums.get(right)]) {
                visited[nums.get(right)] = true;
                right++;
            }else {
                answer += (right - left);
                visited[nums.get(left)] = false;
                left++;
            }
        }

        // left와 right가 동일하지 않은 상태로 반복문 끝났을 경우
        answer += (long) (right - left) * (right - left + 1) / 2;

        System.out.println(answer);
    }
}