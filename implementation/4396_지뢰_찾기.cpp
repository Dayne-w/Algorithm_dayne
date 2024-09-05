#include <iostream>

#define endl '\n'

using namespace std;

int N;
int dx[8] = {-1, 0, 1, 1, 1, 0, -1, -1};
int dy[8] = {-1, -1, -1, 0, 1, 1, 1, 0};
int answerBoard[10][10] = {0, };
char realBoard[10][10], nowBoard[10][10];
bool check;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    cin >> N;
    
    for(int i = 0; i < N; i++){
        for(int j = 0; j < N; j++){
            cin >> realBoard[i][j];
        }
    }
    
    for(int i = 0; i < N; i++){
        for(int j = 0; j < N; j++){
            cin >> nowBoard[i][j];
        }
    }
    
    for(int i = 0; i < N; i++){
        for(int j = 0; j < N; j++){
            if(realBoard[i][j] == '*'){
                if(nowBoard[i][j] == 'x') check = true;
                for(int k = 0; k < 8; k++){
                    int newX = j + dx[k];
                    int newY = i + dy[k];
                    
                    if(newX >= 0 && newY >= 0 && newX < N && newY < N){
                        if(realBoard[newY][newX] != '*'){
                            answerBoard[newY][newX]++;
                        }
                    }
                }
            }
        }
    }
    
    if(check){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(realBoard[i][j] == '*'){
                    cout << realBoard[i][j];
                }else{
                    if(nowBoard[i][j] == 'x'){
                        cout << answerBoard[i][j];
                    }else{
                        cout << ".";
                    }
                }
            }
            cout << endl;
        }
    }else{
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(nowBoard[i][j] == 'x'){
                    cout << answerBoard[i][j];
                }else{
                    cout << ".";
                }
            }
            cout << endl;
        }
    }
    
    return 0;
}
