
public class Solution {

    public int removeDuplicates(int[] nums){

        // non mi interessa cosa succede dopo i k numeri unici
        if (nums.length == 0) return 0;

        //creo due puntatori

        int read =0;//indice del numero unico
        
        for(int k = 1; k < nums.length; k++){
            if(nums[k] != nums[read]){
                nums[++read] = nums[k];
                

            }
        }

        return read + 1;
    }
    
}
