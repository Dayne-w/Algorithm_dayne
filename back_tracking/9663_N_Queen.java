import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] visited = new int[15][15];
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        backTracking(0);

        System.out.print(answer);
    }

    public static void backTracking(int idx) {
        if(idx == N) {
            answer++;
            return;
        }
        for(int i = 0; i < N; i++) {
            if(visited[idx][i] == 0) {
                int tempX, tempY;
                visited[idx][i]++;
                // 세로++
                for(int j = idx+1; j < N; j++) {
                    visited[j][i]++;
                }
                // 상향 대각선 ++ /
                tempX = i-1; tempY = idx+1;
                while(tempX >= 0 && tempY < N) {
                    visited[tempY++][tempX--]++;
                }
                // 하향 대각선 ++ \
                tempX = i+1; tempY = idx+1;
                while(tempX < N && tempY < N) {
                    visited[tempY++][tempX++]++;
                }
                backTracking(idx+1);
                visited[idx][i]--;
                // 세로--
                for(int j = idx+1; j < N; j++) {
                    visited[j][i]--;
                }
                // 상향 대각선 -- /
                tempX = i-1; tempY = idx+1;
                while(tempX >= 0 && tempY < N) {
                    visited[tempY++][tempX--]--;
                }
                // 하향 대각선 -- \
                tempX = i+1; tempY = idx+1;
                while(tempX < N && tempY < N) {
                    visited[tempY++][tempX++]--;
                }
            }
        }
    }
}