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

    string n, s;
    cin >> n >> s;
    int a[26];
    for (auto &c : s)
        c = tolower(c);
    for (int i = 0; i < s.length(); i++)
    {
        char ch = s[i];
        a[ch - 97]++;
    }
    bool flag = true;
    for (auto it : a)
        if (it == 0)
        {
            flag = false;
        }
    if (flag)
        cout << "YES\n";
    else
        cout << "NO\n";
    // return 0;
}