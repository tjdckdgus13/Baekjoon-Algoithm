class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int w = 0 ;
        int h = 0 ;
        for(int i = 0 ; i < sizes.length; i++) {
          int a = Math.max(sizes[i][0], sizes[i][1]);
          int b = Math.min(sizes[i][0], sizes[i][1]);
        
          w = Math.max(a, w);
          h = Math.max(b, h);
            
           
        }
        answer = w*h;
        return answer;
    }
}