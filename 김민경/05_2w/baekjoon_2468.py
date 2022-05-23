from collections import deque
import sys
input = sys.stdin.readline

N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]

# 상하좌우
dx = [-1, 1, 0, 0]  
dy = [0, 0, -1, 1] 
 
def bfs(x, y, k):
    queue = deque()
    queue.append((x, y))
    visited[x][y] = 1	# 방문했으면 1
 
    while queue:
        x, y = queue.popleft()
 
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
 
            if 0 <= nx < N and 0 <= ny < N:
                if arr[nx][ny] >= k and visited[nx][ny] == 0:    
                    visited[nx][ny] = 1
                    queue.append((nx, ny))

arr_min = min(map(min, arr)) # 최소 길이
arr_max = max(map(max, arr)) # 최대 길이
 
max_k = arr_max   

for k in range(arr_min, arr_max+1):
    visited = [[0] * N for _ in range(N)] # 방문한 리스트
    cnt = 0 # 영역 갯수
    for i in range(N):
        for j in range(N):
            # 안전영역에 있고 방문 안했으면
            if arr[i][j] >= k and visited[i][j] == 0:
                bfs(i, j, k)
                cnt += 1 # 한 영역 찾으면 영역 +1
    if cnt > max_k:  
        max_k = cnt 
print(max_k)