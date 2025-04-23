import java.util.*;
import java.io.*;

public class Main {

    static int N, Q;
    static int idx = 1; // 도현 위치
    static TreeSet<Integer> hotPlaceSet = new TreeSet<>();
    static StringBuilder answerSB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if(n == 1) hotPlaceSet.add(i);
        }

        while(Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            if(command == 1) {
                int i = Integer.parseInt(st.nextToken());
                if(hotPlaceSet.contains(i)) {
                    hotPlaceSet.remove(i);
                }else {
                    hotPlaceSet.add(i);
                }
            }else if(command == 2) {
                int x = Integer.parseInt(st.nextToken());
                // 시계 방향으로 돌다가, 마지막 점이면 다시 처음으로 돌아와야 함
                if((idx+x) % N  == 0) {
                    idx = N;
                }else {
                    idx = (idx+x) % N;
                }
            }else {
                // hotPlaceSet에서 본인보다 같거나 큰 수를 찾아야 함
                if(hotPlaceSet.isEmpty()) {
                    answerSB.append("-1").append('\n');
                    continue;
                }
                Integer target = hotPlaceSet.ceiling(idx);
                if(target == null) {
                    answerSB.append(N - idx + hotPlaceSet.first()).append('\n'); //전체 위치 - 현재 위치 + treeSet의 첫 번째 원소
                }else {
                    answerSB.append(target - idx).append('\n');
                }
            }
        }

        System.out.print(answerSB.toString());
    }
}