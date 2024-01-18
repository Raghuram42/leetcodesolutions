class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> indicesA = new ArrayList<>();
        List<Integer> indicesB = new ArrayList<>();
        
        // Find indices of occurrences of string 'a' in 's'
        for (int i = 0; i <= s.length() - a.length(); i++) {
            if (s.substring(i, i + a.length()).equals(a)) {
                indicesA.add(i);
            }
        }
        
        // Find indices of occurrences of string 'b' in 's'
        for (int i = 0; i <= s.length() - b.length(); i++) {
            if (s.substring(i, i + b.length()).equals(b)) {
                indicesB.add(i);
            }
        }
        
        List<Integer> beautifulIndices = new ArrayList<>();
        
        // Iterate through indices of 'a' occurrences
        for (int i = 0; i < indicesA.size(); i++) {
            int target = indicesA.get(i) + k;
            
            // Use binary search to find the closest index in 'b' occurrences
            int closestIndexInB = binarySearchClosest(indicesB, target, k, i);
            
            if (closestIndexInB >=0 ) {
                beautifulIndices.add(indicesA.get(i));
            }
        }
        
        return beautifulIndices;
    }
    
    // Binary search for finding the closest index in a sorted list
    private int binarySearchClosest(List<Integer> sortedList, int target, int k, int i) {
        int left = 0;
        int right = sortedList.size() - 1;
        int closestIndex = -1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (sortedList.get(mid) <= target) {
                closestIndex = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        // return closestIndex;
                return closestIndex != -1 && Math.abs(sortedList.get(closestIndex)-(target-k)) <= k ? i : -1;

    }
}
