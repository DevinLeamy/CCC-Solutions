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
int depth[100001] = {-1};
int longestPath = -1;
void getLongestPath(int current, vector<vector<int>> &adj, int last, int currentDepth) {
	depth[current] = currentDepth;
	longestPath = max(longestPath, depth[current]);
	for (int i = 0; i < adj[current].size(); i++) {
		if (adj[current][i] == last) {continue;}
		getLongestPath(adj[current][i], adj, current, currentDepth+1);
	}
}
int main() {
	ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int N, M, m, a, b; int treeWeight = 0; int pho = 0; cin >> N >> M;
	vector<vector<int>> adjOne(N+1);
	loop(M) {cin >> m; isPho[m] = true; pho = m;}
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
	for (int i = 0; i < N; i++) {treeWeight += adjOne[i].size();}
	getLongestPath(pho, adjOne, -1, 0);
	for (int j = 0; j < N; j++) { if (depth[j] == longestPath) { getLongestPath(j, adjOne, -1, 0); break; } }
	treeWeight -= longestPath;
	cout << treeWeight << endl;
	return 0;
}
