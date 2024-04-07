class Solution {
    public int maximumWealth(int[][] accounts) {
        
        int maxWelth = Integer.MIN_VALUE;
        for(int i = 0;i<accounts.length;i++){
            int currW = 0;
             for(int j = 0;j<accounts[i].length;j++){
                currW+= accounts[i][j];
            }
            maxWelth = Math.max(maxWelth,currW );
        }
        return maxWelth;
    }
}