class Solution {
    public int minCostToMoveChips(int[] position) {
        HashMap<Integer, Integer> hsm = new HashMap<Integer, Integer>();
        int oddmaxvalpos = -1;
        int oddval = -1;
        
        int evenmaxvalpos = -1;
        int evenval = -1;
        
        for(int i=0;i<position.length;i++){
            // if(!hsm.containsKey(position[i]))
                hsm.put(position[i], hsm.getOrDefault(position[i], 0)+1);
            
            if(oddval < hsm.get(position[i]) && position[i]%2 == 1){
                oddval = hsm.get(position[i]);
                oddmaxvalpos = position[i];
            }
            
             if(evenval < hsm.get(position[i]) && position[i]%2 == 0){
                evenval = hsm.get(position[i]);
                evenmaxvalpos = position[i];
            }
        }
        System.out.println(evenmaxvalpos+" "+oddmaxvalpos);
        int evencost = 0;
        int oddcost = 0;
        for(int i=0;i<position.length;i++){
            if(oddmaxvalpos != position[i] && Math.abs(position[i]-oddmaxvalpos)%2 == 1)
                oddcost++;
            if(evenmaxvalpos != position[i] & Math.abs(position[i]-evenmaxvalpos)%2 == 1)
                evencost++;
        }
        return Math.min(evencost, oddcost);
        
    }
}