class MedianFinder {
     PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    /** initialize your data structure here. */
    public MedianFinder() {
        left = new PriorityQueue<>(Comparator.reverseOrder());
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(left.size() == 0)
            left.offer(num);
        else{
            int val =left.peek();
            
            if(num > val){
                right.offer(num);
                if(right.size()-left.size() > 1){
                    left.offer(right.poll());
                } 
            }else{
                left.offer(num);
                if(left.size()-right.size() > 1){
                    right.offer(left.poll());
                }
            }
        }
    }
    
    public double findMedian() {
        if(left.size() == right.size())
            return ((double)(left.peek()+right.peek()))/2;
        return (double)(left.size() > right.size() ? left.peek() : right.peek());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */