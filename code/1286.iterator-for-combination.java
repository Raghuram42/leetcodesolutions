class CombinationIterator {
    
    Stack<Character> st; // stack to store the characters leading to the creation of a single combination
	Map<Character, Integer> ch2Idx; // map to store character to index
    String result, str; // str - same as characters. result -- the result string representing a combination
    int combLength; // same as combinationLength
 
    public CombinationIterator(String characters, int combinationLength) {
        combLength = combinationLength;
        ch2Idx = new HashMap();
        str = characters;
        st = new Stack();
        result = "";
		// create the first combination
        for (Character ch : characters.toCharArray()) {
            st.push(ch);
            result = result + ch;
            if (st.size()==combinationLength) break;
        }
        int idx = 0;
		// set up the mapping between character --> index
        for (Character ch : characters.toCharArray()) {
            ch2Idx.put(ch, idx++);
        }
    }
    
    public String next() {
        String currResult = result;
        // process the next result
      
        int idx = str.length()-1;
		// keep on removing the last character from the stack/result till the position where idx can be moved ahead
        while (!st.isEmpty() && ch2Idx.get(st.peek())==idx) {
            st.pop();
            idx--;
            result = result.substring(0, result.length()-1);  
        }
        if (st.isEmpty()) return currResult; // there is no next result to pre-process
        
        idx = ch2Idx.get(st.pop()); // we need to add elements after this idx
        result = result.substring(0, result.length()-1);
        
        while (st.size()!=combLength) {
            Character temp = str.charAt(++idx);
            result+=temp;
            st.push(temp);
        }
        
        return currResult;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
}