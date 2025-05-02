import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static ArrayList<Integer>[] adj = new ArrayList[101];
    static StringBuilder answerSB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        // 인접 리스트 초기화
        for(int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }

        // 인접 리스트 구성
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                if(n == 1) {
                    adj[i].add(j);
                }
            }
        }

        // 결과 저장
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                answerSB.append(BFS(i, j)).append(" ");
            }
            answerSB.append('\n');
        }

        System.out.print(answerSB.toString());
    }

    public static int BFS(int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[101];
        q.add(start);
        if(start != end) {
            visited[start] = true;
        }

        while(!q.isEmpty()) {
            int cur = q.remove();

            for(int n : adj[cur]) {
                if(!visited[n]) {
                    q.add(n);
                    visited[n] = true;
                }
            }
        }

        if(!visited[end]) {
            return 0;
        }else {
            return 1;
        }
    }
}