import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int M;
    static int K = 0;   // 가문의 개수 = 초기에 indegree == 0인 것의 개수

    static TreeMap<String, Integer> string2IdxMap = new TreeMap<>();
    static TreeMap<Integer, String> idx2StringMap = new TreeMap<>();

    static int[] indegree = new int[1001];
    static ArrayList<Integer>[] adj = new ArrayList[1001];
    static Queue<Integer> q = new LinkedList<>();

    static TreeMap<String, TreeSet<String>> childMap = new TreeMap<>();
    static TreeSet<String> kSet = new TreeSet<>();

    static StringBuilder answerSB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 위상 정렬에 사용할 adj 초기화
        for(int i = 0; i < 1001; i++) {
            adj[i] = new ArrayList<>();
        }

        // 등장하는 이름들 입력 받고, 이름과 인덱스를 매핑
        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            String name = st.nextToken();
            string2IdxMap.put(name, i);
            idx2StringMap.put(i, name);
            childMap.put(name, new TreeSet<>());
        }

        // 연결관계 구성 && 위상 정렬에 사용할 indegree 구성
        M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String to = st.nextToken();
            String from = st.nextToken();
            indegree[string2IdxMap.get(to)]++;
            adj[string2IdxMap.get(from)].add(string2IdxMap.get(to));
        }

        // 초기에 indegree[i]기 0인 것이 시조를 의미 == 가문의 수를 의미
        for(int i = 0; i < N; i++) {
            if(indegree[i] == 0) {
                q.add(i);
                kSet.add(idx2StringMap.get(i));
                K++;
            }
        }

        // 시조들의 이름을 사전 순으로 출력
        for(String s : kSet) {
            answerSB.append(s).append(" ");
        }
        answerSB.append('\n');

        // 위상 정렬 수행. childMap에 자신의 자식들을 저장
        while(!q.isEmpty()) {
            int cur = q.remove();
            for(int nxt : adj[cur]) {
                indegree[nxt]--;
                if(indegree[nxt] == 0) {
                    q.add(nxt);
                    TreeSet<String> tempSet = childMap.get(idx2StringMap.get(cur));
                    tempSet.add(idx2StringMap.get(nxt));
                    childMap.put(idx2StringMap.get(cur), tempSet);
                }
            }
        }

        // 자신의 자식들의 수와, 자식들의 이름들을 출력
        for(Map.Entry<String, TreeSet<String>> e : childMap.entrySet()) {
            answerSB.append(e.getKey()).append(" ");
            TreeSet<String> tempSet = e.getValue();
            answerSB.append(tempSet.size()).append(" ");
            if(!tempSet.isEmpty()) {
                for(String s : tempSet) {
                    answerSB.append(s).append(" ");
                }
            }
            answerSB.append('\n');
        }

        System.out.println(K);
        System.out.print(answerSB.toString());
    }
}