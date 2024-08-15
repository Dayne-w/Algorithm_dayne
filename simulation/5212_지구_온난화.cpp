#include <iostream>
#include <vector>
#include <string>

#define endl '\n'

using namespace std;

int R, C;
char islandMap[10][10];
vector<pair<int, int>> v, temp;
int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, -1, 0, 1};

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int left = 0, right = 0, top = 0, down = 0;
    
    cin >> R >> C;
    
    for(int i = 0; i < R; i++)
    {
        string str;
        cin >> str;
        for(int j = 0; j < str.length(); j++)
        {
            islandMap[i][j] = str[j];
            if(islandMap[i][j] == 'X')
            {
                v.push_back({j, i});
            }
        }
    }
    
    for(int i = 0; i < v.size(); i++){
        int cnt = 0;
        for(int j = 0; j < 4; j++){
            int newX = v[i].first + dx[j];
            int newY = v[i].second + dy[j];
            if(newX >= 0 && newY >= 0 && newX < C && newY < R){
                if(islandMap[newY][newX] == '.') cnt++;
            }else{
                cnt++;
            }
        }
        
        if(cnt >= 3) temp.push_back({v[i].first, v[i].second});
    }
    
    for(int i = 0; i < temp.size(); i++){
        islandMap[temp[i].second][temp[i].first] = '.';
    }
    
    for(int i = 0; i < R; i++){
        bool check = false;
        for(int j = 0; j < C; j++){
            if(islandMap[i][j] == 'X'){
                check = true;
                break;
            }
        }
        if(!check){
            continue;
        }else{
            down = i;
            break;
        }
    }
    
    for(int i = R-1; i >= 0; i--){
        bool check = false;
        for(int j = 0; j < C; j++){
            if(islandMap[i][j] == 'X'){
                check = true;
                break;
            }
        }
        if(!check){
            continue;
        }else{
            top = i;
            break;
        }
    }
    
    for(int i = 0; i < C; i++){
        bool check = false;
        for(int j = 0; j < R; j++){
            if(islandMap[j][i] == 'X'){
                check = true;
                break;
            }
        }
        if(!check){
            continue;
        }else{
            left = i;
            break;
        }
    }
    
    for(int i = C-1; i >= 0; i--){
        bool check = false;
        for(int j = 0; j < R; j++){
            if(islandMap[j][i] == 'X'){
                check = true;
                break;
            }
        }
        if(!check){
            continue;
        }else{
            right = i;
            break;
        }
    }
    
    for(int i = down; i <= top; i++){
        for(int j = left; j <= right; j++){
            cout << islandMap[i][j];
        }
        cout << endl;
    }
    
    return 0;
}
