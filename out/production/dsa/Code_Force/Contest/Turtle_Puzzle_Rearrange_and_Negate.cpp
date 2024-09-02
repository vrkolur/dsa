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
    int t;
    cin>>t;
    vector<int> res;
    while(t--){
        int n;
        cin>>n;
        int sum=0;
        while(n--){
            int k;
            cin>>k;
            sum+=abs(k);
        }
        res.push_back(sum);
    }
    for(auto x:res) cout<<x<<"\n";
    return 0;
}