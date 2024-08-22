#include <iostream>
#include <vector>
#include <algorithm>

#define endl '\n'

using namespace std;

long long N, num, M = 0;
vector<long long> v;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    cin >> N;
    
    for(int i = 0; i < N; i++)
    {
        cin >> num;
        v.push_back(num);
    }
    
    sort(v.begin(), v.end());
    
    if(N%2 == 0)
    {
        for(int i = 0; i < N/2; i++)
        {
            M = max(M, (v[i] + v[N-1-i]));
        }
    }else
    {
        M = v[N-1];
        for(int i = 0; i < N/2; i++){
            M = max(M, (v[i] + v[N-2-i]));
        }
    }
     
    cout << M << endl;
    
    return 0;
}
