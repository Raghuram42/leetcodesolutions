/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public NestedInteger deserialize(String s) {
        NestedInteger res = new NestedInteger();
        if(s.length() == 0)
            return res;
        if(s.charAt(0) != '[')
            return new NestedInteger(Integer.parseInt(s));
        Deque<NestedInteger> stk = new ArrayDeque<NestedInteger>();
        
        NestedInteger nextres = res;
        NestedInteger curr = res;
        // int num = 0;
        int sig = 1;
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i) == '-')
                sig = -1;
            else
            if(s.charAt(i) == '[')
                stk.push(new NestedInteger());
            
            else if(s.charAt(i) == ']'){
                NestedInteger pp = stk.pop();
                // System.out.println(i+" pop" );
                    stk.peek().add(pp);
            }
                else if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                    int num = 0;
                    while (Character.isDigit(s.charAt(i)))
                     num = num*10 + (s.charAt(i++)-'0');
                 NestedInteger n = new NestedInteger(num * sig);
                 stk.peek().add(n);
                // System.out.println(i+" "+num);
                    if(s.charAt(i) == ']')
                      i--;
                sig = 1;
                }
        }
        return stk.peek();
        // return res;
    }
}