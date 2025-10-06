public class Solution {

    public void mergeSortedArray(int[] nums1, int m, int[] nums2, int n) {
        
        //mi servono sempre due indici per scorrere i due array in maniera lineare
        //two pointers
        int i = m-1; //ultimo elemento di nums1
        int j = n-1; //ultimo elemento di nums2
        int k = m+n-1; //ultimo elemento di nums1 che conterrà il risultato

        while(i>=0 && j>=0){
            if(nums1[i] > nums2[j]){
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
         

        


    }
}

}