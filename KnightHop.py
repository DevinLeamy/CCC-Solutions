#Done

start = [int(_) for _ in input().split()]
end = [int(_) for _ in input().split()]

start = tuple(x for x in start)
end = tuple(x for x in end)

length = list(range(1, 9))
def possible_moves(x, y):
    moves = []
    hop_right = True if x + 2 in length else False
    hop_left = True if x - 2 in length else False
    hop_up = True if y + 2 in length else False
    hop_down = True if y - 2 in length else False

    hopsHorizontal = [(hop_right, x + 2), (hop_left, x - 2)]
    hopsVertical = [(hop_up, y + 2), (hop_down, y - 2)]
    for i in hopsHorizontal:
        if y - 1 in length and i[0] == True:
            moves.append((i[1], y - 1))
        if y + 1 in length and i[0]:
            moves.append((i[1], y + 1))
    for i in hopsVertical:
        if x - 1 in length and i[0]:
            moves.append((x - 1, i[1]))
        if x + 1 in length and i[0]:
            moves.append((x + 1, i[1]))
    return moves
def horse(start, end):
    search = []
    next_values = []
    distance = 1
    x, y = start
    current = start
    points_to_check = [i for i in possible_moves(x, y)]
    points_checked = [tuple(i for i in current)]
    while(True):
        if current == end:
            return 0
        if end in points_to_check:
            return distance
        else:
            for i in points_to_check:
                x, y = i
                search = possible_moves(x, y)
                points_checked.append(tuple(x for x in i))
                for i in search:
                    if i not in points_checked:
                        next_values.append(tuple(x for x in i))
        points_to_check = set(next_values)
        distance += 1

print(horse(start, end))
