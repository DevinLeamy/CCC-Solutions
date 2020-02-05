// 11 of 15 Marks
#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <queue>
#include <set>
#include <map>
#define INF 2147483647;
#define LINF 9223372036854775807;
#define scan(x) do{while((x=getchar_unlocked())<'0'); for(x-='0'; '0'<=(_=getchar_unlocked()); x=(x<<3)+(x<<1)+_-'0');}while(0)
#define PI pair<int, int>
#define ll long long
#define pb push_back
#define loop(h) for(int i = 0; i < h; i++)
using namespace std;
char _;

class DisjointSet {
      public:
      vector<int> depth;
      vector<int> parents;
      int N;
      DisjointSet(int n) {
         N = n;
         for (int i = 0; i < N; i++) {
            depth.push_back(0);
            parents.push_back(i);
         }
      }
      int findSet(int x) {
         if (parents[x] != x) {
            parents[x] = findSet(parents[x]);
         }
         return parents[x];
      }
      void unionSets(int x, int y) {
         int xRep = findSet(x);
         int yRep = findSet(y);
         if (xRep == yRep) {
            return;
         }
         if (depth[xRep] > depth[yRep]) {
            parents[yRep] = xRep;
         } else if (depth[yRep] > depth[xRep]) {
            parents[xRep] = yRep;
         } else {
            depth[xRep] += 1;
            parents[yRep] = xRep;
         }
      }
};

int main() {
	ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int n, m, d, a, b; cin >> n >> m >> d; ll c;
	priority_queue<pair<ll, PI>,vector<pair<ll, PI>>,greater<pair<ll, PI>> > currentEdges;
	priority_queue<pair<ll, PI>,vector<pair<ll, PI>>,greater<pair<ll, PI>> > newEdges;
	DisjointSet disjointSet(n+1);
	for (int i = 0; i < m; i++) {
		cin >> a >> b >> c; a--; b--;
		if (i < n-1) {currentEdges.push({c, {a, b}}); }
		else { newEdges.push({c, {a, b}}); }
	}
	int count = 0;
	while (!newEdges.empty() || !currentEdges.empty()) {
		if (newEdges.empty() || (!currentEdges.empty() && currentEdges.top().first <= newEdges.top().first)) {
			pair<ll, PI> edge = currentEdges.top(); currentEdges.pop();
			if (disjointSet.findSet(edge.second.first) != disjointSet.findSet(edge.second.second)) {
				disjointSet.unionSets(edge.second.first, edge.second.second);
			}
		} else {
			pair<ll, PI> edge = newEdges.top(); newEdges.pop();
			if (disjointSet.findSet(edge.second.first) != disjointSet.findSet(edge.second.second)) {
				disjointSet.unionSets(edge.second.first, edge.second.second);
				count++;
			}
		}
	}
	cout << count << endl;
	return 0;
}

