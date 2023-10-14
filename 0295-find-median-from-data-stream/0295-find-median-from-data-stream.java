class MedianFinder {
    PriorityQueue<Integer> pqMax;
    PriorityQueue<Integer> pqMin;
    public MedianFinder() {
        pqMax = new PriorityQueue<Integer>(Collections.reverseOrder());
        pqMin = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        if(pqMax.size() == 0)
            pqMax.offer(num);
        // else if(pqMin.size() == 0)
        //     pqMin.offer(num);
        else if(num <= pqMax.peek()){
            pqMax.offer(num);
            
            while(pqMin.size()+1 < pqMax.size())
                pqMin.offer(pqMax.poll());
        }else{
            pqMin.offer(num);
            
            while(pqMax.size() < pqMin.size())
                pqMax.offer(pqMin.poll());
        }
    }
    
    public double findMedian() {
        if((pqMax.size()+pqMin.size())%2 == 0)
            return (pqMax.peek()+0d+pqMin.peek())/2;
        
        return pqMax.peek()+0d;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */