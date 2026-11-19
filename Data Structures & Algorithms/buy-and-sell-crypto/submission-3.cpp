class Solution {
public:
    int maxProfit(vector<int>& prices) {
        if(prices.size() < 2) return 0;

        int res = 0;
        int l = 0;

        int cur = 0;
        for(int r = 0; r < prices.size(); r++){
            if(prices[r] < prices[l]) {
                l = r;
                continue;
            }

            res = max(res, prices[r] - prices[l]);
        }


        return res;
    }
};
