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

int gcd(int a, int b)
{
    if (a == 0)
        return b;
    if (b == 0)
        return a;

    // Base case
    if (a == b)
        return a;

    if (a > b)
    {
        if (a % b == 0)
            return b;
        return gcd(a - b, b);
    }
    if (b % a == 0)
        return a;
    return gcd(a, a - b);
}

int main()
{
    int a = 98, b = 34;
    cout << gcd(a, b) << "\n";
}