import java.util.*;
import java.io.*;

public class Main {

    static int N;   // 트리의 정점의 수
    static int R;   // 루트의 번호
    static int Q;   // 쿼리의 수
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();   // 인접 리스트
    static int[] parent = new int [100001]; // 각 노드의 부모 노드를 저장할 배열
    static int[] depth = new int [100001];  // 각 노드의 깊이를 저장할 배열
    static int[] childCnt = new int [100001];   // 각 노드의 자식의 개수를 저장할 배열
    static ArrayList<Integer> nums = new ArrayList<>();
    static StringBuilder answerSB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        // adj 초기화 및 childCnt 1로 초기화 및 nums에 1부터 N까지 추가
        for(int i = 0; i <= N; i++) {
            adj.add(new ArrayList<Integer>());
            childCnt[i] = 1;
            if(i != 0) nums.add(i);
        }

        // adj 구성
        for(int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        // BFS로 부모 노드 및 depth 배열 초기화
        BFS(R);

        // depth 배열을 기준으로 nums 내림차순
        nums.sort((o1, o2) -> {
           return depth[o2] - depth[o1];
        });

        // 정렬된 nums 순차적으로 돌면서 childCnt 배열 구성;
        for(int i = 0; i < N; i++) {
            int cur = nums.get(i);
            childCnt[parent[cur]] += childCnt[cur];
        }

        // 쿼리문의 개수만큼 출력
        while(Q-- > 0) {
            int target = Integer.parseInt(br.readLine());
            answerSB.append(childCnt[target]).append('\n');
        }

        System.out.print(answerSB.toString());
    }

    public static void BFS(int root) {
        Queue<Integer> q = new LinkedList<>();
        q.add(root);
        parent[root] = 0;
        depth[root] = 0;
        while(!q.isEmpty()) {
            int cur = q.remove();
            for(int nxt : adj.get(cur)) {
                if(parent[cur] == nxt) continue;
                parent[nxt] = cur;
                depth[nxt] = depth[cur] + 1;
                q.add(nxt);
            }
        }

    }
}