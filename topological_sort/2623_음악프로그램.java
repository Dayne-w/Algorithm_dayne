import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static ArrayList<TreeSet<Integer>> adj = new ArrayList<>();
    static int[] inDegree = new int[1001];
    static int k = 0;
    static StringBuilder answerSB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 인접 리스트 초기화
        for(int i = 0; i <= N; i++) {
            adj.add(new TreeSet<>());
        }

        // 연결 관계 설정 & deg 설정
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            int[] tmpArr = new int[k];
            for(int j = 0; j < k; j++) {
                tmpArr[j] = Integer.parseInt(st.nextToken());
            }
            for(int j = 0; j < k-1; j++) {
                int from = tmpArr[j];
                int to = tmpArr[j+1];
                /*
                    근데 이렇게 하면, 보조작가 2가 2->3 하고 보조작가 3도 2->3 하면 adj[2]에 3이 두 번 들어가는데..? -> TreeSet으로.
                    이미 값 있으면 inDegree도 ++하지 않도록
                 */
                if(adj.get(from).contains(to)) continue;
                adj.get(from).add(to);
                inDegree[to]++;
            }
        }

        topologySort();

        System.out.print(answerSB);
    }

    public static void topologySort() {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> answerList = new ArrayList<>();

        for(int i = 1; i <= N; i++) {
            if(inDegree[i] == 0) q.add(i);
        }

        while(!q.isEmpty()) {
            int cur = q.remove();
            answerList.add(cur);
            for(int nxt  : adj.get(cur)) {
                inDegree[nxt]--;
                if(inDegree[nxt] == 0) q.add(nxt);
            }
        }

        if(answerList.size() != N) {
            answerSB.append(0);
        }else {
            for(int n : answerList) {
                answerSB.append(n).append('\n');
            }
        }
    }
}