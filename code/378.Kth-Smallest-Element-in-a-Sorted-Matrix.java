class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        int n = matrix.length;
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int i = 0;
        int j = 0;
        
        while(i<n){
            j = 0;
            
            while(j<n){
                pq.offer(-matrix[i][j++]);
                
                if(pq.size() > k)
                    pq.poll();
            }
            
            i++;
        }
        return -pq.peek();
    }
}
