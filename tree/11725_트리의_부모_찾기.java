import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    static int[] parent = new int[100001];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        bfs(1);

        for(int i = 2; i <= N; i++) {
            if(parent[i] != 0) {
                sb.append(parent[i]).append('\n');
            }
        }

        System.out.print(sb);
    }

    public static void bfs(int n) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(n);
        while (!q.isEmpty()) {
            int cur = q.remove();
            for (int num : tree.get(cur)) {
                if (parent[num] == 0) {
                    parent[num] = cur;
                    q.add(num);
                }
            }
        }
    }
}
