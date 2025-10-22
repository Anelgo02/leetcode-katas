import java.util.HashMap;

/*
 *You are given an integer array nums and two integers k and numOperations.

You must perform an operation numOperations times on nums, where in each operation you:

Select an index i that was not selected in any previous operations.
Add an integer in the range [-k, k] to nums[i].
Return the maximum possible frequency of any element in nums after performing the operations.
 */

public class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int ans = 0;
        int maxx = nums[0];

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            //update max and freq
            maxx = Math.max(num, maxx);
            map.put(num, map.getOrDefault(num, 0) + 1);

        }

        int[] count = new int[maxx+1];

        //create the count array for next apply prefix sum
        for(int num : nums){

            if(num-k<0)
                count[0]++;
            else
                count[num-k]++;
            
            if(num+k+1<=maxx)
                count[num+k+1]--;
            
        } 

        for(int i=1;i<=maxx;i++){

            //prefix sum
            count[i] += count[i-1];
            //extract the original freq of the i value
            int freq = map.getOrDefault(i, 0);
            //extract the extra freq with constraint of the i value
            int extra = count[i] - freq;
            //update the cur freq value
            int cur = freq + Math.min(numOperations, extra);
            //update the maxFreq of any value in the nums array
            ans = Math.max(cur, ans);
        }

        return ans;



    }

}
