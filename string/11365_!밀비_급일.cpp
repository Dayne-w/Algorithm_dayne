#include <iostream>
#include <string>
#include <algorithm>

#define endl '\n'

using namespace std;

string secretCode;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    while(true){
        getline(cin, secretCode);
        if(secretCode == "END"){
            break;
        }else{
            reverse(secretCode.begin(), secretCode.end());
            cout << secretCode << '\n';
        }
    }
    
    return 0;
}

