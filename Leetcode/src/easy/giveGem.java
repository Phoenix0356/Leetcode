package easy;

import java.util.Arrays;

public class giveGem {
    public int giveGem(int[] gem, int[][] operations) {
        for (int[] operation : operations) {
            int giver = operation[0], receiver = operation[1], gemGive = gem[giver] /= 2;
            gem[giver] -= gemGive;
            gem[receiver] += gemGive;
        }

        Arrays.sort(gem);
        return gem[gem.length-1]-gem[0];

    }
}
