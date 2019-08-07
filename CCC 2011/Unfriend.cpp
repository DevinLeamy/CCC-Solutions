#include <iostream>

using namespace std;

int main()
{
    int N;
    int F;
    cin >> N;
    int network[6] = {1, 1, 1, 1, 1, 1};
    for (int i = 0; i < N; i++){
        network[i] = 1;
    }
    for (int i = 0; i < N - 1; i++){
        cin >> F;
        network[F - 1] *= (network[i] + 1);
    }
    cout << network[N - 1] << endl;
    return 0;
}