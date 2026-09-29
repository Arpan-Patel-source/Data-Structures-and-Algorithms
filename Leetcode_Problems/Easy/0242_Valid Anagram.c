#include<stdbool.h>
#include<stdlib.h>
bool isAnagram(char* s, char* t)
{
    size_t n1 = strlen(s);
    size_t n2 = strlen(t);
    if(n1!=n2)return false;
    int a[26] = {0};
    int b[26] = {0};
    int i = 0;
    for(i=0; i<n1; i++)
    {
        a[s[i]-97]++;
        b[t[i]-97]++;
    }
    for(i=0; i<26; i++)if(a[i]!=b[i])return false;
    return true;
}