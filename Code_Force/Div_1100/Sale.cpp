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

int main()
{

    int n, m;
    cin >> n >> m;
    vector<int> a;
    for (int i = 0; i < n; i++)
    {
        int k;
        cin >> k;
        a.push_back(k);
    }
    sort(a.begin(), a.end());
    int sum = 0;
    for (int i = 0; i < m; i++)
        if(a[i]<0) sum+=abs(a[i]);
    cout << sum;
    return 0;
}