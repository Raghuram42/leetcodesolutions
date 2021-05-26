class Solution {
private static class TrieNode {
    // children[0]: represent bit "1" in the binary representation 
    // children[1]: represent bit "0" in the binary representation 
    private final TrieNode[] children;
    
    private TrieNode() {
        children = new TrieNode[2];
    }
}

private TrieNode root;

public int findMaximumXOR(int[] nums) {
    // initialize the root node
    if(nums.length == 0 )
        return 0;
    root = new TrieNode();
    
    TrieNode curr;
    
    // build the trie 
    for (int num : nums) {
        // starting from root;
        curr = root;
        
        // since every num is positive, their 31th bit is always 0
        // we can ignore that bit and directy build from the 30th bit 
        for (int i = 30; i >= 0; --i) {
            int bit = getIthBit(num, i);
            
            // if current bit is 0, it will go to children[1]
            // if current bit is 1, it will go to children[0]
            if (curr.children[bit ^ 1] == null) {
                curr.children[bit ^ 1] = new TrieNode();
            }
            
            curr = curr.children[bit ^ 1];
        }
    }
    
    int ans = Integer.MIN_VALUE;
    
    // iterate through each num again
    // starting from those significant bits of num, we try the best 
    // to go to the node that represent the negation of current bit 
    // if such node doesn't exist, we have to go the node that represents
    // the current bit 
    for (int num : nums) {
        // starting from root
        curr = root;
        
        // keep track of the maximum result of XOR current num with 
        // other num in the array
        int rst = 0;
        for (int i = 30; i >= 0; --i) {
            int bit = getIthBit(num, i);
            
            // check to see if node that represents the negation of 
            // current bit exists or not. If exists, go to that way 
            
            // if current bit is 1, then we want to go to children[1] (which represents 0)
            // if current bit is 0, then we want to go to children[0] (which represents 1)
            if (curr.children[bit] != null) {
                curr = curr.children[bit];
                
                // if exists, then we will have a "1" at the current index
                // in the result of maximum XOR 
                rst += (1 << i);
            } 
            // if not exists
            else {
                curr = curr.children[bit ^ 1];
            }
        }
        
        // keep track of global maximum 
        ans = Math.max(ans, rst);
        // there is no need to continue when final result has reached max value 
        if (ans == Integer.MAX_VALUE) break;
    }
    
    return ans;
}

// get the ith bit (count from LSB, 0-based) of num
private int getIthBit(int num, int i) {
    return (num & (1 << i)) == 0 ? 0 : 1;
}

}