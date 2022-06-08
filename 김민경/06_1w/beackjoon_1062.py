import sys
from collections import deque

input = sys.stdin.readline

filed = [list(input().split()) for _ in range(12)]

# 상하좌우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

answer = 0

def bfs(a, b, c):
    queue = deque()
    queue.append((a, b))

    # 터질 뿌요들
    bump = deque()
    bump.append((a, b))

    visited = [[0] * 6 for _ in range(12)]
    visited[a][b] = 1 # 방문체크체크~
    cnt = 1
    end = 0 # 끝낼지 말지 체크 (0이면 끝)

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            # 범위 벗어나면 x
            if nx < 0 or nx > 11 or ny < 0 or ny > 5:
                continue
            if filed[nx][ny] == c and visited[nx][ny] == 0:
                queue.append((nx, ny))
                bump.append((nx, ny))
                visited[nx][ny] = True
                cnt += 1

    # 같은 색 뿌요면 터질게있다! 연쇄체크
    if cnt >= 4:
        end = 1

        # 터질애들 빈공간으로
        for x, y in bump:
            filed[x][y] = "."

    return end

# 중력받는 함수
def gravity():
    for y in range(6):
        queue = deque()
        for x in range(11, -1, -1):
            # 빈공간아니면 넣자
            if filed[x][y] != '.':
                queue.append(filed[x][y])
        for x in range(11, -1, -1):
            # 담겨있는게 있으면 빼자
            if queue:
                filed[x][y] = queue.popleft()
            else:
                filed[x][y] = '.'



while True:
    check = 0
    for i in range(12):
        for j in range(6):
            # 빈공간아니면 탐색돌리자
            if filed[i][j] != '.':
                check += bfs(i, j, filed[i][j])
    
    if check == 0:
        print(answer)
        break
    else:
        answer += 1
    gravity()


