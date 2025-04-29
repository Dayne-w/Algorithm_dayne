import java.util.*;

class Solution {

    public int answer = 0;
    public ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    public boolean[] visited = new boolean[200];

    public int solution(int n, int[][] computers) {
        // 인접 리스트 초기화
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // 인접리스트 구성
        for(int i = 0; i < computers.length; i++) {
            for(int j = 0; j < computers[i].length; j++) {
                if(i == j) continue;
                if(computers[i][j] == 1) {
                    adj.get(i).add(j);
                }
            }
        }

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                answer++;
                BFS(i);
            }
        }

        return answer;
    }

    public void BFS(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = true;
        while(!q.isEmpty()) {
            int cur = q.remove();
            for(int next : adj.get(cur)) {
                if(!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }
}