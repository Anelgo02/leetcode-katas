public class Solution {
    public int MajorityElement(int[] nums) {

        /*
         * Given an array nums of size n, return the majority element.
         * 
         * The majority element is the element that appears more than ⌊n / 2⌋ times. You
         * may assume that the majority element always exists in the array.
         */

        int major = nums[0];
        int count = 1;
        // we're gonna use the Boyer-Moore Voting Algorithm
        // because it has O(n) time complexity and O(1) space complexity
        // we MUST have a majority element to use this algorithm
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == major) {
                count++;
            }
            if (nums[i] != major) {
                count--;
            }
            if (count == 0) {
                major = nums[i];
                count = 1;
            }
        }

        return major;
    }

}
