class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        long a = 0;
        for(int i = 0; i < count ; i++) {
            a += price*(i+1);
        }
        
        if (a > money) a -= money;
        else a = 0;
        
        answer = a;
        return answer;
    }
}