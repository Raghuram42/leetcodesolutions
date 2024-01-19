class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        
        // Initialize arrays to store binary representations of 'k' and each 'num' in 'nums'
        int[] targetBinary = new int[32];
        int[] numBinaries = new int[32];
        
        // Convert 'k' and each 'num' to binary representation
        setBinary(k, targetBinary);
        for (int num : nums)
            setBinary(num, numBinaries);
        
        int ans = 0;
        
        // Compare the binary representations and count the differing bits
        for (int i = 0; i < 32; i++) {
            if (targetBinary[i] != numBinaries[i] % 2) {
                ans++;
            }
        }
        
        return ans;
    }
    
    // Helper function to convert an integer 'n' to binary representation and store it in array 'm'
    public void setBinary(int n, int[] m) {
        int i = 0;
        
        while (n > 0 && i < 32) {
            m[i] += n & 1; // Add the least significant bit to the array
            n >>= 1; // Right shift 'n' to process the next bit
            i++;
        }
    }
}
