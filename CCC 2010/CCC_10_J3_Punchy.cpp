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
#define doH(h) for(int i = 0; i < h; i++)

using namespace std;

int main() {
	ios_base::sync_with_stdio(0);
	int a = 0, b = 0, in, v;
	char d, dd; bool quit = false;
	while (!quit) {
		cin >> in;
		switch (in) {
			case 1:
				cin >> d >> v;
				if (d == 'A') {a=v;}
				else {b=v;}
				break;
			case 2:
				cin >> d;
				cout << ((d=='A')? a : b) << endl;
				break;
			case 3:
				cin >> d >> dd;
				if (d == 'A') {a = a + ((dd == 'B')? b : a);}
				else {b = b + ((dd == 'B')? b : a);}
				break;
			case 4:
				cin >> d >> dd;
				if (d == 'A') {a = a * ((dd == 'B')? b : a);}
				else {b = b * ((dd == 'B')? b : a);}
				break;
			case 5:
				cin >> d >> dd;
				if (d == 'A') {a = a - ((dd == 'B')? b : a);}
				else {b = b - ((dd == 'B')? b : a);}
				break;
			case 6:
				cin >> d >> dd;
				if (d == 'A') {a = a / ((dd == 'B')? b : a);}
				else {b = b / ((dd == 'B')? b : a);}
				break;
			case 7:
				quit = true;
				break;
		}
	}
	return 0;
}

