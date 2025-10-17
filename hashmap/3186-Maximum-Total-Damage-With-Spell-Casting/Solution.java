import java.util.*;

public class Solution {

    /*
     * A magician has various spells.
     * 
     * You are given an array power, where each element represents the damage of a
     * spell. Multiple spells can have the same damage value.
     * 
     * It is a known fact that if a magician decides to cast a spell with a damage
     * of power[i], they cannot cast any spell with a damage of power[i] - 2,
     * power[i] - 1, power[i] + 1, or power[i] + 2.
     * 
     * Each spell can be cast only once.
     * 
     * Return the maximum possible total damage that a magician can cast.
     */

    public long maximumTotalDamage(int[] power) {
        // we can focus on duplicate power beacuse we can surely take them

        HashMap<Integer, Long> freq = new HashMap<>();
        // we put the frequency of the unique valor
        for (int p : power) {
            freq.put(p, freq.getOrDefault(p, 0L) + 1); // keys => power value, value==>frequency of the power
        }

        // create a set with the unique power elements
        List<Integer> keys = new ArrayList<>(freq.keySet());
        Collections.sort(keys);

        int n = keys.size();
        long[] dp = new long[n]; // dynamic programming array, we will put on each cell the max damage during all
                                 // the process

        for (int i = 0; i < n; i++) {
            long damage = keys.get(i) * freq.get(keys.get(i)); // element * times occurencies

            // base case
            if (i == 0) {
                dp[i] = damage;
            } else {
                // we need to find possibile power lower
                int j = i - 1;
                // if difference is lower or equal than 2 means power[j]==power[i]+1 or +2
                while (j >= 0 && keys.get(i) - keys.get(j) <= 2) {
                    j--;
                }

                
                long include = damage + (j >= 0 ? dp[j] : 0); //if dp[j] is valid and j>=0 we add to damage dp[j] element
                long exclude = dp[i - 1];//if there is no valid element we copy the previous one

                dp[i] = Math.max(include, exclude);

            }
        }

        return dp[n - 1];

    }

}
