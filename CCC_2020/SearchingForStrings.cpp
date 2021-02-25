#include <iostream>
#include <vector>
#include <set>
#include <functional>
#define ll long long
#define pb push_back
using namespace std;

int main() {
	string subString, fullString; cin >> subString >> fullString;
	vector<int> eachLetter(26);
	for (int i = 0; i < 26; i++) {
		eachLetter[i] = 0;
	}
	for (int i = 0; i < subString.length(); i++) {
		int index = subString[i] - 'a';
		eachLetter[index]++;
	}
	set<ll> values;
	hash<std::string> hasher;
	vector<int> initialSetting(eachLetter);
	string currentString = "";
	for (int i = 0; i < fullString.length(); i++) {
		if (currentString.length() == subString.length()) {
			values.insert((ll) hasher(currentString));
		}
		int newLetterIndex = fullString[i] - 'a';
		if (initialSetting[newLetterIndex] == 0) {
			currentString = "";
			for (int j = 0; j < 26; j++) {
				eachLetter[j] = initialSetting[j];
			}
			continue;
		}
		if (currentString == "") {currentString += fullString[i]; eachLetter[newLetterIndex]--; continue;}
		if (eachLetter[newLetterIndex] == 0) {
			while (currentString.length() > 0) {
				int lastLetterIndex = currentString[0] - 'a';
				if (lastLetterIndex == newLetterIndex) {
					currentString = currentString.substr(1) + fullString[i];
					break;
				} else {
					currentString = currentString.substr(1);
					eachLetter[lastLetterIndex]++;
				}
			}
		} else {
			eachLetter[newLetterIndex]--;
			currentString += fullString[i];
		}
	}
	if (currentString.length() == subString.length()) {
		values.insert((ll) hasher(currentString));
	}
	cout << values.size() << endl;
	return 0;
}
