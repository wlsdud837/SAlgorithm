
# m : 높이, n : 폭
def solution(m, n, board):
    answer = 0

    for i in range(len(board)):                # board 배열로 만들기
        popped = board.pop(0)
        board.append([p for p in popped])

    # 터진 블록 없을 때까지~
    while True: 
        # 터져야 할 블록 리스트                      
        checked = []                       
        for i in range(m - 1):                
            for j in range(n - 1):
                # 이미 터져서 0이면 패스
                if not board[i][j]:        
                    continue
                # 다 동일하면 터져야 될 블록들에 전부 저장
                if board[i][j] == board[i][j + 1]:    
                    if board[i][j] == board[i + 1][j] and board[i][j + 1] == board[i + 1][j+1]:
                        checked.append((i, j))
                        checked.append((i, j + 1))
                        checked.append((i + 1, j))
                        checked.append((i + 1, j + 1))        

        # 터질 블록 없으면 종료
        if len(checked) == 0:      
            break
        # 있으면 터트리기
        else:
            answer += len(set(checked))   
            for k in checked:
                board[k[0]][k[1]] = '0'
            
            # 터지고 내리기
            for k in reversed(checked):    
                check_n = k[0] - 1
                put_n = k[0]
                
                while check_n >= 0:      
                    if board[put_n][k[1]] == "0" and board[check_n][k[1]] != "0":
                        board[put_n][k[1]] = board[check_n][k[1]]
                        board[check_n][k[1]] = "0"
                        put_n -= 1

                    check_n -= 1

    return answer