class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int minPrice = INT_MAX;
        int maxPrice = 0;

        for(int i : prices) {
            minPrice = min(minPrice, i);
            maxPrice = max(maxPrice, i - minPrice);
        }

        return maxPrice;
    }
};
