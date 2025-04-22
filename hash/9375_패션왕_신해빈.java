import java.util.*;
import java.io.*;

public class Main {

    static int T, N;
    static HashMap<String, Integer> m = new HashMap<>();
    static StringBuilder answerSB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            int cnt = 1;
            m.clear();
            N = Integer.parseInt(br.readLine());

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                String value = st.nextToken();
                String key = st.nextToken();

                m.put(key, m.getOrDefault(key, 0) + 1); // key에 대한 개수를 map으로 관리
            }

            for(String key : m.keySet()) {
                cnt *= (m.get(key) + 1);    // 각각의 카테고리에 대해 NULL(선택하지 않음) 경우도 추가해서 계산 headgear : sunglasses, NULL
            }

            answerSB.append(cnt-1).append('\n');    // NULL만 선택되었을 경우를 제외
        }

        System.out.print(answerSB.toString());
    }
}