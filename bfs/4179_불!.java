import java.io.*;
import java.util.*;

public class Main {

    static int R, C;
    static int jhX, jhY;
    static char[][] maze = new char[1001][1001];
    static int[][] jh = new int[1001][1001];
    static int[][] fire = new int[1001][1001];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static ArrayList<Pair> fireLocation = new ArrayList<>();
    static int answer = 1001;

    public static void main(String[] args) throws IOException {
        input();
        fill();
        bfs_jh(jhX, jhY);
        for(Pair p : fireLocation) {
            bfs_fire(p.x, p.y);
        }
        findAnswer();
        if(answer == 1001) {
            System.out.print("IMPOSSIBLE");
        }else {
            System.out.print(answer+1);
        }
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        for(int i = 0; i < R; i++) {
            String str = br.readLine();
            for(int j = 0; j < C; j++) {
                maze[i][j] = str.charAt(j);
                if(maze[i][j] == 'F') fireLocation.add(new Pair(j, i));
                if(maze[i][j] == 'J') {
                    jhX = j;
                    jhY = i;
                }
            }
        }
    }

    public static void fill() {
        for(int i = 0; i < 1001; i++) {
            Arrays.fill(jh[i], 1000010);
            Arrays.fill(fire[i], 1000010);
        }
    }

    public static void bfs_jh (int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));
        jh[y][x] = 0;
        while(!q.isEmpty()) {
            Pair cur = q.remove();
            for(int i = 0; i < 4; i++) {
                int newX = cur.x + dx[i];
                int newY = cur.y + dy[i];

                if(newX < 0 || newX >= C || newY < 0 || newY >= R) continue;
                if(maze[newY][newX] == '#' || maze[newY][newX] == 'F') continue;
                if(jh[newY][newX] == 1000010) {
                    q.add(new Pair(newX, newY));
                    jh[newY][newX] = jh[cur.y][cur.x]+1;
                }
            }
        }
    }

    public static void bfs_fire(int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));
        fire[y][x] = 0;
        while(!q.isEmpty()) {
            Pair cur = q.remove();
            for(int i = 0; i < 4; i++) {
                int newX = cur.x + dx[i];
                int newY = cur.y + dy[i];

                if(newX < 0 || newX >= C || newY < 0 || newY >= R) continue;
                if(maze[newY][newX] == '#' || maze[newY][newX] == 'F') continue;
                if(fire[cur.y][cur.x]+1 < fire[newY][newX]) {
                    q.add(new Pair(newX, newY));
                    fire[newY][newX] = fire[cur.y][cur.x]+1;
                }
            }
        }
    }

    public static void findAnswer() {
        for(int i = 0; i < R; i++) {
            if(jh[i][0] < fire[i][0]) {
                answer = Math.min(answer, jh[i][0]);
            }
        }
        for(int i = 0; i < R; i++) {
            if(jh[i][C-1] < fire[i][C-1]) {
                answer = Math.min(answer, jh[i][C-1]);
            }
        }

        for(int i = 0; i < C; i++) {
            if(jh[0][i] < fire[0][i]) {
                answer = Math.min(answer, jh[0][i]);
            }
        }

        for(int i = 0; i < C; i++) {
            if(jh[R-1][i] < fire[R-1][i]) {
                answer = Math.min(answer, jh[R-1][i]);
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