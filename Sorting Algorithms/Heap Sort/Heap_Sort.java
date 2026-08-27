public class Heap_Sort
{
    static void show(int x[], int n, int i)
    {
        int l = i*2+1;
        int r = i*2+2;
        int max = i;
        if(r<n){
            if(x[l]>x[r])max = l;
                else max = r;
        }
        else if(l<n) max = l;
        if(x[max]>x[i])
        {
            int t=x[i];
            x[i]=x[max];
            x[max]=t;
            show(x,n,max);
        }
    }
    static void showloop(int x[], int n)
    {
        int i; 
        for(i = n/2-1;i>=0;i--)
            show(x,n,i);
    }
    static void delete(int x[], int n)
    {
        int i, t;
        for(i = n-1; i>0 ; i--)
        {
            t=x[0];
            x[0]=x[i];
            x[i]=t;
            show(x,i,0);
        }
    }
    public static void main(String ar[])
    {
        int x[] = {1,52,3,4,-5,6,7};
        int n=x.length;
        showloop(x,n);
        delete(x,n);
        int i; 
        for(i=0;i<n;i++)System.out.print("  "+x[i]);
    }
}