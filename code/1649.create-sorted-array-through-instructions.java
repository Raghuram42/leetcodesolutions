class Solution {
    private int[] count;
    private int limit = (int)1e5 + 1;
    private int MOD = (int)1e9 + 7;

    public int createSortedArray(int[] instructions) {
        int totalCost = 0;
        this.count = new int[limit];
        for(int i = 0; i < instructions.length; i++) {
            int smallerNumberCount = getCount(instructions[i] - 1);
            int greaterNumberCount = i - getCount(instructions[i]);
            totalCost = (totalCost + Math.min(smallerNumberCount, greaterNumberCount)) % MOD;
            updateCount(instructions[i]);
        }
        return totalCost;
    }

    private void updateCount(int number) {
        while(number < limit) {
            count[number]++;
            number += number & -number;
        }
    }

    private int getCount(int number) {
        int res = 0;
        while(number > 0) {
            res += count[number];
            number -= number & -number;
        }
        return res;
    }
}