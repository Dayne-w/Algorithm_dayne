#include <iostream>
#include <string>
#include <algorithm>
#include <vector>

#define endl '\n'

using namespace std;

vector<int> v;
int K, temp;
string N, answer, str;

void dfs(int length, string num){
    if(num.length() == length){
        if(stoi(num) <= stoi(N)){
            answer = num;
        }
        return;
    }
    
    for(int i = 0; i < K; i++){
        num += to_string(v[i]);
        dfs(length, num);
        num.erase((int)num.length()-1, 1);
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    cin >> N >> K;
    
    for(int i = 0; i < K; i++){
        cin >> temp;
        v.push_back(temp);
    }
    
    sort(v.begin(), v.end());
    
    for(int i = 1; i <= N.length(); i++){
        dfs(i, str);
        str = "";
    }
    
    cout << answer << endl;
    
    return 0;
}
