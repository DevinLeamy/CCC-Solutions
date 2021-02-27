#include <iostream>
#include <queue>
#include <vector>

#define INF 10000000

using namespace std;


int main() {
    int n, w, d; cin >> n >> w >> d;
    vector<vector<int> > walk_ways(n);
    vector<vector<int> > walk_ways_back(n);
    for (int i = 0; i < w; i++) {
        int a, b; cin >> a >> b;
        --a; --b;
        walk_ways[a].push_back(b);
        walk_ways_back[b].push_back(a);
    }
    vector<int> route(n, -1); // maps station to index
    vector<int> seq(n, -1); // maps index to station
    
    for (int i = 0; i < n; i++) {
        int station; cin >> station;
        --station;
        route[station] = i;
        seq[i] = station;
    }

    vector<int> dists(n, INF);
    queue<pair<int,int> > cur; cur.push(make_pair(n - 1, 0));
    while (!cur.empty()) {
        pair<int, int> top = cur.front(); cur.pop();
        if (dists[top.first] != INF) continue;
        dists[top.first] = top.second;
        for (int i = 0; i < walk_ways_back[top.first].size(); i++) {
            int node = walk_ways_back[top.first][i];
            if (!(dists[node] == INF)) continue;
            cur.push(make_pair(node, top.second + 1));
        }
    }

    vector<int> to_end(n, INF); // node, dist
    priority_queue<pair<int, int>, vector<pair<int, int> >, greater<pair<int, int> > > p_queue;
    for (int i = 0; i < n - 1; i++) {
        if (dists[i] == -1) continue;
        to_end[i] = dists[i] + route[i];
        p_queue.push(make_pair(to_end[i], i));
    }
    
    for (int i = 0; i < d; i++) {
        int a, b; cin >> a >> b;
        --a; --b;

        int temp = seq[a];
        seq[a] = seq[b];
        seq[b] = temp;
        route[seq[a]] = a;
        route[seq[b]] = b;

        if (dists[seq[a]] != -1) {
            to_end[seq[a]] = route[seq[a]] + dists[seq[a]];
            p_queue.push(make_pair(to_end[seq[a]], seq[a]));
        }
        if (dists[seq[b]] != -1) {
            to_end[seq[b]] = route[seq[b]] + dists[seq[b]];
            p_queue.push(make_pair(to_end[seq[b]], seq[b]));
        }
        int ans = route[n - 1]; // If you only took the train
        while (!p_queue.empty()) {
            pair<int, int> top = p_queue.top();
            if (to_end[top.second] != top.first) {
                p_queue.pop();
                continue;
            }
            ans = min(ans, top.first);
            break;
        }
        cout << ans << endl;
    }
}
