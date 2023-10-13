class Solution {
    public int leastInterval(char[] tasks, int n) {
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(char c: tasks)
        {
            map.put(c, map.getOrDefault(c, 0)+1);
            max = Math.max(max, map.get(c));
        }
        
        int count = 0;
        
        for(Character c: map.keySet())
            if(map.get(c) == max)
                count++;
        
        return Math.max(tasks.length, (max-1)*n+max+(count-1));
    }
}