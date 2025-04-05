import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int total;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> adj;
    static StringBuilder answerSB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 1; ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            visited = new boolean[N+1];
            total = 0;

            // 반복문 탈출 조건
            if(N == 0 && M == 0) {
                break;
            }

            // 인접리스트 선언
            adj = new ArrayList<>();

            for(int j = 0; j <= N; j++) {
                adj.add(new ArrayList<>());
            }

            for(int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                adj.get(from).add(to);
                adj.get(to).add(from);
            }

            // BFS 돌리기
            for(int j = 1; j <= N; j++) {
                if(!visited[j]){
                    BFS(j);
                }
            }

            if(total == 0) {
                answerSB.append("Case ").append(i).append(": No trees.").append('\n');
            }else if(total == 1) {
                answerSB.append("Case ").append(i).append(": There is one tree.").append('\n');
            }else {
                answerSB.append("Case ").append(i).append(": A forest of ").append(total).append(" trees.").append('\n');
            }
        }

        System.out.print(answerSB);
    }

    public static void BFS(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = true;
        boolean treeCheck = false;
        while(!q.isEmpty()) {
            int cnt = 0;
            int cur = q.remove();
            for(int nxt : adj.get(cur)) {
                if(visited[nxt]) cnt++;
                else {
                    q.add(nxt);
                    visited[nxt] = true;
                }
            }
            if(cnt > 1) {
                treeCheck = true;
            }
        }
        if(!treeCheck) total++;
    }
}