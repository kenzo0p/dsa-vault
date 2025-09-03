
class Solution
{
public:
    int rec(int i, int buy, vector<int> &prices, vector<vector<int>> &dp)
    {
        if (i >= prices.size())
        {
            return 0;
        }

        if (dp[i][buy] != -1)
        {
            return dp[i][buy];
        }
        int ans;
        if (buy == 0)
        {
            //agar aaj mene kharida hain to future mein selling function call aur kitna profit ajj ki selling - profit
            int buyStock = rec(i + 1, 1, prices, dp) -prices[i]; //selling ka function call  agar aaj buy karunga to -> selling - buy == profit
            int skip = rec(i + 1, 0, prices, dp);

            ans = max(skip, buyStock);
        }
        else
        {
            //sell karunga wo price + kardo
            //sell kiya hain to aage buy ka function call kardo buy = 0
            int sell = prices[i] + rec(i + 2, 0, prices, dp);//i + 2 as cooldown period is 2
            int skip = rec(i + 1, 1, prices, dp);//agar aaj sell nahi kiya to aage bhi sell hi karna padega

            ans = max(skip, sell);
        }

        dp[i][buy] = ans;
        return ans;
    }
    int maxProfit(vector<int> &prices)
    {
        int n = prices.size();
        vector<vector<int>> dp(n, vector<int>(2, -1));

        return rec(0, 0, prices, dp);
    }
};

//bottom up java

/*
    t[i] = max total profit until day i

                sell        buy
    profit = prices[i] - prices[j]


    t[i] = profit + prevProfit

    ❌(j-1)    ✅j (buy) kiya hain to j-1 nahi kiya hoga woo cooldown day hoga so t[j-2] prevTotal


*/

//dry run [1,4,2]
  public int maxProfit(int[] prices) {
    int n = prices.length;
    if(n==0 || n==1){
        return 0;
    }

    int t[] = new int[n];
    //t[i]= max total profit unit day i

    t[0] = 0;
    t[1] = Math.max(prices[1] - prices[0] , 0);

    for(int i=2;i<n;i++){ //sell
        t[i] = t[i-1];
        //t[i] ko bharana hain

        for(int j = 0;j<=i-1;j++){
            int todayProfit = prices[i] - prices[j];
            int prevProfit = t[j-2]; //why j-2 ?  think
            /*
                kyonki jth day mein mai buy kar rah
                so,
                j - 1 ko sell nahi kar sakta kyunki cooldown
                j-1 ko buy bhi nahi kar sakta
                j-1 cooldown
            */
            t[i] = Math.max(t[i] ,todayProfit + prevProfit);
        }

    }


    return t[n-1];

  }