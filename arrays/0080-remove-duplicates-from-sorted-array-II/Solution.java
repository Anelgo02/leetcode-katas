public class Solution {
    
    public int removeDuplicates(int[] nums){

        // non mi interessa cosa succede dopo i k numeri unici al massimo duplicati
        if (nums.length == 0) return 0;
        if (nums.length <= 2) return nums.length;

        //creo due puntatori
        int read = 1;// indice del numero unico 
        int count = 1; // contatore delle occorrenze del numero unico 
        int k = 1; // indice di scrittura

        while (k < nums.length){

            if(nums[k]==nums[read]){
                if(count < 2){
                    nums[++read] = nums[k];
                    count++;                    
                }
                // se il count è già 2, salto l'elemento ma incremento k
                k++;
            }

            else{
                //se è un nuovo numero, lo scrivo e resetto il contatore duplicati
                nums[++read] = nums[k];
                count = 1;
                k++;
            }

        }
        return read + 1;
    }
}
