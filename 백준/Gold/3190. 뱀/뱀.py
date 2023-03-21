from collections import deque
import sys

input = sys.stdin.readline

N = int(input())
K = int(input())

board = [[0] * N for _ in range(N)] # 0: 빈칸, 1: 사과, 2:뱀
board[0][0] = 2
d = [(0, 1), (1, 0), (0, -1), (-1, 0)] # 0 오른, 1 아래, 2 왼, 3 위
currentDirection = 0
movement = deque()
snake = deque()
snake.append((0, 0))
second = 0

for _ in range(K):
    x, y = map(int, input().split())
    board[x - 1][y - 1] = 1

L = int(input())

for _ in range(L):
    X, C = map(str, input().split())
    movement.append((int(X), C))

currentMovement = movement.popleft()

while True:
    if second == currentMovement[0]:
        if currentMovement[1] == 'D':
            currentDirection = (currentDirection + 1) % 4
        else:
            currentDirection -= 1
            if currentDirection == -1:
                currentDirection = 3

        if len(movement) != 0:
            currentMovement = movement.popleft()

    x, y = snake[-1]
    dx = x + d[currentDirection][0]
    dy = y + d[currentDirection][1]

    # 벽이나 몸을 부딪히면 게임 종료
    if dx < 0 or dx >= N or dy < 0 or dy >= N or board[dx][dy] == 2:
        break

    if board[dx][dy] != 1:
        a, b = snake.popleft()
        board[a][b] = 0

    board[dx][dy] = 2
    snake.append((dx, dy))
    second += 1

print(second + 1)