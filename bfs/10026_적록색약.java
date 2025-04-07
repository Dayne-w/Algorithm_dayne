import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static char[][] picture = new char[101][101];
    static boolean[][] visited = new boolean[101][101];
    static int cntX = 0, cntO = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 그림 초기화
        for(int i = 0; i < N; i++) {
            String colors = br.readLine();
            for(int j = 0; j < N; j++) {
                picture[i][j] = colors.charAt(j);
            }
        }

        // 색약 아닌 사람 케이스
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    cntX++;
                    BFS_X(j, i);
                }
            }
        }

        // vistied 초기화
        for(int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
        }

        // 색약인 사람 케이스
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    cntO++;
                    BFS_O(j, i);
                }
            }
        }

        System.out.println(cntX + " " + cntO);
    }

    public static void BFS_X(int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));
        visited[y][x] = true;

        while(!q.isEmpty()) {
            Pair cur = q.remove();

            for(int i = 0; i < 4; i++) {
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
                if(!visited[nextY][nextX] && picture[nextY][nextX] == picture[cur.y][cur.x]) {
                    q.add(new Pair(nextX, nextY));
                    visited[nextY][nextX] = true;
                }
            }
        }
    }

    public static void BFS_O(int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));
        visited[y][x] = true;

        while(!q.isEmpty()) {
            Pair cur = q.remove();

            for(int i = 0; i < 4; i++) {
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];
                char curColor = picture[cur.y][cur.x];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;

                if(curColor == 'R' || curColor == 'G') {
                    if(!visited[nextY][nextX] && (picture[nextY][nextX] == 'R' || picture[nextY][nextX] == 'G')) {
                        q.add(new Pair(nextX, nextY));
                        visited[nextY][nextX] = true;
                    }
                }else {
                    if(!visited[nextY][nextX] && picture[nextY][nextX] == 'B') {
                        q.add(new Pair(nextX, nextY));
                        visited[nextY][nextX] = true;
                    }
                }
            }
        }
    }


    public static class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}