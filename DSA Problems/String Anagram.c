#include<stdio.h>
int checkAnagram(char x[], char y[], int n1, int n2)
{
    if(n1!=n2)return 0;
    int a[26] = {0};
    int b[26] = {0};
    int i = 0;
    for(i=0; i<n1; i++)
    {
        a[x[i]-97]++;
        b[y[i]-97]++;
    }
    for(i=0; i<26; i++)if(a[i]!=b[i])return 0;
    return 1;
}
int main()
{
    char x[]="ramaacdbbaa";
    char y[]="armacdaaabb";
    if(checkAnagram(x,y,11,11))printf("String is Anagram");
    else printf("String is not anagram");
    return 0;
}