#include <iostream>
#include <vector>
#include <queue>

using namespace std;

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

int N, M, P, Q;
int main() {
    int a, b, x, y;
    long long c, z;
    long long totalCost = 0;
    long long newCost = 0;
    cin >> N >> M >> P >> Q;
    DisjointSet disjointSet(N * M);
    priority_queue<pair< long long, pair<int, int>>, vector<pair< long long, pair<int, int>>>, greater<pair< long long, pair<int, int> >>> edges;
    for (int i = 0; i < P; i++) {
        cin >> a >> b >> c;
        if (a != b) {
            edges.push({c, {-(a-1), -(b-1)}});
        }
        totalCost += c * N;
    }
    for (int i = 0; i < Q; i++) {
        cin >> x >> y >> z;
        if (x != y) {
            edges.push({z, {x-1, y-1}});
        }
        totalCost += z * M;
    }
    while (edges.size() != 0) {
        pair< long long, pair<int, int> > edge = edges.top();
        edges.pop();
//        cout << "Cost: " << edge.first << endl;
        if (edge.second.first < 0 || edge.second.second < 0) { //plane
            int a = edge.second.second * -1;
            int b = edge.second.first * -1;
            for (int i = 0; i < N; i++) {
                int ax = a + (i * M);
                int bx = b + (i * M);
                if (disjointSet.findSet(ax) != disjointSet.findSet(bx)) {
                    disjointSet.unionSets(ax, bx);
                    newCost += edge.first;
                }
            }
        } else {
            int a = edge.second.second;
            int b = edge.second.first;
            for (int i = 0; i < M; i++) {
                int ax = i + (M * a);
                int bx = i + (M * b);
                if (disjointSet.findSet(ax) != disjointSet.findSet(bx)) {
                    disjointSet.unionSets(ax, bx);
                    newCost += edge.first;
                }
            }
        }
    }
    cout << totalCost - newCost << endl;
}
