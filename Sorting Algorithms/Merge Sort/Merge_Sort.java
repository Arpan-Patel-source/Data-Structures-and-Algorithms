public class Merge_Sort
{
    static void sort(int x[], int n)
    {
        if(n<2)return;
        int m1 = n/2;
        int m2 = n-m1;
        int a[] = new int[m1];
        int b[] = new int[m2];
        int i;
        for(i=0;i<m1;i++)
        a[i]=x[i];
        for(i=0;i<m2;i++)
        b[i]=x[i+m1];
        sort(a,m1);
        sort(b,m2);
        merge(a,b,x,m1,m2);
    }
    static void merge(int x[], int y[], int z[], int n1, int n2)
    {
        int i=0, j=0, k=0;
        while(i<n1 && j<n2)
        {
            if(x[i]<y[j])z[k++]=x[i++];
            else 
                z[k++]=y[j++];
        }
        while(i<n1)z[k++]=x[i++];
        while(j<n2)z[k++]=y[j++];
        }
   public static void main(String[] ar)
   {
    int x[] = {30,56,34,-32,78,100,23};
    int n=7;
    sort(x,n);
    for(int i : x)System.out.println(i);
   } 
}
