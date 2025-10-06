public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = { 3, 2, 2, 3 };
        int val = 3;
        int newLength = sol.removeElement(nums, val);
        System.out.println("New length: " + newLength);
        System.out.print("Modified array: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }

    }

    public int removeElement(int[] nums, int val) {

        // metodo swap con coda, scambio gli elementi in coda con quelli da eliminare
        // aggiorno il puntatore i solamente se l'elemento non e' da eliminare

        int i = 0;
        int right = nums.length - 1;

        while (i <= right) {
            if (nums[i] == val) {
                nums[i] = nums[right];
                right--;
            } else {
                i++;
            }
        }

        // ritorno il numero di elementi diversi da val
        return right + 1;
    }

    public int removeElement2(int[] nums, int val) {

        // versione compatta i buoni, usiamo un ciclo for each

        //nel momento in cui trovo un elemento diverso da val lo copio in posizione i e incremento i
        ///non mi assicura che in coda trovero gli elementi da eliminare, ma non importa
        //perche' alla fine mi interessa solo il numero di elementi diversi da val

        int i = 0;

        for (int x : nums) {
            if (x != val) {
                nums[i] = x;
                i++;
            }
        }

        return i;
    }

}
