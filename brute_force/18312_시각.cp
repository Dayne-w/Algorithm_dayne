#include <iostream>

#define endl '\n'

using namespace std;

int N, K, answer = 0;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    cin >> N >> K;
    
    for(int h = 0; h <= N; h++){
        if(h % 10 == K || h / 10 == K){
            answer += 60 * 60;
            continue;
        }
        for(int m = 0; m <= 59; m++){
            if(m % 10 == K || m / 10 == K){
                answer += 60;
                continue;
            }
            for(int s = 0; s <= 59; s++){
                if(s % 10 == K || s / 10 == K) answer ++;
            }
        }
    }
    
    cout << answer << endl;
    
    return 0;
}

