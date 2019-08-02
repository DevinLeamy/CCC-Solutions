#Done
import itertools
n = int(input())
result = []


hands = [1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 0]


for combination in itertools.combinations(hands, 2):
    if sum(combination) == n:
        result.append(combination)
print(len(set(result)))
