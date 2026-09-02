import java.util.*;
class Solution {
    public int[] sortedSquares(int[] nums) {
        List<Integer> negative = new ArrayList<>();
        List<Integer> positive = new ArrayList<>();

        for (int num : nums) {
            if (num < 0)
                negative.add(num);
            else
                positive.add(num);
        }

        if (negative.size() == 0) {
            for (int i = 0; i < positive.size(); i++)
                positive.set(i, positive.get(i) * positive.get(i));
            return positive.stream().mapToInt(Integer::intValue).toArray();
        }

        if (positive.size() == 0) {
            for (int i = 0; i < negative.size(); i++)
                negative.set(i, negative.get(i) * negative.get(i));
            Collections.reverse(negative);
            return negative.stream().mapToInt(Integer::intValue).toArray();
        }

        int i = 0, j = 0, id = 0;
        int n1 = negative.size();
        int n2 = positive.size();
        int[] result = new int[n1 + n2];

        for (i = 0; i < n1; i++)
            negative.set(i, negative.get(i) * negative.get(i));
        Collections.reverse(negative);

        for (i = 0; i < n2; i++)
            positive.set(i, positive.get(i) * positive.get(i));
        i = 0; 
        j=0;
        while (i < n1 && j < n2) {
            if (negative.get(i) <= positive.get(j)) result[id++] = negative.get(i++);
                else result[id++] = positive.get(j++);
        }
        while (i < n1) result[id++] = negative.get(i++);
        while (j < n2) result[id++] = positive.get(j++);
        return result;
    }
}