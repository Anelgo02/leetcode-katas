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

        // we can fill to -1 initially, means it rains everyday

        Arrays.fill(ans, -1);

        // after this we will use HashMap to store last it rained over the ith lake

        HashMap<Integer, Integer> map = new HashMap<>();

        // TreeSet will store the non rainy day
        /*
         * A NavigableSet implementation based on a TreeMap. The elements are ordered
         * using their natural ordering, or by a Comparator provided at set creation
         * time, depending on which constructor is used.
         * This implementation provides guaranteed log(n) time cost for the basic
         * operations (add, remove and contains).
         */
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                set.add(i); // we add to the set the i non rainy day
                ans[i] = 1; // we mark the i day as free so we can drain a lake
            } else {
                if (map.containsKey(rains[i])) { // we check if it is rained on that lake
                    int lastRained = map.get(rains[i]);
                    Integer free = set.higher(lastRained);// this will find a non-rainy day which is just greater than
                    if (free == null)
                        return new int[] {};
                    else {
                        ans[free] = rains[i];// we drain
                        set.remove(free);// we remove the free day in which we will drain
                    }

                }
                map.put(rains[i], i); // we update the last day it rained over rains[i] lake
                                      // if rains[i] it's present we will update the value!
            }
        }

        return ans;

    }
}

// TC - O(NlogN)
// SC - O(N)