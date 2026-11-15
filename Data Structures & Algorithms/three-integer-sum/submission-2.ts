class Solution {
    /**
     * @param {number[]} nums
     * @return {number[][]}
     */
    threeSum(nums: number[]): number[][] {
        nums.sort((a,b)=> a-b);
        const results = new Set<number[]>();
        for(let i=0;i<nums.length-2;i++){
            let l = i+1;
            let r = nums.length - 1;
            if(i > 0 && nums[i]== nums[i-1]) continue;
            while(l < r){
                let sum = nums[i] + nums[l] + nums[r];
                if(sum == 0){
                    results.add([nums[i],nums[l],nums[r]]);
                    l++;
                    r--;
                    while(l>0 && l<nums.length -1 && nums[l] == nums[l-1]) l++;
                while(r>0 && r<nums.length -1 && nums[r] == nums[r+1]) r--;
                } else if(sum > 0){
                    r--;
                } else {
                    l++;
                }
                
            }
        }
        return Array.from(results);
    }
}
