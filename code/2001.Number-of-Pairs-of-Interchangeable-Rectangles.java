class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        HashMap<Double, Long> map = new HashMap<>();
        long res = 0;
        for(int[] r: rectangles){
            double key = r[0]/(r[1]+0d);
            
            map.put(key, map.getOrDefault(key, 0l)+1);
        }
        
        for(double k: map.keySet())
            res += ((map.get(k)-1l)*(map.get(k)))/2;
        
        return res;
    }
}
