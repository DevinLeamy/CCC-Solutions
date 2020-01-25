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

vector< vector<bool> > visited;
vector<bool> handleChange(vector<bool>, int);
int k;
int main() {
	ios_base::sync_with_stdio(0); cin.tie(0);
	int state; cin >> k;
	vector<bool> on;
	loopX(k) {
		cin >> state;
		on.pb((state? true: false));
	}
	visited.pb(on);
	queue<pair<vector<bool>, int>> queue;
	queue.push({on, 0});
	while (queue.size()) {
		pair<vector<bool>, int> values = queue.front(); queue.pop();
		vector<bool> state = values.first; int count = values.second;
		bool wasOn = false; bool found = false;
		loopX(state.size()-1) {
			if (!state[i] && (wasOn || state[i+1])) {
				vector<bool> newState = handleChange(state, i);
				if (find(visited.begin(), visited.end(), newState) == visited.end()) {
					queue.push({newState, count+1});
					visited.pb(newState);
				}
				wasOn = false;
			} else if (state[i]){wasOn = true; found = true;}
		}
		if (!found && !state[k-1]) {cout << count << endl; break;}
	}
	return 0;
}
vector<bool> handleChange(vector<bool> currentState, int index) {
	int currentNum = 0;
	vector<bool> newVector;
	currentState[index] = true;
	loopX((int)currentState.size()) {
		if (currentState[i]) {currentNum++; newVector.pb(true);}
		else {currentNum=0; newVector.pb(false);}
		if (currentNum == 4) {
			currentNum = 3;
			for (int j = i-3; j <= i; j++) {
				currentState[j] = false;
				newVector[j] = false;
			}
		}
	}
	return newVector;
}
