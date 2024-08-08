#include <iostream>

#define endl '\n'

using namespace std;

int N, num, pos, answer;
pair<int, int> arr[11];

void check(int num, int pos){
    if(arr[num].first == 0){
        arr[num] = make_pair(num, pos);
    }else{
        if(arr[num].second != pos){
            arr[num] = make_pair(num, pos);
            answer++;
        }
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    for(int i = 0; i < 11; i++){
        arr[i] = make_pair(0,0);
    }
    
    cin >> N;
    
    while(N--){
        cin >> num >> pos;
        check(num, pos);
    }
    
    cout << answer << endl;
    
    return 0;
    
}
