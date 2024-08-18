#include <iostream>
#include <cmath>

#define endl '\n'

using namespace std;

long long n, q, low, mid, high;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    cin >> n;
    
    low = 0;
    high = sqrt(n);
    
    while(low <= high){
        mid = (low + high) / 2;
        q = mid * mid;
        if(q < n) {
            low = mid + 1;
        }else {
            high = mid - 1;
        }
    }

    cout << low << endl;
    
    return 0;
}
