public class Solution {
    public int maxArea(int[] height) {

        /*
         * You are given an integer array height of length n. There are n vertical lines
         * drawn such that the two endpoints of the ith line
         * are (i, 0) and (i, height[i]).
         * Find two lines that together with the x-axis form a container, such that the
         * container contains the most water.
         * Return the maximum amount of water a container can store.
         * Notice that you may not slant the container.
         */

        // L'idea è di usare due puntatori, uno all'inizio e uno alla fine dell'array.
        int left = 0, right = height.length - 1, maxArea = 0;
        // continuiamo ill ciclo finchè i due puntatori non si incontrano
        while (left < right) {
            int area = Math.min(height[left], height[right]) * Math.abs(left - right);
            maxArea = Math.max(maxArea, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;

    }
}