class Solution {
     public boolean canJump(int[] nums) {
        return jump(nums, 0);
    }
    
    public boolean jump(int[] nums, int i) {
        if (i == nums.length - 1) {
            return true; // reached last index
        }
        if (i >= nums.length || nums[i] == 0) {
            return false; // out of bounds or stuck
        }

        // try all possible jumps
        for (int step = 1; step <= nums[i]; step++) {
            if (jump(nums, i + step)) {
                return true;
            }
        }
        return false;
        }
}
