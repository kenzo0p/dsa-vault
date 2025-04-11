
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
            int skip = rec(i + 1, 0, prices, dp);
            int buyStock = -prices[i] + rec(i + 1, 1, prices, dp);

            ans = max(skip, buyStock);
        }
        else
        {
            int skip = rec(i + 1, 1, prices, dp);
            int sell = prices[i] + rec(i + 2, 0, prices, dp);

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