#include <iostream>
#include <vector>
#include <algorithm>

#define endl '\n'

using namespace std;

int N, tipPrice;
vector<int> tip;
long long answer = 0;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    cin >> N;
    
    while(N--){
        cin >> tipPrice;
        tip.push_back(tipPrice);
    }
    
    sort(tip.begin(), tip.end(), greater<int>());
    
    for(int i = 0; i < tip.size(); i++){
        if(tip[i] - ((i+1) - 1) > 0){
            answer += tip[i] - ((i+1) - 1);
        }
    }
    
    cout << answer << endl;
    
    return 0;
}
