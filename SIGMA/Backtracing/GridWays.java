public class GridWays {
    public static int gridWays(int i , int j , int n , int m){
        if(i==n-1 && j ==m-1){//condition for lastcell
            return 1;
        }else if(i==n || j==n){
            return 0;
        }
        int w1 = gridWays(i+1, j, n, m);
        int w2 = gridWays(i, j+1, n, m);
        return w1+w2;
    }

    public static int uniquePath(int m, int n){
        long res = 1;//result
        int small = Math.min(n-1 , m-1);//choose smaller value to optimize
        int total = (m-1)+(n-1);//total steps
        for(int i = 1;i<=small;i++){
            res = res*(total  - i +1)/i;//compute 
        }
        return (int) res;//safe conversion to int
    }
    public static void main(String[]args){
        int n = 3 ,m=3;
        System.out.println(gridWays(0, 0, n, m));
        System.out.println(uniquePath(10 , 10));
    }
}
