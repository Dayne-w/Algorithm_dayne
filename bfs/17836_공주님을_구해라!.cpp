#include <iostream>
#include <queue>

#define endl '\n'

using namespace std;

int N, M, T;
pair<int, int> sword;
int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, -1, 0, 1};
int castle[100][100] = {0, };
int answer[100][100] = {0, };
bool visited[100][100] = {0, };
int answer1 = 999999, answer2 = 999999;

void bfs(int x, int y){
    queue<pair<int,int>> q;
    q.push({x,y});
    visited[y][x] = true;
    while(!q.empty()){
        int tempX = q.front().first;
        int tempY = q.front().second;
        q.pop();
        for(int i = 0; i < 4; i++){
            int newX = tempX + dx[i];
            int newY = tempY + dy[i];
            
            if(newX >= 0 && newY >= 0 && newX < M && newY < N){
                if(!visited[newY][newX] && castle[newY][newX] != 1){
                    answer[newY][newX] = answer[tempY][tempX] + 1;
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
    
    cin>> N >> M >> T;
    
    for(int i = 0; i < N; i++){
        for(int j = 0; j < M; j++){
            cin >> castle[i][j];
            if(castle[i][j] == 2){
                sword = make_pair(j, i);
            }
        }
    }
    
    bfs(0,0);
    
    if(answer[N-1][M-1] != 0){
        answer1 = answer[N-1][M-1];
    }
    
    if(answer[sword.second][sword.first] != 0){
        answer2 = answer[sword.second][sword.first] + ((M-1) - sword.first) + ((N-1) - sword.second);
    }
    
    if(answer1 <= T && answer2 <= T){
        cout << min(answer1, answer2) << endl;
    }else if(answer1 <= T){
        cout << answer1 << endl;
    }else if(answer2 <= T){
        cout << answer2 << endl;
    }else{
        cout << "Fail" << endl;
    }
    
    return 0;
}
