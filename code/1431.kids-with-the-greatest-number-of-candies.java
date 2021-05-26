class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        ArrayList<Boolean> res = new ArrayList<Boolean>();
        
        if(candies.length == 0)
            return res;
        
        int max_v = candies[0];
        for(int a : candies){
            if(max_v < a)
                max_v = a;
        }
        
        
        for(int a : candies){
            if(a+extraCandies >= max_v)
                res.add(true);
            else
                res.add(false);
        }
        return res;
    }
}