#include <iostream>
#include <algorithm>
#include <vector>

#define endl '\n'

using namespace std;

vector<int> adj[10001];
bool visited[10001] = {false, };
int answer[10001];
int N, M, from, to, cnt = 0, maxi = 0;

void dfs(int num){
    cnt++;
    for(int i = 0; i < adj[num].size(); i++){
        int temp = adj[num][i];
        if(visited[temp] == false){
            visited[temp] = true;
            dfs(temp);
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
        
        dfs(i);
        
        answer[i] = cnt;
        
        maxi = max(maxi, cnt);
    }
    
    for(int i = 1; i <= N; i++){
        if(answer[i] == maxi) cout << i << ' ';
    }
    
    return 0;
}


