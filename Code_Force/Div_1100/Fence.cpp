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
using ll = long long;
using namespace std;

int main()
{
    int n, k;
    cin >> n >> k;
    vector<int> a;
    for (int i = 0; i < n; i++)
    {
        int it;
        cin >> it;
        a.push_back(it);
    }
    ll sum = 0;
    int res;
    if (n == k)
    {
        cout<<1;
        return 0;
    }
    else
    {
        for (int i = 0; i < k; i++)
            sum += a[i];
        int maxsum = sum;
        int i = 0, j = k - 1;
        while (j < n - 1)
        {
            j++;
            sum += a[j];
            sum -= a[i];
            i++;
            if (sum <= maxsum)
            {
                res = i + 1;
                maxsum=sum;
            }
        }
    }
    cout << res<<"\n";
    return 0;
}