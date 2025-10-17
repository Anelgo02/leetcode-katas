import java.util.TreeSet;
import java.util.Arrays;
import java.util.HashMap;

/*
 * 
 * Your country has an infinite number of lakes. Initially, all the lakes are
 * empty, but when it rains over the nth lake, the nth lake becomes full of
 * water. If it rains over a lake that is full of water, there will be a flood.
 * Your goal is to avoid floods in any lake.
 * 
 * Given an integer array rains where:
 * 
 * rains[i] > 0 means there will be rains over the rains[i] lake.
 * rains[i] == 0 means there are no rains this day and you can choose one lake
 * this day and dry it.
 * 
 * Return an array ans where:
 * 
 * ans.length == rains.length
 * ans[i] == -1 if rains[i] > 0.
 * ans[i] is the lake you choose to dry in the ith day if rains[i] == 0.
 * If there are multiple valid answers return any of them. If it is impossible
 * to avoid flood return an empty array.
 * 
 * Notice that if you chose to dry a full lake, it becomes empty, but if you
 * chose to dry an empty lake, nothing changes.
 */

class Solution {
    public int[] avoidFlood(int[] rains) {

        int n = rains.length;
        int[] ans = new int[n];

        // we can initially fill with -1 means it rains everyday
        Arrays.fill(ans, -1);

        TreeSet<Integer> set = new TreeSet<>(); // store the non-rainy days
        HashMap<Integer, Integer> map = new HashMap<>(); // to store the last day it rained on lake

        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                set.add(i);// we add to the set that on day i is not raining
                ans[i] = 1;// we set a casual value to mark that is not raining on this day
            } else {
                if (map.containsKey(rains[i])) {// we check if it has already rained over the rains[i] lake
                    int lastRain = map.get(rains[i]); // on which day it rained
                    Integer free = set.higher(lastRain); // this will find a non-rainy day which is just greater than
                    if (free == null)
                        return new int[] {};
                    else {
                        // if we can dry on a non rainy day we dry the rains[i] lake
                        ans[free] = rains[i];
                        set.remove(free);
                    }
                }
                map.put(rains[i], i); // we update the last day that rained on rains[i] lake
            }
        }

        return ans;

    }
}

// TC - O(NlogN)
// SC - O(N)