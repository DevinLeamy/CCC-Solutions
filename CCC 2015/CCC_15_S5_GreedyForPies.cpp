#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <queue>
#include <set>
#include <map>
#define INF 2147483647;
#define LINF 9223372036854775807;
#define PI pair<int, int>
#define ll long long
#define pb push_back
#define loop(h) for(int i = 0; i < h; i++)

using namespace std;

int getMax(vector<int> list) {
	int dp[list.size()];
	dp[0] = list[0]; dp[1] = list[1]; dp[2] = list[2] + list[0];
	for (int i = 3; i < list.size(); i++) {
		dp[i] = max(dp[i-3] + list[i], max(dp[i-1], dp[i-2] + list[i]) );
	}
	return dp[list.size()-1];
}
int main() {
	ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int n, m, a; cin >> n; vector<int> N; vector<int> M;
	loop(n) { cin >> a; N.pb(a); }
	cin >> m;
	loop(m) { cin >> a; M.pb(a); }
	sort(M.begin(), M.end());
	int currentBest = getMax(N);
	vector<int> newVector = N;
	int low = 0; int high = m-1;
	for (int k = 0; k < m; k++) {
		int biggestIncrease = -1; PI value = {-1, -1}; int index = -1;
		int feelers[2] = {M[low], M[high]};
		for (int z = 0; z < 2; z++) {
			for (int j = 0; j < n; j++) {
				newVector.insert(newVector.begin() + j, feelers[z]);
				int diff = getMax(newVector) - currentBest;
				if (diff > biggestIncrease) {
					value.first = j;
					value.second = feelers[z];
					biggestIncrease = diff;
					index = (z == 0)? low : (int)high;
				}
				newVector.erase(newVector.begin() + j);
			}
		}
		newVector.insert(newVector.begin() + value.first, value.second);
		currentBest = max(currentBest, getMax(newVector));
		if (index == low) {low++;}
		else {high--;}
	}
	currentBest = max(currentBest, getMax(newVector));
	cout << currentBest << endl;
	return 0;
}
