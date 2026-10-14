class Solution {
    public String maxSumOfSquares(int num, int sum)
    {
        int i;
        if(sum>num*9)return "";
        StringBuilder result = new StringBuilder();
        int count = sum/9;
        int rem = sum%9;
        for(i=0;i<count;i++)result.append('9');
        if(rem>0)result.append(rem);
        while(result.length()<num)
            result.append('0');
        return result.toString();
    }
}