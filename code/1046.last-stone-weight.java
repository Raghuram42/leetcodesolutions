class Solution {
    public int lastStoneWeight(int[] stones) {
        
        if(stones.length <= 2)
            return stones.length == 1 ? stones[0] : (stones[0] == stones[1] ? 0 : Math.abs(stones[0]-stones[1]));
        PriorityQueue<Integer> pQ = new PriorityQueue<Integer>(10, new Comparator<Integer>() {
    @Override
    public int compare(Integer a, Integer b) {
        return b - a; 
    }
}); 
        
        for(int i =0 ;i<stones.length;i++)
            pQ.add(stones[i]);
        
        while(pQ.size() > 1){
            int a = pQ.poll();
            int b = pQ.poll();
            
            if(a != b)
                pQ.add(a-b);
        }
        
        return pQ.size()==1?pQ.poll():0;
    }
}