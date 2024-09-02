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
    int n;
    cin >> n;
    int count = 0, l4 = 0, l7 = 0;
    while (n != 0)
    {
        int rem = n % 10;
        if (rem == 4)
            l4++;
        else if (rem == 7)
            l7++;
        count++;
        n /= 10;
    }

    if (l4 > 0 && l7 > 0)
    {
        int total = l4 + l7;
        if (total == count || total == 4 || total == 7)
            cout << "YES\n";
    }
    cout << "NO\n";
    return 0;
}