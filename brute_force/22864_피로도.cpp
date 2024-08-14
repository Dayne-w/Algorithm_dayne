#include <iostream>

#define endl '\n'

using namespace std;

int A, B, C, M, tired = 0, h = 0, answer = 0;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    cin >> A >> B >> C >> M;
    
    while(h++ < 24){
        if(tired + A <= M){
            tired += A;
            answer += B;
        }else{
            tired = tired - C < 0 ? 0 : tired - C;
        }
    }
    
    cout << answer << endl;
    
    return 0;
}
