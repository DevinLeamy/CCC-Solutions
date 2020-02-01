// 13/15 TLE

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
bool isPho[100001];
bool visited[100001];
int main() {
	ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int N, M, m, a, b; int treeWeight = 0; cin >> N >> M;
	vector<vector<int>> adjOne(N+1);
	loop(M) {cin >> m; isPho[m] = true; }
	loop(N-1) {
		cin >> a >> b;
		adjOne[a].pb(b); adjOne[b].pb(a);
	}
	loop(N) {
		int current = i;
		while (adjOne[current].size() == 1) {
			if (isPho[current]) {break;}
			int node = adjOne[current][0];
			adjOne[current].clear();
			adjOne[node].erase( find(adjOne[node].begin(), adjOne[node].end(), current) );
			current = node;
		}
	}
	loop(N) {if (adjOne[i].size() == 1) {adjOne[N].pb(i);}}
	for (int i = 0; i < N; i++) {treeWeight += adjOne[i].size();}
	int longestPath = 0;
	queue<pair<int, PI>> current; current.push({N, {-1, -1}}); // currentNode, path, lastNode
	while (!current.empty()) {
		pair<int, PI> curNode = current.front(); current.pop();
		int node = curNode.first; int path = curNode.second.first;
		longestPath = max(longestPath, path);
		for (int ne : adjOne[node]) {
			if (ne != curNode.second.second) {
				current.push({ne, {path+1, node}});
			}
		}
	}
	treeWeight -= longestPath;
	cout << treeWeight << endl;
	return 0;
}
