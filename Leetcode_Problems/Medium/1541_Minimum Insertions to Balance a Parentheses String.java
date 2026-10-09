class Solution {
    public int minInsertions(String s)
    {
        int x = 0, y = 0;
        for(int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            if(c=='(')
            {
                if(y%2!=0){x++;y--;}
                y+=2;
            }else
            {
                y--;
                if(y<0){
                    x++;
                    y+=2;
                }
            }
        }
        return x +y;
    }
}