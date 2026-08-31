public class Insertion_Sort
{
    static void display(int x[], int n)
    {
        int i;
        for(i=0; i<n; i++)
        {
            System.out.print(" "+x[i]);
        }
        System.out.println();
        System.out.println();
    }
    static void show(int x[], int n)
    {
        int i, j, value;
        for(i=1;i<n;i++)
        {
            value = x[i];
            for(j=i;j>0;j--)
            {
                if(x[j-1]>value)
                {
                    x[j]=x[j-1];
                }
                else break;
            }
            x[j]=value;
            display(x, n);
        }
    }
    public static void main(String[] args)
    {
        int x[] = {56, 29, 35, 42, 15, 41, 75, 21};
        int n = x.length;
        display(x,n);
        show(x,n);
    }
}