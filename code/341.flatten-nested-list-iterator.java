/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    List<NestedInteger> nestedLis;
    Queue<Integer> q;
    int i;
    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedLis = nestedList;
        i = 0;
        q = new LinkedList<Integer>();
        while(i<nestedLis.size()){
        store(nestedLis, i);
            
        i++;
        }
        // System.out.println(nestedList.get(0).getList().get(0).getInteger());
    }

    @Override
    public Integer next() {
        // int nxt = -1;
        // if(q.isEmpty()){
        // store(nestedLis, i);
        // i++;
        // }
        // // System.out.println(q.peek());
        return q.poll();
        // return -1;
    }

    @Override
    public boolean hasNext() {
        return !(q.isEmpty());
    }
    
    public void store(List<NestedInteger> lis, int i){
        
        if(!lis.get(i).isInteger())
        {
            List<NestedInteger> curr = lis.get(i).getList();

            for(int j=0;j<curr.size();j++)
                store(curr, j);

        }
        else
            q.offer(lis.get(i).getInteger());
        
        return;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */