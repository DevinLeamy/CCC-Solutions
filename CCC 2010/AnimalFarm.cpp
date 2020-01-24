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
	int m, e, corner, cost; cin >> m;
	vector< vector< pair<PI, int> > > pensEdges;
	vector< vector<PI> > adj; adj.pb(vector<PI>());
	vector<bool> inTree; inTree.pb(false);
	for (int i = 0; i < m; i++) {
		pensEdges.pb(vector<pair<PI, int>>()); adj.push_back(vector<PI>());
		inTree.pb(false);
		cin >> e; int lastEdge; cin >> lastEdge;
		int firstEdge = lastEdge;
		vector<PI> edges;
		for (int j = 0; j < e-1; j++) {cin >> corner;
			edges.pb({max(corner, lastEdge), min(corner, lastEdge)}); lastEdge = corner;
			if (j == e-2) {edges.pb({max(corner, firstEdge), min(corner, firstEdge)});}
		}
		for (int j = 0; j < e; j++) {cin >> cost;
			pensEdges[i].pb({edges[j], cost});
		}
	}
	for (int i = 0; i < m; i++) {
		vector< pair<PI, int> > edges = pensEdges[i];
		for (pair<PI, int> otherEdge : edges) {
			bool found = false;
			for (int j = 0; j < m; j++) {
				if (j!=i) {
					for (pair<PI, int> edge : pensEdges[j]) {
						if (edge.first.first == otherEdge.first.first && edge.first.second == otherEdge.first.second) {
							found = true; adj[i].push_back({j, edge.second}); break;
						}
					}
					if (found) {break;}
				}
			}
			if (!found) {adj[i].pb({m, otherEdge.second}); adj[m].pb({i, otherEdge.second});}
		}
	}
	inTree[0] = true; int count = 0;
	priority_queue<PI> queue;
	int totalCost = 0;
	for (int i = 0; i < adj[0].size(); i++) {queue.push({adj[0][i].second*-1, adj[0][i].first});}
	while (count != m-1) {
		PI next;
		while (true) {
			PI newEdge = queue.top(); queue.pop();
			if (!inTree[newEdge.second]) {next = newEdge; break;}
		}
		inTree[next.second] = true; totalCost += next.first*-1;
		if (next.second != m) {count++;}
		for (PI gate : adj[next.second]) {
			if (!inTree[gate.first]) {queue.push({gate.second*-1, gate.first});}
		}
	}
	cout << totalCost << endl;
	return 0;
}
