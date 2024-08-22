#include <iostream>

#define endl '\n'

using namespace std;

int N, studentNum, s, cardNum;
bool stat[101] = {false, };

void change(int s, int cardNum){
    if(s == 1){ // 남자일 때
        for(int i = cardNum; i <= N; i += cardNum){
            stat[i] = stat[i] == 1 ? 0 : 1;
        }
    }else{  // 여자일 때
        int l = cardNum-1;
        int r = cardNum+1;
        
        stat[cardNum] = stat[cardNum] == 1 ? 0 : 1;
        
        while(l != 0 && r != N+1){
            if(stat[l] == stat[r]){
                stat[l] = stat[l] == 1 ? 0 : 1;
                stat[r] = stat[r] == 1 ? 0 : 1;
                l--;
                r++;
            }else{
                break;
            }
        }
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    cin >> N;
    
    for(int i = 1; i <= N; i++){
        cin >> stat[i];
    }
    
    cin >> studentNum;
    
    for(int i = 0; i < studentNum; i++){
        cin >> s >> cardNum;
        change(s, cardNum);
    }
    
    for(int i = 1; i <= N; i++){
        cout << stat[i] << ' ';
        if(i % 20 == 0){
            cout << endl;
        }
    }
    
    return 0;
}
