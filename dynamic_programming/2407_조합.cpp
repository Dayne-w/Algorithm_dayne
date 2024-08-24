#include <iostream>
#include <algorithm>
#include <string>

#define endl '\n'

using namespace std;

int m, n;

string arr[101][101];


int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    cin >> n >> m;
    
    arr[1][0] = "1";
    arr[1][1] = "1";
    
    for(int i = 2; i <= n; i++){
        for(int j = 0; j <= i; j++){
            if(j == 0 || j == i){
                arr[i][j] = "1";
            }
            else{
                int sum = 0;
                string str1 = arr[i-1][j-1];
                string str2 = arr[i-1][j];
                while(!str1.empty() || !str2.empty() || sum){
                    if(!str1.empty()){
                        sum += str1.back() - '0';
                        str1.pop_back();
                    }
                    
                    if(!str2.empty()){
                        sum += str2.back() - '0';
                        str2.pop_back();
                    }
                    
                    arr[i][j].push_back((sum%10) + '0');
                    sum /= 10;
                }
                reverse(arr[i][j].begin(), arr[i][j].end());
            }
        }
    }
    
    cout << arr[n][m] << endl;
    
    return 0;
}

