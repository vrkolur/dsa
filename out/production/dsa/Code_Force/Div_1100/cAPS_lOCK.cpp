#include<iostream>
using namespace std;

int main(){
    string s;
    char c;
    bool flag=true;
    cin>>s;
    for(int i=1;i<s.length();i++){
        if(islower(s[i])){
            flag=false;
        }
    }
    if(flag){
        for(int i=0;i<s.length();i++){
            if(islower(s[i])){
                c=toupper(s[i]);
            }
            else 
                c=tolower(s[i]);
            cout<<c;
        }
    }
    else 
        cout<<s;
    return 0;
}