class Solution {
    public int minOperations(String s) {
        int n = s.length();

        boolean sorted = true;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                sorted = false;
                break;
            }
        }
        if (sorted) return 0;

        if (n == 2) return -1;

        char minChar = 'z', maxChar = 'a';
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c < minChar) minChar = c;
            if (c > maxChar) maxChar = c;
        }

        if (s.charAt(0) == minChar || s.charAt(n - 1) == maxChar) {
            return 1;
        }

        boolean minValid = false;
        boolean maxValid = false;

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == minChar) minValid = true;
        }
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == maxChar) maxValid = true;
        }

        if (minValid || maxValid) {
            return 2;
        }

        return 3;
    }
}
