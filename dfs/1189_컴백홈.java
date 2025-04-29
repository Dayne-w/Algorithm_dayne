import java.util.*;
import java.io.*;

public class Main {

    static int R, C, K;
    static char[][] street;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int answer = 0;
    static boolean isArrived = false;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        street = new char[R][C];
        visited = new boolean[R][C];

        for(int i = 0; i < R; i++) {
            String str = br.readLine();
            for(int j = 0; j < C; j++) {
                street[i][j] = str.charAt(j);
                visited[i][j] = false;
            }
        }

        visited[R-1][0] = true;
        DFS(0, R-1, 1);

        System.out.print(answer);
    }

    public static void DFS(int curX, int curY, int dist) {
        if(curX == C-1 && curY == 0) {
            if(street[curY][curX] == 'T') return;

            if(dist == K) {
                answer++;

            }
            return;
        }

        for(int i = 0; i < 4; i++) {
            int nextX = curX + dx[i];
            int nextY = curY + dy[i];

            if(nextX < 0 || nextX >= C || nextY < 0 || nextY >= R) continue;
            if(street[nextY][nextX] != 'T' && !visited[nextY][nextX]) {
                visited[nextY][nextX] = true;
                DFS(nextX, nextY, dist+1);
                visited[nextY][nextX] = false;
            }
        }
    }
}