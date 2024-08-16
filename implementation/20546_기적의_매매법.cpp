#include <iostream>

#define endl '\n'

using namespace std;

int seedMoney, bnpStock = 0, timingStock = 0, bnpSeed, timingSeed, up = 0, down = 0;
int price[15] = {0, };

void bnp(int day){
    while(bnpSeed >= price[day]){
        bnpSeed -= price[day];
        bnpStock++;
    }
}

void timing(int day){
    if(day == 1) return;
    
    if(price[day] > price[day-1]){
        up++;
        down = 0;
    }else if(price[day] < price[day-1]){
        down++;
        up = 0;
    }else{
        down = 0;
        up = 0;
    }
    
    if(up == 3){
        while(timingStock != 0){
            timingSeed += price[day];
            timingStock--;
        }
    }
    
    if(down == 3){
        while(timingSeed >= price[day]){
            timingSeed -= price[day];
            timingStock++;
        }
    }
    
    
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    cin >> seedMoney;
    
    bnpSeed = seedMoney;
    timingSeed = seedMoney;
    
    for(int i = 1; i <= 14; i++){
        cin >> price[i];
    }
    
    for(int i = 1; i <= 14; i++){
        bnp(i);
        timing(i);
    }
    
    if((bnpSeed + bnpStock * price[14]) > (timingSeed + timingStock * price[14])){
        cout << "BNP" << endl;
    }else if((bnpSeed + bnpStock * price[14]) < (timingSeed + timingStock * price[14])){
        cout << "TIMING" << endl;
    }else{
        cout << "SAMESAME" << endl;
    }
    
    return 0;
}
