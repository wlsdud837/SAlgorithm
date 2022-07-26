import sys

input = sys.stdin.readline

def solution(a):
    
    for i in range(len(a)-1):
        num_len = len(a[i])
        if a[i] == a[i+1][:num_len]:
            print('NO')
            return
    print('YES')

# 테스트 케이스 수
t = int(input())

for _ in range(t):
    # 전화번호 수
    n = int(input())
    numbers = [input() for _ in range(n)]
    numbers.sort()
    
    solution(numbers)