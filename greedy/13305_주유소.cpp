#include <iostream>
#include <vector>
#include <algorithm>

#define endl '\n'

using namespace std;

int N, temp;
long long mini, answer;
vector<int> oilPrice, cityDistance;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    cin >> N;
    
    for(int i = 0; i < N-1; i++){
        cin >> temp;
        cityDistance.push_back(temp);
    }
    
    for(int i = 0; i < N; i++){
        cin >> temp;
        oilPrice.push_back(temp);
    }
    
    mini = oilPrice[0];
    answer += mini * cityDistance[0];
    
    for(int i = 1; i < N-1; i++){
        if(oilPrice[i] < mini){
            mini = oilPrice[i];
        }
        answer += mini * cityDistance[i];
    }
    
    cout << answer << endl;
    
    return 0;
}

