public class knapsackDP {
    public static int findMax(int a, int b){
        if(a>b){
            return a;
        }
        else{
            return b;
        }
    }
    public static int knapsack(int W, int wt[], int val[], int n){
        int k[][]=new int[n+1][W+1];
        for(int i=0;i<=n;i++){
            for(int w=0;w<=W;w++){
                if(i==0||w==0){
                    k[i][w]=0;
                }
                else if(wt[i-1]<=w){
                    k[i][w]=findMax(val[i-1]+k[i-1][w-wt[i-1]], k[i-1][w]);
                }
                else{
                    k[i][w]=k[i-1][w];
                }
                }
            }
            return k[n][W];
        }
        public static void main(String[] args){
            int[] val = {60, 100, 120};
            int[] wt = {10, 20, 30};
            int W=50;
            int len=val.length;
            System.out.println(knapsack(W, wt, val, len));
        }
    }