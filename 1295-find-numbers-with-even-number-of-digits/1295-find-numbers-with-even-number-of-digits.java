class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
       for(int i = 0;i<nums.length;i++){
           if(countDigits(nums[i])%2 == 0){
               count++;
           }
       }
       return count;
    }
    static int countDigits(int n){
        int count = 0;
        while(n!=0){
            int lastDig = n%10;
            count++;
            n = n/10;
        }
        return count;
    }
}