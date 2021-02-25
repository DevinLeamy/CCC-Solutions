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
#define loop(h) for(int i = 0; i < h; i++)

using namespace std;

int cost = 0;
int main() {
	ios_base::sync_with_stdio(0); cin.tie(0);
	int n; cin >> n; int current = n;
	while (current != 1) {
		if (current % 2 == 0) {current /= 2; cost++; continue;}
		int max = (int) sqrt((double) current);
		bool found = false;
		for (int i = 2; i <= max; i++){
		    if (current % i == 0){
			int b = (current / i);cost += (i - 1);
			current -= b; found = true; break;
		    }
		} 
		if (!found){current--; cost += current;}
	}
	cout << cost << endl;
	return 0;
}
