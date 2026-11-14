class Solution {
    /**
     * @param {number[]} numbers
     * @param {number} target
     * @return {number[]}
     */
    twoSum(numbers: number[], target: number): number[] {
        let index1 = 0;
        let index2 = numbers.length-1;
        while (index1 < index2 && index2 < numbers.length) {
            const sum =numbers[index1] + numbers[index2];
            if ( sum == target) {
                return [index1+1, index2+1];
            } else if(target > sum){
                index1++;
            } else {
                index2--;
            }
        }
        return [0, 1];
    }
}
