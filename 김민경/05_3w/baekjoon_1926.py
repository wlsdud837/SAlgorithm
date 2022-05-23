import sys
from collections import deque

input = sys.stdin.readline

# 세로, 가로
n, m = map(int, input().split())
# 방문 여부 체크 리스트
visited = [list(map(int, input().split())) for _ in range(n)]

width = 0 
max_width = 0 # 최대 그림 넓이
cnt = 0 # 그림 수

# 상하좌우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x, y):    
    queue = deque()
    queue.append((x, y))
    global width, max_width
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            # 가로세로 범위안에 있고, 연결되어 있으면
            if 0 <= nx < n and 0 <= ny < m and visited[nx][ny] == 1:
                width += 1
                visited[nx][ny] = 0
                queue.append((nx, ny))
    # 최대 그림 넓이 계속 체크
    max_width = max(width, max_width)
    width = 0

for i in range(n):
    for j in range(m):
        if visited[i][j]:
            cnt += 1
            bfs(i, j)

print(cnt)
print(max_width)