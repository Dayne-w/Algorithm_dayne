#include <iostream>

#define endl '\n'

using namespace std;

int T, N, M;
int arr[31][31] = {0, };

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    for(int i = 1; i <= 30; i++){
        arr[1][i] = i;
    }
    
    for(int i = 2; i <= 30; i++){
        for(int j = i; j <= 30; j++){
            for(int k = j-1; k >= 1; k--){
                arr[i][j] += arr[i-1][k];
            }
        }
    }
    
    cin >> T;
    
    while(T--){
        cin >> N >> M;
        
        cout << arr[N][M] << endl;
    }
    
    return 0;
}
