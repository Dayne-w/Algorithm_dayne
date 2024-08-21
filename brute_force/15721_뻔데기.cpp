#include <iostream>
#include <queue>

#define endl '\n'

using namespace std;

int A, T, C, bb = 1, dg = 1, l = 2, temp, answer = -1;
queue<int> q;

int main(){
    cin >> A >> T >> C;
    
    for(int i = 0; i < A; i++){
        q.push(i);
    }
    
    if(C == 0){
        while(true){
            for(int i = 0; i < 2; i++){
                if(bb++ == T){
                    answer = q.front();
                    break;
                }
                
                temp = q.front();
                q.pop();
                q.push(temp);
                
                dg++;
                
                temp = q.front();
                q.pop();
                q.push(temp);
            }
            
            if(answer != -1){
                break;
            }
            
            for(int i = 0; i < l; i++){
                if(bb++ == T){
                    answer = q.front();
                    break;
                }
                
                temp = q.front();
                q.pop();
                q.push(temp);
            }
            
            if(answer != -1){
                break;
            }
            
            for(int i = 0; i < l; i++){
                dg++;
                
                temp = q.front();
                q.pop();
                q.push(temp);
            }
            l++;
        }
    }else{
        while(true){
            for(int i = 0; i < 2; i++){
                bb++;
                
                temp = q.front();
                q.pop();
                q.push(temp);
                
                if(dg++ == T){
                    answer = q.front();
                    break;
                }
                
                temp = q.front();
                q.pop();
                q.push(temp);
            }
            
            if(answer != -1){
                break;
            }

            for(int i = 0; i < l; i++){
                bb++;
                
                temp = q.front();
                q.pop();
                q.push(temp);
            }
            
            for(int i = 0; i < l; i++){
                if(dg++ == T){
                    answer = q.front();
                    break;
                }
                
                temp = q.front();
                q.pop();
                q.push(temp);
            }
            
            if(answer != -1){
                break;
            }
            l++;
        }
    }
    
    cout << answer << endl;
}
