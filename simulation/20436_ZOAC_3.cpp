#include <iostream>
#include <string>
#include <cmath>

#define endl '\n'

using namespace std;

char sl, sr;
string str;
pair<int, int> lPoint, rPoint;
int answer = 0;
char keyboard[3][10] = {
    {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'},
    {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', '0'},
    {'z', 'x', 'c', 'v', 'b', 'n', 'm', '0', '0', '0'}
};

pair<int,int> findPoint(char ch){
    int i, j;
    bool sameCheck = 0;
    for(i = 0; i < 3; i++){
        for(j = 0; j < 10; j++){
            if(ch == keyboard[i][j]){
                sameCheck = true;
                break;
            }
        }
        if(sameCheck) break;
    }
    return make_pair(j, i);
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    cin >> sl >> sr >> str;
    
    lPoint = findPoint(sl);
    rPoint = findPoint(sr);
    
    for(int i = 0; i < str.length(); i++){
        answer++;
        
        pair<int,int> temp = findPoint(str[i]);
        
        if((temp.first < 5 && temp.second == 0) || (temp.first < 5 && temp.second == 1) || (temp.first < 4 && temp.second == 2)){
            answer += abs(lPoint.first - temp.first) + abs(lPoint.second - temp.second);
            lPoint = temp;
        }else{
            answer += abs(rPoint.first - temp.first) + abs(rPoint.second - temp.second);
            rPoint = temp;
        }
    }
    
    cout << answer << endl;
    
    return 0;
}
