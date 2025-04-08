import java.util.*;
public class McMsS{
    static int bracket[][];
    static int dp[][];
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int dims[]=new int[n];
        for(int i=0;i<n;i++){
            dims[i]=sc.nextInt();
        }
        
        dp=new int[n][n];
        bracket=new int[n][n];
        for(int i=1;i<=n-1;i++){
            dp[i][i]=0;
        }
        for(int i=n-1;i>=1;i--){
            for(int j=i+1;j<=n-1;j++){
                int mini=Integer.MAX_VALUE;
                for(int k=i;k<=j-1;k++){
                    int steps=dp[i][k]+dp[k+1][j]+dims[i-1]*dims[k]*dims[j];
                    if(steps<mini){
                        mini=steps;
                        bracket[i][j]=k;
                    }
                }
                dp[i][j]=mini;
            }
        }
        System.out.println(dp[1][n-1]);
        String name[]=new String[n-1];
        
        for(int i=0;i<=n-2;i++){
            name[i]="A"+(i+1);
        }
        helper(1,n-1,name);
    }
    
    public static void helper(int i, int j ,String[] name){
        if(i==j){
            System.out.print(name[i-1]);
            return;
        }
        System.out.print("(");
        helper(i,bracket[i][j], name);
        helper(bracket[i][j]+1, j, name);
        System.out.print(")");
    }
}