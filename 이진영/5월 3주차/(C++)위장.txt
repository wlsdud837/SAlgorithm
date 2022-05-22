#include <string>
#include <vector>
#include <map>
#include <iostream>

using namespace std;
    /*
    * 1.해쉬 맵을 통해 종류의 갯수를 구한다.
    * 2. 각 종류의 갯수 구하기 
    * 3. 경우의 수 = (각 종류의 갯수 + 안 고른 경우들) - 1(모두 안 고른 경우 제외) 
    */
int solution(vector<vector<string>> clothes) {
    int answer = 1;
    map<string, int> map;

    // 1.해쉬 맵을 통해 종류의 갯수를 구한다.
    // 2. 각 종류의 갯수 구하기
    for(int i = 0; i < clothes.size(); i++){
       vector<string> c = clothes[i];
       map[c[1]]++;
    }
    // 3. 경우의 수 = (각 종류의 갯수 + 안 고른 경우들) - 1(모두 안 고른 경우 제외) 
    for (auto iter = map.begin(); iter != map.end(); ++iter) {
         answer *= map[iter->first] + 1; 
    }
    return answer - 1;
}