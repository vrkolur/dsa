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

int main(){

    ll n,k;
    cin>>n;
    if(n%2==0){
        k=n/2;
        cout<<k;
    }else{
        k=n/2+1;
        cout<<"-"<<k;
    }
    return 0;
}