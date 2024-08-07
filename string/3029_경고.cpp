#include <iostream>
#include <string>

#define endl '\n'

using namespace std;

int nowTotalSec = 0, throwingTotalSec = 0;
int nowHH, nowMM, nowSS, throwingHH, throwingMM, throwingSS;
char ch;
string hh, mm, ss;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    cin >> nowHH >> ch >> nowMM >> ch >> nowSS;
    cin >> throwingHH >> ch >> throwingMM >> ch >> throwingSS;
    
    nowTotalSec += nowHH * 60 * 60;
    nowTotalSec += nowMM * 60;
    nowTotalSec += nowSS;
    
    throwingTotalSec += throwingHH * 60 * 60;
    throwingTotalSec += throwingMM * 60;
    throwingTotalSec += throwingSS;
    
    if(nowTotalSec >= throwingTotalSec){
        throwingTotalSec += 24 * 60 * 60;
    }
    
    throwingTotalSec -= nowTotalSec;
    
    ss = to_string(throwingTotalSec % 60);
    if(ss.length() == 1) ss.insert(0,"0");
    
    throwingTotalSec /= 60;
    
    mm = to_string(throwingTotalSec % 60);
    if(mm.length() == 1) mm.insert(0,"0");
    
    throwingTotalSec /= 60;
    
    hh = to_string(throwingTotalSec);
    if(hh.length() == 1) hh.insert(0,"0");
    
    cout << hh << ":" << mm << ":" << ss;
    
    return 0;
}
