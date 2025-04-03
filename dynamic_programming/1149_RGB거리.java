import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] totalCost = new int[1000][3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        totalCost[0][0] = Integer.parseInt(st.nextToken());
        totalCost[0][1] = Integer.parseInt(st.nextToken());
        totalCost[0][2] = Integer.parseInt(st.nextToken());

        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int costRed = Integer.parseInt(st.nextToken());
            int costGreen = Integer.parseInt(st.nextToken());
            int costBlue = Integer.parseInt(st.nextToken());

            totalCost[i][0] = Math.min(totalCost[i-1][1], totalCost[i-1][2]) + costRed;
            totalCost[i][1] = Math.min(totalCost[i-1][0], totalCost[i-1][2]) + costGreen;
            totalCost[i][2] = Math.min(totalCost[i-1][0], totalCost[i-1][1]) + costBlue;
        }

        System.out.print(Math.min(Math.min(totalCost[N-1][0], totalCost[N-1][1]), totalCost[N-1][2]));
    }
}