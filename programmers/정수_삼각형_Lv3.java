class Solution {

    public int[][] dp = new int[500][500];

    public int solution(int[][] triangle) {
        int answer = 0;
        int height = triangle.length;

        dp[0][0] = triangle[0][0];
        dp[1][0] = triangle[1][0] + dp[0][0];
        dp[1][1] = triangle[1][1] + dp[0][0];
        for(int i = 2; i < height; i++) {
            for(int j = 0; j < triangle[i].length; j++) {
                if(j == 0) {
                    dp[i][j] = triangle[i][j] + dp[i-1][0];
                }else if (j == triangle.length-1) {
                    dp[i][j] = triangle[i][j] + dp[i-1][j-1];
                }else {
                    dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
                }
            }
        }

        for(int i = 0; i < triangle[height-1].length; i++) {
            answer = Math.max(answer, dp[height-1][i]);
        }

        return answer;
    }
}