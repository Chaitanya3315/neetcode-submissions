class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int i=0;
        if(nums.length == 1) return nums[0];
        int res = Integer.MIN_VALUE;
        while(i<nums.length){
            if(sum <= 0){
                sum=0;
            }
            sum+=nums[i];
            res = Math.max(sum,res);
            i++;
        }
        return res;
    }
}
