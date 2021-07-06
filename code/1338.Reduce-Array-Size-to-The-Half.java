class Solution {
    public int minSetSize(int[] arr) {
        int[] map = new int[100001];
        
        for(int a: arr)
            map[a]++;
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int i =  100000;
        while(i>0){
            if(map[i] > 0)
                pq.offer(-map[i]);
            i--;
        }
    
        int n = arr.length;
        int res = 0;
        while(n > arr.length/2){
            n += pq.poll();
            res++;
        }
        return res;
    }
}
