#include <iostream>
#include <queue>

#define endl '\n'

using namespace std;

int N, M, startX, startY;
int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, -1, 0, 1};
int bfsArr[1000][1000] = {0, };
int answerArr[1000][1000] = {0, };
bool visited[1000][1000] = {false, };

void bfs(int x, int y){
    queue<pair<int,int>> q;
    q.push(make_pair(x,y));
    while(!q.empty()){
        int tempX = q.front().first;
        int tempY = q.front().second;
        visited[tempY][tempX] = true;
        q.pop();
        for(int i = 0; i < 4; i++){
            int newX = tempX + dx[i];
            int newY = tempY + dy[i];
            
            if(newX < 0 || newY < 0 || newX >= M || newY >= N){
                continue;
            }else{
                if(!visited[newY][newX] && bfsArr[newY][newX] != 0){
                    answerArr[newY][newX] = answerArr[tempY][tempX] + 1;
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
        for(int j = 0; j < M; j++){
            cin >> bfsArr[i][j];
            if(bfsArr[i][j] == 2){
                startX = j;
                startY = i;
            }
        }
    }
    
    visited[startY][startX] = true;
    
    bfs(startX,startY);
    
    for(int i = 0; i < N; i++){
        for(int j = 0; j < M; j++){
            if(bfsArr[i][j] == 1 && !visited[i][j]){
                cout << -1 << ' ';
            }else{
                cout << answerArr[i][j] << ' ';
            }
        }
        cout << endl;
    }
    
    return 0;
}
