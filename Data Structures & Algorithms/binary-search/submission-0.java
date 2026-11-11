class Solution {
    public int search(int[] nums, int target) {
        return bs(0,nums.length-1,target,nums);
    }

    public int bs(int lo, int hi, int target, int[] nums){
        if (lo > hi) return -1;
        int mid = (lo+hi)/2;
        if(nums[mid] == target){
            return mid;
        } else if(nums[mid] < target){
            return bs(mid+1,hi,target,nums);
        } else {
            return bs(lo,mid-1,target,nums);
        }
    }
}
