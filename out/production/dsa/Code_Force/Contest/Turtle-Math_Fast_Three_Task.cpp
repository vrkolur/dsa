#include <iostream>
#include <vector>
using namespace std;

int fun()
{
    int n;
    cin >> n;
    vector<int> a;
    int sum = 0, k = 0;
    for (int i = 0; i < n; i++)
    {
        cin >> k;
        a.push_back(k);
        sum += k;
    }
    if (sum % 3 == 0)
        return 0;

    for (int i = 0; i < n; i++)
    {
        int temp = sum - a[i];
        if (temp % 3 == 0)
            return 1;
    }
    for (int i = 0; i < n; i++)
    {
        int temp = sum + 1;
        if (temp % 3 == 0)
            return 1;
    }
    return 2;
}

int main()
{

    int t;
    cin >> t;
    vector<int> res;
    while (t--)
    {
        res.push_back(fun());
    }
    for (auto x : res)
        cout << x << "\n";
    return 0;
}