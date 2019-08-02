#Done

import itertools

nikkyF = int(input())
nikkyB = int(input())
nikky = (nikkyF, nikkyB)

byronF = int(input())
byronB = int(input())
byron = (byronF, byronB)

steps = int(input())


cyclesN = steps // sum(nikky)
cyclesB = steps // sum(byron)

distanceN = cyclesN * (nikky[0] - nikky[1])
distanceB = cyclesB * (byron[0] - byron[1])

if steps % sum(nikky) >= nikky[0]:
    distanceN += nikky[0] - (steps % sum(nikky) - nikky[0])
else:
    distanceN += steps % sum(nikky)

if steps % sum(byron) >= byron[0]:
    distanceB += byron[0] - (steps % sum(byron) - byron[0])
else:
    distanceB += steps % sum(byron)

if distanceB == distanceN:
    print("Tied")
elif distanceB > distanceN:
    print("Byron")
else:
    print("Nikky")
