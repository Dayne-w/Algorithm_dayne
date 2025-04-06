import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] aquarium = new int[20][20];
    // 거리가 같은 물고기가 있을 때, 가장 위쪽, 가장 왼쪽에 있는 물고기를 찾기 위해 해당 기준으로 정렬
    static TreeSet<Fish> fishLocation = new TreeSet<>((o1, o2) -> {
        if(o1.y == o2.y) {
            return o1.x - o2.x;
        }
        return o1.y - o2.y;
    });
    static int sharkX = 0, sharkY = 0;
    static int fishX, fishY;
    static int sharkSize = 2;
    static int cnt = 0;
    static int answerTime = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        input();

        while(!fishLocation.isEmpty()) {
            int dist = 401;
            aquarium[sharkY][sharkX] = 0;
            for(Fish fish : fishLocation) {
                if(fish.fishSize >= sharkSize) continue;
                int dfsDist = BFS(fish.x, fish.y);
                if (dfsDist < dist) {
                    dist = dfsDist;
                    fishX = fish.x;
                    fishY = fish.y;
                }
            }
            if(dist == 401) break; // 물고기 못 찾은 경우
            sharkX = fishX;
            sharkY = fishY;
            fishLocation.remove(new Fish(aquarium[fishY][fishX],fishX, fishY));
            answerTime += dist;
            cnt++;
            if(sharkSize == cnt) {
                cnt = 0;
                sharkSize++;
            }
        }

        System.out.print(answerTime);
    }

    public static int BFS(int x, int y) {
        int[][] dist = new int[N][N];
        for(int i = 0; i < N; i++) {
            Arrays.fill(dist[i], -1);
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sharkX, sharkY));
        dist[sharkY][sharkX] = 0;
        while(!q.isEmpty()) {
            Pair cur = q.remove();
            for(int i = 0; i < 4; i++) {
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];
                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
                if(aquarium[nextY][nextX] <= sharkSize && dist[nextY][nextX] == -1) {
                    q.add(new Pair(nextX, nextY));
                    dist[nextY][nextX] = dist[cur.y][cur.x] + 1;
                }

            }
        }
        return dist[y][x] == -1 ? 401 : dist[y][x];
    }



    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                aquarium[i][j] = Integer.parseInt(st.nextToken());
                // 상어인 경우
                if(aquarium[i][j] == 9) {
                    sharkX = j;
                    sharkY = i;
                }

                // 물고기의 크기에 따라 ArrayList 구분해서 좌표 저장
                if(aquarium[i][j] >= 1 && aquarium[i][j] <= 6) {
                    fishLocation.add(new Fish(aquarium[i][j], j, i));
                }
            }
        }
    }

    public static class Fish {
        public int fishSize = 0;
        public int x;
        public int y;

        public Fish(int fishSize, int x, int y) {
            this.fishSize = fishSize;
            this.x = x;
            this.y = y;
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