#include <iostream>
#include <vector>
#include <algorithm>

#define endl '\n'

using namespace std;

int N, M, num;
vector<int> card;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    cin >> N;
    
    for(int i = 0; i < N; i++){
        cin >> num;
        card.push_back(num);
    }
    
    sort(card.begin(), card.end());
    
    cin >> M;
    
    while(M--){
        cin >> num;
        
        cout << binary_search(card.begin(), card.end(), num) << ' ';
    }
    
    return 0;
}
