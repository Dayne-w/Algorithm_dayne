#include <iostream>
#include <string>
#include <queue>

#define endl '\n'

using namespace std;

int N, M;
string str;
int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, 1, 0, -1};
int maze[100][100] = {0, };
int ans[100][100] = {0, };
bool visited[100][100] = {false, };

void bfs(int x, int y){
    queue<pair<int,int>> q;
    q.push({x, y});
    visited[y][x] = true;
    while(!q.empty()){
        int tempX = q.front().first;
        int tempY = q.front().second;
        visited[tempY][tempX] = true;
        q.pop();
        
        for(int i = 0; i < 4; i++){
            int newX = tempX + dx[i];
            int newY = tempY + dy[i];
            
            if(newX >= 0 && newY >= 0 && newX < M && newY < N){
                if(!visited[newY][newX] && maze[newY][newX] != 0){
                    ans[newY][newX] = ans[tempY][tempX] + 1;
                    visited[newY][newX] = true;
                    q.push(make_pair(newX, newY));
                }
            }
        }
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    cin >> N >> M;
    for(int i = 0; i < N; i++){
        cin >> str;
        for(int j = 0; j < M; j++){
            maze[i][j] = str[j] - '0';
        }
    }
    
    visited[0][0] = true;
    bfs(0, 0);
    
    cout << ans[N-1][M-1]+1 << endl;
    
    return 0;
}
