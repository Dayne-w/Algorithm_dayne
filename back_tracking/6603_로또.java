import java.io.*;
import java.util.*;

public class Main {

    static int k;
    static ArrayList<Integer> S = new ArrayList<>();
    static boolean[] visited = new boolean[13]; // 인덱스를 기준으로 방문 여부 확인
    static ArrayList<Integer> backTrackingArr = new ArrayList<>();
    static StringBuilder answerSB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            if(k == 0) break;

            Arrays.fill(visited, false);
            S.clear();
            backTrackingArr.clear();

            for(int i = 0; i < k; i++) {
                S.add(Integer.parseInt(st.nextToken()));
            }

            backTracking(0);

            answerSB.append('\n');
        }

        System.out.print(answerSB.toString());
    }

    public static void backTracking(int start) {
        if(backTrackingArr.size() == 6) {
            for(int n : backTrackingArr) {
                answerSB.append(n).append(" ");
            }
            answerSB.append('\n');
            return;
        }

        for(int i = start; i < k; i++) {
            if(!visited[i]) {
                visited[i] = true;
                backTrackingArr.add(S.get(i));
                backTracking(i+1);
                backTrackingArr.remove(backTrackingArr.size()-1);
                visited[i] = false;
            }
        }
    }
}