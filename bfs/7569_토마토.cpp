#include <iostream>
#include <queue>
#include <vector>
#include <tuple>

#define endl '\n'

using namespace std;

int M, N, H, day = 0;
int board[100][100][100] = {0, };
int dx[6] = {-1, 0, 1 ,0, 0, 0};
int dy[6] = {0, -1, 0 , 1, 0, 0};
int dz[6] ={0, 0, 0, 0, -1, 1};
queue<tuple<int, int, int>> q;

void bfs(){
    while(!q.empty()){
        int x = get<0>(q.front());
        int y = get<1>(q.front());
        int z = get<2>(q.front());
        q.pop();
        for(int i = 0; i < 6; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];
            int newZ = z + dz[i];
            if(newX >= 0 && newY >= 0 && newZ >= 0 && newX < M && newY < N && newZ < H){
                if(board[newZ][newY][newX] == 0){
                    board[newZ][newY][newX] = board[z][y][x] + 1;
                    q.push({newX, newY, newZ});
                }
            }
        }
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    cin >> M >> N >> H;
    
    for(int i = 0; i < H; i++){
        for(int j = 0; j < N; j++){
            for(int k = 0; k < M; k++){
                cin >> board[i][j][k];
                if(board[i][j][k] == 1){
                    q.push({k, j, i});
                }
            }
        }
    }
    
    bfs();
    
    for(int i = 0; i < H; i++){
        for(int j = 0; j < N; j++){
            for(int k = 0; k < M; k++){
                if(board[i][j][k] == 0){
                    cout << -1 << endl;
                    return 0;
                }
                
                if(day < board[i][j][k]) day = board[i][j][k];
            }
        }
    }
    
    cout << day - 1 << endl;
    
    return 0;
}
