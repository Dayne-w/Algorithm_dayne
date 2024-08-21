#include <iostream>
#include <vector>
#include <algorithm>

#define endl '/n'

using namespace std;

int N, R, num, idx = 0, cnt = 0;
pair<int, int> mini = {1001,101};
pair<int, int> students[101];
vector<int> answer;

bool comp(pair<int,int> p1, pair<int,int> p2){
    return p1 < p2;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    cin >> N >> R;

    for(int i = 0; i < R; i++){
        
        cin >> num;
        
        if(cnt == N){
            if(students[num].first == 0 && students[num].second == 0){
                for(int i = 1; i < 101; i++){
                    if(students[i].first != 0){
                        if(comp(students[i], mini)){
                            mini = students[i];
                            idx = i;
                        }
                    }
                }
                
                students[idx] = {0,0};
                
                students[num] = {1, i};
                
                mini = {1001,101};
                idx = 0;
            }else{
                students[num].first++;
            }
        }else{
            if(students[num].first == 0 && students[num].second == 0){
                students[num] = make_pair(1, i);
                cnt++;
            }else{
                students[num].first++;
            }
        }
    }
    
    for(int i = 1; i < 101; i++){
        if(students[i].first != 0){
            answer.push_back(i);
        }
    }
    
    sort(answer.begin(), answer.end());
    
    for(int n : answer){
        cout << n << ' ';
    }
    
    return 0;
}
