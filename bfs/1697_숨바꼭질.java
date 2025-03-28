import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] points = new int[100001];
    static int[] dx = {-1, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Arrays.fill(points, -1);

        bfs(N);

        System.out.println(points[K]);
    }

    public static void bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        points[n] = 0;
        while(points[K] == -1) {
            int cur = q.remove();
            for(int nxt : new int[]{cur - 1, cur + 1, cur * 2}) {
                if(nxt < 0 || nxt > 100000) continue;
                if(points[nxt] != -1) continue;
                points[nxt] = points[cur]+1;
                q.add(nxt);
            }
        }
    }
}
