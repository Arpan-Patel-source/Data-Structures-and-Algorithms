class Solution {
    public int scoreOfParentheses(String s)
    {
        int result = 0;
        int x=0;
        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i)=='(')x++;
            else{ x--;
            if(s.charAt(i-1)=='(')result+=1<<x;
            }
        }
        return result;
    }
}