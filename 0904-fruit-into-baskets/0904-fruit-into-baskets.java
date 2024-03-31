class Solution {
    public int totalFruit(int[] fruits) {
        int ans = 0;
        
        int st = 0;
        int end = 0;
        
        int n = fruits.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(end < n){
            
                while(map.size() == 2 && !map.containsKey(fruits[end])){
                    map.put(fruits[st], map.get(fruits[st])-1);
                    if(map.get(fruits[st]) == 0)
                        map.remove(fruits[st]);
                    st++;
                }
                
            map.put(fruits[end], map.getOrDefault(fruits[end], 0)+1);
            
            ans = Math.max(ans, end-st+1);
            end++;
        }
        
        return ans;
    }
}