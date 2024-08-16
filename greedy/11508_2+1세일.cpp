#include <iostream>
#include <vector>
#include <algorithm>

#define endl '\n'

using namespace std;

int N, price, answer = 0;
vector<int> C;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    cin >> N;
    
    for(int i = 0; i < N; i++){
        cin >> price;
        C.push_back(price);
    }
    
    sort(C.begin(), C.end(), greater<>());
    
    for(int i = 0; i < N; i++){
        if(i%3 != 2){
            answer += C[i];
        }
    }
    
    cout << answer << endl;
    
    return 0;
}
