class Solution {
    public String digitSum(String s, int k)
    {
        while (s.length() > k) {
            StringBuilder nextString = new StringBuilder();

            for (int i = 0; i < s.length(); i += k)
            {
                int sum = 0;
                for (int j = i; j < Math.min(s.length(), i + k); j++) {
                    sum += s.charAt(j) - '0';
                }
                nextString.append(sum);
            }
            s = nextString.toString();
        }
        return s;
    }
}