public class Solution {
    public void moveZeroes(int[] nums) {

        /*
         * Given an integer array nums, move all 0's to the end of it while maintaining
         * the relative order of the non-zero elements.
         * 
         * Note that you must do this in-place without making a copy of the array.
         */

         //usiamo due puntatori
         int write=0; //puntatore per scrivere i numeri non zero
         int k=0; //puntatore per scorrere l'array

         while(k<nums.length){
            if(nums[k]!=0){
                nums[write++]=nums[k];    
            }
            k++;
         }
            while(write<nums.length){
                nums[write++]=0;
            }


    }
}