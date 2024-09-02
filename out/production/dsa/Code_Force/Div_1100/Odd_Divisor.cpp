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
using ll=long long;
using namespace std;

void solve(){
    ll n;
    cin>>n;
    if(n&(n-1))
        cout<<"YES\n";
    else
        cout<<"NO\n";
}

int main(){
    int t;
    cin>>t;
    while(t--) solve();
    return 0;
}