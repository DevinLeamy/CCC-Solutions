#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <queue>
#include <set>
#define INF 2147483647;
#define LINF 9223372036854775807;
#define PI pair<int, int>
#define ll long long
#define pb push_back
#define loopX(h) for(int i = 0; i < h; i++)

using namespace std;

const int street = 1000000;
vector<int> houses;
int n, v, k;
int binarySearch(int, int);
bool check(int);
int main() {
	ios_base::sync_with_stdio(0);
	cin >> n;
	loopX(n) {cin >> v; houses.pb(v);}
	sort(houses.begin(), houses.end());
	cin >> k;
	if (k >= n) {cout << 0 << endl; return 0;}
	int ideal = binarySearch(0, street);
	while (check(ideal)) {ideal--;} ideal++;
	cout << ideal << endl;
	return 0;
}
int binarySearch(int low, int high) {
	if (high - low <= 2) {return high;}
	int mid = (low + high)/2;
	if (check(mid)) {return binarySearch(low, mid);}
	else {return binarySearch(mid, high);}
}
bool check(int length) {
	for (int i = 0; i < n; i++) {
		int count = 0; int countK = 0; int index = i;
		while (count != n) {
			int current = houses[index];
			count++; countK++; index++; index=index%n;
			while (count != n) {
				if (current+length+length >= street) {
					if ((current+length+length) % street >= houses[index])
					{count++; index++; index=index%n;}
					else {break;}
				} else {
					if ((current+length+length) % street >= houses[index] && houses[index] >= current)
					{count++; index++; index=index%n;}
					else {break;}
				}
				
			}
		}
		if (countK <= k) {return true;}
	}
	return false;
}
