#include <iostream>
#include <string>
#include <algorithm>

#define endl '\n'

using namespace std;

int N, M, answerHD = 0;
string dnaArr[1000];
string answerDNA;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    cin >> N >> M;
    
    for(int i = 0; i < N; i++){
        cin >> dnaArr[i];
    }
    
    sort(dnaArr, dnaArr + N);
    
    for(int i = 0; i < M; i++){
        int alphabet[26] = {0, };
        int maxAlphabet = 0, idx = 0;
        
        for(int j = 0; j < N; j++){
            alphabet[dnaArr[j][i] - 'A']++;
        }
        
        for(int j = 0; j < 26; j++){
            if(maxAlphabet < alphabet[j]){
                maxAlphabet = alphabet[j];
                idx = j;
            }
        }
        
        answerDNA += (idx + 'A');
        
        for(int j = 0; j < 26; j++){
            if(alphabet[j] != 0 && j != idx){
                answerHD += alphabet[j];
            }
        }
    }
    
    cout << answerDNA << endl << answerHD << endl;
    
    return 0;
    
}

