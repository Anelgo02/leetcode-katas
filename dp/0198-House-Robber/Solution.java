public class Solution {
    /**
     * LeetCode 198 — House Robber
     *
     * You are a professional robber planning to rob houses along a street.
     * Each house has a certain amount of money stashed, but adjacent houses
     * have security systems connected, so you cannot rob two adjacent houses.
     *
     * Return the maximum amount of money you can rob tonight without alerting the
     * police.
     *
     * Example:
     * Input: nums = [2,7,9,3,1]
     * Output: 12
     * Explanation: Rob house 1 (2), house 3 (9), and house 5 (1) => 2 + 9 + 1 = 12
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int rob(int[] nums) {

        int n = nums.length;
        //base cases
        if(n==0) return 0;
        if(n==1) return nums[0];

        // we can solve in O(1) spatial using two variable
        int prev2 = nums[0], prev1 = Math.max(nums[1], nums[0]), current = prev1;
        
        int i = 2;// index of cycling (we start from index 2)

        // cycle through the array
        while (i < n) {
            current = Math.max(prev1, prev2 + nums[i]);
            // update the variable
            prev2 = prev1;
            prev1 = current;
            i++;

        }

        return current;
    }

}
