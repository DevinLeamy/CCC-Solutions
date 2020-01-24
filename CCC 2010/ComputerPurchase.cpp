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

int main() {
	ios_base::sync_with_stdio(0);
	int n, r, s, d;
	string name;
	cin >> n;
	priority_queue<pair<int, string>> queue;
	loopX(n) {
		cin >> name >> r >> s >> d;
		int prof = (2 * r) + (3 * s) + d;
		queue.push({prof, name});
	}
	if (n == 0) {return 0;}
	else if (n==1) {cout << queue.top().second << endl; return 0;}
	pair<int, string> top = queue.top(); queue.pop();
	pair<int, string> second = queue.top(); queue.pop();
	if (top.first != second.first) {
		cout << top.second << endl;
		vector<string> winners; winners.pb(second.second);
		while (queue.size()) {
			pair<int, string> value = queue.top(); queue.pop();
			if (value.first == second.first) {winners.pb(value.second);}
			else {break;}
		}
		sort(winners.begin(), winners.end());
		cout << winners[0] << endl;
	} else {
		vector<string> winners; winners.pb(top.second); winners.pb(second.second);
		while (queue.size()) {
			pair<int, string> value = queue.top(); queue.pop();
			if (value.first == top.first) {winners.pb(value.second);}
			else {break;}
		}
		sort(winners.begin(), winners.end());
		cout << winners[0] << endl;
		cout << winners[1] << endl;
	}
	return 0;
}
