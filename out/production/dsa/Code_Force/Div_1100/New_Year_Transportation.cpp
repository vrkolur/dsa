#include <cstring>
#include <vector>
#include <list>
#include <map>
#include <set>
#include <deque>
#include <stack>
#include <bitset>
#include <algorithm>
#include <functional>
#include <numeric>
#include <utility>
#include <sstream>
#include <iostream>
#include <iomanip>
#include <cstdio>
#include <cmath>
#include <cstdlib>
#include <ctime>
#include <memory.h>
#include <cassert>
using namespace std;

int main()
{
    int a[123456];
    int n, t;
    cin >> n >> t;
    for (int i = 1; i < n; i++)
    {
        cin >> a[i];
    }
    int x = 1;
    while (x < t)
    {
        x += a[x];
    }
    puts(x == t ? "YES" : "NO");
    return 0;
}