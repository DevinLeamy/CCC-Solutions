#Done
import sys
import itertools

input = sys.stdin.readline

def find_shortest_cycle(averages):
    iterable = iter(range(1, len(averages) + 1))
    while True:
        counter = 0
        difference = []
        if len(averages) == 0:
            return 0
        for i in range(len(averages)):
            try:
                difference.append((averages[i] - averages[i+1]) * -1)
            except IndexError:
                pass
        seq = itertools.cycle(i for i in difference[:next(iterable)])
        counter = 0
        if len(set(difference)) == 1:
            return 1
        elif len(set(difference)) == len(difference):
            return len(difference)
        for i in difference:
            if i == next(seq):
                continue
            else:
                counter += 1
        if counter == 0:
            return len(difference[:next(iterable) - 1])

averages = [int(_) for _ in input().strip().split()]

while averages != [0]:
    averages = averages[1:]
    print(find_shortest_cycle(averages))
    averages = [int(_) for _ in input().strip().split()]
