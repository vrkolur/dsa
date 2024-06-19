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

    int t;
    int c1 = 0, c2 = 0;
    string s1, s2;
    string k;
    cin >> t;
    cin>>k;
    s1 = k;
    c1++;
    bool flag = true;
    for (int i = 1; i < t; i++)
    {
        cin >> k;
        if (k != s1 && flag)
        {
            s2 = k;
            c2++;
            flag = false;
        }
        else if (!k.compare(s1))
            c1++;
        else
            c2++;
    }
    if (c1 > c2)
    {
        cout << s1 << "\n";
    }
    else
        cout << s2 << "\n";
    return 0;
}