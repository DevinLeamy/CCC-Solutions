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

int pi, people;
int mem[250][250][250];
int recure(int currentPerson, int piRem, int lastPerson) {
	if (mem[currentPerson][piRem][lastPerson] != 0) {
		return mem[currentPerson][piRem][lastPerson];
	}
	if (currentPerson == people) {return 1;}
	int max = piRem / ((people - currentPerson)+1);
	int count = 0;
	for (int i = lastPerson; i <= max; i++) {
		piRem -= i; count += recure(currentPerson+1, piRem, i); piRem += i;
	}
	mem[currentPerson][piRem][lastPerson] = count;
	return mem[currentPerson][piRem][lastPerson];
}
int main() {
	ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> pi >> people;
	cout << recure(1, pi, 1) << endl;
	return 0;
}
