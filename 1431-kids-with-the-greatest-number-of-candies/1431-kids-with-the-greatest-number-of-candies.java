class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
        
        
        int max = 0;
        
        for(int c: candies)
            max = Math.max(c, max);
        int n = candies.length;
        for(int i=0;i<candies.length;i++)
            res.add(candies[i]+extraCandies >= max);
        
        return res;
    }
}