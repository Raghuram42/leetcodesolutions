class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();
        int i=1;
        while(i <=n)
            que1.offer(i++);
        int p = 1;
        while(que1.size()+que2.size() > 1){
        
            if(que1.size() == 0){
                Queue<Integer> t = que2;
                que2 = que1;
                que1 = t;
            }
            if(p%k != 0)
                que2.offer(que1.poll());
            else 
                que1.poll();
            p++;
        }
        
        if(que1.size() == 0)
            return que2.poll();
        
        return que1.poll();
    }
}