class Solution {
    public boolean canAliceWin(int n)
    {
        boolean answer = false;
        int stones = 10;
        while (n >= stones) {
            n -= stones;
            stones--;
            answer = !answer;
        }
        return answer;
    }
}