class Solution {
    public int maximumSaleItems(int[][] items, int budget)
    {
        int maxFactor = 0;
        long minPrice = Long.MAX_VALUE;

        for (int[] item : items) {
            maxFactor = Math.max(maxFactor, item[0]);
            minPrice = Math.min(minPrice, item[1]);
        }

        int[] freq = new int[maxFactor + 1];
        for (int[] item : items) freq[item[0]]++;

        int[] multiples = new int[maxFactor + 1];
        for (int d = 1; d <= maxFactor; d++) {
            if (freq[d] == 0) continue;
            int count = freq[d] - 1;
            for (int m = 2 * d; m <= maxFactor; m += d) count += freq[m];
            multiples[d] = count;
        }

        Arrays.sort(items, (a, b) -> Integer.compare(a[1], b[1]));
        long rem = budget, ans = 0;
        for (int[] item : items) {
            if (item[1] >= 2 * minPrice) break;
            long canBuy = Math.min(multiples[item[0]], rem / item[1]);
            ans += canBuy * 2;
            rem -= canBuy * item[1];
        }
        return(int) (ans + rem / minPrice);
    }
}