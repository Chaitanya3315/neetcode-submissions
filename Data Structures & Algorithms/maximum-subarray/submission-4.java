class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int res = Integer.MIN_VALUE;
        for(int x : nums){
            if (sum < 0) sum = 0;    
            sum += x;        // reset first
            res = Math.max(res, sum);      // ❌ compares before using x
        }
        return res;
    }
}