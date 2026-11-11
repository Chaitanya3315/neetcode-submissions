class Solution {
    /**
     * @param {number[]} nums
     * @return {number[]}
     */
    productExceptSelf(nums: number[]): number[] {
    let zeros = 0;
    let product = 1;
    for (const num of nums) {
        if (num == 0) {
            zeros++;
            continue;
        }
        product = product * num;
    }
    if (zeros > 1) return new Array(nums.length).fill(0);
    for (const [index, num] of nums.entries()) {
        if (zeros > 0) {
            if (num == 0) {
                nums[index] = product;
            } else {
                nums[index] = 0;
            }
            continue;
        }
        nums[index] = product / num;
    }
    return nums;
};
}
