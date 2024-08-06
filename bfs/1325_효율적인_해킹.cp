#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

#define endl '\n'

using namespace std;

vector<int> adj[10001];
bool visited[10001] = {false, };
int answer[10001];
int N, M, from, to, cnt = 0, maxi = 0;

void bfs(int num){
    queue<int> q;
    q.push(num);
    visited[num] = true;
    
    while(!q.empty()){
        int temp = q.front();
        q.pop();
        for(int i = 0; i < adj[temp].size(); i++){
            if(!visited[adj[temp][i]]){
                q.push(adj[temp][i]);
                visited[adj[temp][i]] = true;
                cnt++;
            }
        }
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    cin >> N >> M;
    
    while(M--){
        cin >> to >> from;
        adj[from].push_back(to);
    }
    
    for(int i = 1; i <= N; i++){
        cnt = 0;
        fill_n(visited, 10001, false);
        
        visited[i] = true;
        
        bfs(i);
        
        answer[i] = cnt;
        
        maxi = max(maxi, cnt);
    }
    
    for(int i = 1; i <= N; i++){
        if(answer[i] == maxi) cout << i << ' ';
    }
    
    return 0;
}

