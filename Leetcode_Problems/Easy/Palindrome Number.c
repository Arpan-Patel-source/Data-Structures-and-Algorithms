bool isPalindrome(int x) {
    if(x<0)return false;
    long a, s, x1;
    x1=x;
    s=0;
    while(x!=0)
    {
        a=x%10;
        s=s*10+a;
        x=x/10;
    }
    if(x1==s)return true;
    else return false;
}