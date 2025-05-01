import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static HashMap<String, TreeSet<String>> teamMap = new HashMap<>();
    static HashMap<String, String> memberMap = new HashMap<>();
    static StringBuilder answerSB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            String teamName = br.readLine();
            teamMap.put(teamName, new TreeSet<>());
            int cnt = Integer.parseInt(br.readLine());
            for(int j = 0; j < cnt; j++) {
                String memberName = br.readLine();
                memberMap.put(memberName, teamName);

                TreeSet<String> tempSet = teamMap.get(teamName);
                tempSet.add(memberName);
                teamMap.put(teamName, tempSet);
            }
        }

        for(int i = 0; i < M; i++) {
            String name = br.readLine();
            int quiz = Integer.parseInt(br.readLine());
            if(quiz == 0) {
                for(String memberName : teamMap.get(name)) {
                    answerSB.append(memberName).append('\n');
                }
            }
            if(quiz == 1) {
                answerSB.append(memberMap.get(name)).append('\n');
            }
        }

        System.out.print(answerSB.toString());
    }
}