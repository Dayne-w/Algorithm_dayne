#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

#define endl '\n'

using namespace std;

int T, N, M, priori;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    cin >> T;
    
    while(T--)
    {
        int cnt = 0;
        vector<int> high;
        queue<pair<int, int>> q;
        cin >> N >> M;
        for(int i = 0; i < N; i++)
        {
            cin >> priori;
            high.push_back(priori);
            q.push({priori, i});
        }
        
        sort(high.begin(), high.end(), greater<>());
        
        while(!q.empty()){
            if(q.front().first == high[0]){
                if(q.front().second == M){
                    cout << cnt + 1 << endl;
                    break;
                }else{
                    q.pop();
                    cnt++;
                }
                high.erase(high.begin());
            }else{
                pair<int, int> temp = q.front();
                q.pop();
                q.push(temp);
            }
        }
    }
}
