#include <iostream>

#define endl '\n'

using namespace std;

int N, M, ice1, ice2, answer = 0;
bool check[201][201];

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    cin >> N >> M;
    
    while(M--){
        cin >> ice1 >> ice2;
        check[ice1][ice2] = true;
        check[ice2][ice1] = true;
    }
    
    for(int i = 1; i <= N; i++){
        for(int j = i+1; j <= N; j++){
            if(!check[i][j]){
                for(int k = j+1; k <= N; k++){
                    if (check[i][k] || check[j][k]) continue;
                    answer++;
                }
            }
        }
    }
    
    cout << answer << endl;
    
    return 0;
}
