"""
1.해쉬 맵을 통해 종류의 갯수를 구한다.
2. 각 종류의 갯수 구하기 
3. 경우의 수 = (각 종류의 갯수 + 안 고른 경우들) - 1(모두 안 고른 경우 제외) 
"""
def solution(clothes):
    answer = 1

    #1.해쉬 맵을 통해 종류의 갯수를 구한다.
    type = [y for x, y in clothes];
    #2. 각 종류의 갯수 구하기
    count = [type.count(y) for y in set(type)];
    #3. 경우의 수 = (각 종류의 갯수 + 안 고른 경우들) - 1(모두 안 고른 경우 제외) 
    for c in count:
        answer *= c + 1;
    return answer - 1