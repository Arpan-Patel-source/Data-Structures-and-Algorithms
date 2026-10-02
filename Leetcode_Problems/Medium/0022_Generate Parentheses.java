import java.util.*;
class Solution {
    public List<String> generateParenthesis(int n)
    {
        ArrayList<String> result = new ArrayList<>();
        backtracking(result,"",0,0,n);
        return result;
    }
    void backtracking(List<String> result, String current, int open, int close, int max)
    {
        if(current.length()==max*2){result.add(current);return;}
        if(open<max)backtracking(result,current+"(",open+1, close, max);
        if(close<open)backtracking(result,current+")",open,close+1,max);
    }
}