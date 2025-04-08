import java.util.*;
public class OBST 
{
    public static int obstvalue(int n,int[] ele, int[] freq)
    {
        int[][] cost=new int[n][n];
            for(int i=0;i<n;i++)
            {
                cost[i][i]=freq[i];
            }
            for(int l=2;l<=n;l++)
            {
                for(int i=0;i<=n-l;i++)
                {
                    int j=i+l-1;
                    int fusm=sum(freq,i,j);
                    cost[i][j]=Integer.MAX_VALUE;
                    for(int k=i;k<=j;k++)
                    {
                        int c=((k>i)?cost[i][k-1]:0)+((k<j)?cost[k+1][j]:0)+fusm;
                        if(c<cost[i][j])
                        {
                            cost[i][j]=c;
                        }
                    }
                }
            }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(cost[i][j]+" ");
            }
            System.out.println();
        }
        return cost[0][n-1];
    }

    public static int sum(int[] freq, int i, int j){
        int s=0;
        for(int k=i;k<=j;k++)
        {
            s+=freq[k];
        }
        return s;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] ele=new int[n];
        int[] freq=new int[n];
        for(int i=0;i<n;i++){
            ele[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            freq[i]=sc.nextInt();
        }
        System.out.println("Minimum cost of OBST is: "+obstvalue(n,ele,freq));
    }
}