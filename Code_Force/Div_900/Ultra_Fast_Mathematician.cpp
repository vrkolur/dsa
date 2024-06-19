#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <sstream>
#include <queue>
#include <deque>
#include <bitset>
#include <iterator>
#include <list>
#include <stack>
#include <map>
#include <set>
#include <functional>
#include <numeric>
#include <utility>
#include <limits>
#include <time.h>
#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>

using namespace std;

int main(){

    string s1,s2;
    cin>>s1>>s2;
    for(int i=0;i<s1.length();i++){
        if(s1[i]!=s2[i])
            cout<<1;
        else    
            cout<<0;
    }
    cout<<"\n";
    return 0;
}