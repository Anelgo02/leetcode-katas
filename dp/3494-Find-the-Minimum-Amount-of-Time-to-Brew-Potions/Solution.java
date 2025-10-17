/*

you are given two integer arrays, skill and mana, of length n and m, respectively.
In a laboratory, n wizards must brew m potions in order.
Each potion has a mana capacity mana[j] and must pass through all the wizards 
sequentially to be brewed properly. 
The time taken by the ith wizard on the jth potion is timeij = skill[i] * mana[j].
Since the brewing process is delicate, a potion must be passed to the next wizard
immediately after the current wizard completes their work.
This means the timing must be synchronized so that each wizard begins 
working on a potion exactly when it arrives.
Return the minimum amount of time required for the potions to be brewed properly. 



*/

public class Solution {

    public long minTime(int[] skill, int[] mana) {

        int n = skill.length;
        int m = mana.length;

        // first potion

        long[] prevEnd = new long[n];
        prevEnd[0] = skill[0] * mana[0];
        for (int i = 1; i < n; i++) {
            prevEnd[i] = prevEnd[i - 1] + skill[i] * mana[0];
        }

        // we cycle for every potion

        for (int j = 1; j < m; j++) {

            // we use delay and time to insert every potion at the right time in the
            // pipeline
            long time = 0, delay = 0;
            for (int i = 0; i < n; i++) {
                if (time >= prevEnd[i]) {
                    time += skill[i] * mana[j];
                    // se il tempo in cui il mago può iniziare a lavorare è maggiore della
                    // precedente fine allora può iniziare a lavorare subito

                } else {
                    // se ancora il mago non può lavorare allora aggiungiamo al ritardo il tempo
                    // mancante
                    // e aggiorniamo il tempo di attesa
                    delay += prevEnd[i] - time;
                    time = prevEnd[i] + skill[i] * mana[j];
                }
            }

            /*
             * costruiamo l'array finale di prevEnd, cioè siamo sempre
             * all'interno del ciclo sulle righe => per ogni riga aggiorno il delay
             * alla fine calcolo il tempo totale per il primo mago.
             * E faccio partire un ciclo sulle colonne per calcolare il tempo finale
             */

            prevEnd[0] = delay + skill[0] * mana[j];
            for (int i = 1; i < n; i++) {
                prevEnd[i] = prevEnd[i - 1] + skill[i] * mana[j];
            }

        }

        return prevEnd[n - 1];

    }

}
