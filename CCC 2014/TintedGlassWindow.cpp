#include <iostream>
#include <vector>
#include <map>
#include <unordered_map>

#define intM map<int, int>
#define intUM unordered_map<int, int>
using namespace std;

struct Coor
{
   int x, y1, y2, val;

    bool operator < (const Coor &a) const {
        return x < a.x;
    }
};
int main()
{
   vector<Coor> events;
   vector<int> yPoints;
   long long costs[2010] = { 0 };
   intUM compressed;
   int N;
   cin >> N;
   int T, x1, x2, y1, y2, tint;
   cin >> T;
   for (int i = 0; i < N; i++)
   {
      cin >> x1 >> y1 >> x2 >> y2 >> tint;
      events.push_back((Coor) {x1, y1, y2, tint});
      events.push_back((Coor) {x2, y1, y2, -tint});
      yPoints.push_back(y1);
      yPoints.push_back(y2);
   }

   sort(yPoints.begin(), yPoints.end());
   sort(events.begin(), events.end());
   yPoints.erase(unique(yPoints.begin(), yPoints.end()), yPoints.end());
   for (int i = 0; i < yPoints.size(); i++)
   {
      compressed[yPoints[i]] = i;
   }
   long long output = 0;
   for (int i = 0; i < events.size(); i++)
   {
      for (int j = compressed[events[i].y1]; j < compressed[events[i].y2]; j++)
      {
         costs[j] += events[i].val;
      }
      for (int j = 0; j < yPoints.size(); j++)
      {
         if (costs[j] >= T)
         {
            output += (events[i+1].x - events[i].x) * (yPoints[j + 1] - yPoints[j]);
         }
      }
   }
   cout << area << endl;
   return 0;
}
