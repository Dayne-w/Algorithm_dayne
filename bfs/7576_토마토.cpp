#include <iostream>
#include <queue>
#include <vector>

#define endl '\n'

using namespace std;

int M, N, day = 0;
int board[1000][1000] = {0, };
int dx[4] = {-1, 0, 1 ,0};
int dy[4] = {0, -1, 0 ,1};
bool visited[1000][1000];
queue<pair<int,int>> pq, nq;
bool zeroCheck;

void bfs(){
    while(!pq.empty()){
        while(!pq.empty()){
            int tempX = pq.front().first;
            int tempY = pq.front().second;
            pq.pop();
            for(int j = 0; j < 4; j++){
                int newX = tempX + dx[j];
                int newY = tempY + dy[j];
                
                if(newX >= 0 && newY >= 0 && newX < M && newY < N){
                    if(!visited[newY][newX] && board[newY][newX] != -1){
                        nq.push({newX, newY});
                        visited[newY][newX] = true;
                    }
                }
            }
        }
        pq.swap(nq);
        day++;
    }
}

bool check(){
    for(int i = 0; i < N; i++){
        for(int j = 0; j < M; j++){
            if(board[i][j] == 0 && visited[i][j] == false){
                return true;
            }
        }
    }
    
    return false;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    cin >> M >> N;
    
    for(int i = 0; i < N; i++){
        for(int j = 0; j < M; j++){
            cin >> board[i][j];
            if(board[i][j] == 0) zeroCheck = true;
            if(board[i][j] == 1){
                pq.push({j, i});
                visited[i][j] = true;
            }
        }
    }
    
    if(!zeroCheck){
        cout << 0 << endl;
    }else{
        bfs();
        
        if(check()){
            cout << -1 << endl;
        }else{
            cout << day-1 << endl;
        }
    }

    
    return 0;
}
