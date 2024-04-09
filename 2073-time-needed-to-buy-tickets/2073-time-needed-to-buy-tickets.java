class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        
        int n= tickets.length;
        while(true){
            for(int i=0;i<n;i++){
                if(tickets[i] > 0){
                tickets[i]--;
                time++;
                }
                if(i == k && tickets[i] == 0)
                    return time;
            }
            
            
            
        }
        
        // return time;
    }
}