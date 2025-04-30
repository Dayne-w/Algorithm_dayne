import java.util.*;
import java.io.*;

public class Main {

    static int N;   // 도시의 가로 및 세로 길이
    static int M;   // 선택할 치킨 집의 개수
    static int[][] city = new int[51][51];
    static ArrayList<Pair> homeLocations = new ArrayList<>();    // 집들의 위치
    static ArrayList<Pair> chickenLocations = new ArrayList<>();    // 치킨집들의 위치
    static ArrayList<Pair> backTrackingChickenArr = new ArrayList<>();    // 백트래킹 시에 선택된 치킨집 저장할 ArrayList
    static boolean[] visited = new boolean [14];    // 백트래킹 시에 방문 여부 판단할 배열
    static int answer = 100 * 100 * 13 + 5;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                if(city[i][j] == 1) {
                    homeLocations.add(new Pair(j, i));
                }

                if(city[i][j] == 2) {
                    chickenLocations.add(new Pair(j, i));
                }
            }
        }

        // 치킨집이 1개일 때부터, M개일 때까지 각각의 경우에 대해 도시의 치킨 거리 구하면서 최솟값 찾기
        for(int i = 1; i <= M; i++) {
            backTrackingChickenArr.clear();
            Arrays.fill(visited, false);
            backTracking(0, i);
        }

        System.out.println(answer);

    }

    public static void backTracking(int start, int size) {
        if(backTrackingChickenArr.size() == size) {
            answer = Math.min(answer, countCityChickenDist());
        }
        for(int i = start; i < chickenLocations.size(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                backTrackingChickenArr.add(chickenLocations.get(i));
                backTracking(i+1, size);
                backTrackingChickenArr.remove(backTrackingChickenArr.size()-1);
                visited[i] = false;
            }
        }
    }

    // 도시의 치킨 거리 구하는 함수
    public static int countCityChickenDist() {
        int cityChickenDist = 0;
        for(int i = 0; i < homeLocations.size(); i++) {
            Pair curHome = homeLocations.get(i);
            int tempChickenDist = 200;
            for(int j = 0; j < backTrackingChickenArr.size(); j++) {
                Pair curChicken = backTrackingChickenArr.get(j);
                tempChickenDist = Math.min(tempChickenDist, (Math.abs(curHome.x - curChicken.x) + Math.abs(curHome.y - curChicken.y)));
            }
            cityChickenDist += tempChickenDist;
        }
        return cityChickenDist;
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