from collections import deque

def solution(maps):
    row = len(maps)
    col = len(maps[0])
     
    # 상하좌우
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    
    answer = 0
    visited = [[0]*col for _ in range(row)]
    # 방문체크체크
    visited[0][0] = 1 
    maps[0][0] = 0

    queue = deque()
    queue.append(([0,0]))

    # queue가 빌 때까지 반복
    while queue:
        x, y = queue.popleft()

        # 상하좌우 칸 확인하기
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            # 맵 범위 내에있고 0인 벽이 아니면
            if 0 <= nx < row and 0 <= ny < col:
                if maps[nx][ny] == 1 and not visited[nx][ny]:
                    visited[nx][ny] = visited[x][y] + 1
                     # 재귀 !
                    queue.append((nx, ny))   

    answer = -1

    if visited[-1][-1]:
        return visited[-1][-1]
    return answer