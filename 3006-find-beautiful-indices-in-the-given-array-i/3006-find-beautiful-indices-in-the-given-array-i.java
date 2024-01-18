class Solution {
    long[] pr;
    
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> indicesA = new ArrayList<>();
        List<Integer> indicesB = new ArrayList<>();
        pr = new long[500001];
        
        // Find occurrences of pattern 'a' and 'b' using Rabin-Karp
        rabinKarp(s, a, indicesA);
        rabinKarp(s, b, indicesB);
        
        List<Integer> beautifulIndices = new ArrayList<>();

        // Iterate through indices of 'a' occurrences
        for (int i = 0; i < indicesA.size(); i++) {
            int target = indicesA.get(i) + k;

            // Use binary search to find the closest index in 'b' occurrences
            int closestIndexInB = binarySearchClosest(indicesB, target, k, i);

            if (closestIndexInB != -1) {
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

        if (closestIndex == -1) {
            return -1;
        }

        return Math.abs(sortedList.get(closestIndex) - (target - k)) <= k ? i : -1;
    }

    // Rabin-Karp algorithm to find occurrences of a pattern in a string
    private void rabinKarp(String s, String t, List<Integer> ans) {
        int m = s.length();
        int n = t.length();

        int sz = 26;
        int p = Integer.MAX_VALUE;
        long hsh = 0L;
        long hsh1 = 0L;
        int tr = n - 1;
        
        // Calculate initial hashes for both strings
        for (int i = 0; i < Math.min(n, m); i++) {
            long pp = pow(sz * 1L, p, tr);

            hsh1 = mod(hsh1 + mod(gc(s.charAt(i)) * pp));
            hsh = mod(hsh + mod(gc(t.charAt(i)) * pp));
            tr--;
        }

        // Check if the initial hashes match
        if (hsh == hsh1) {
            ans.add(0);
        }

        tr = n - 1;
        int l = 0;
        for (int i = n; i < m; i++) {
            long pp = pow(sz * 1L, p, tr);

            // Update the rolling hash for 's'
            hsh1 = mod(mod(hsh1 - mod(gc(s.charAt(l)) * pp)) * sz);
            hsh1 = mod(hsh1 + mod(gc(s.charAt(i))));

            l++;

            // Check if the rolling hash matches
            if (hsh1 == hsh) {
                ans.add(i - n + 1);
            }
        }
    }

    // Helper method to check if two substrings are equal
    public boolean eq(String t, String s, int st, int end) {
        int i = 0;
        while (st <= end) {
            if (s.charAt(st) != t.charAt(i)) {
                return false;
            }
            st++;
            i++;
        }
        return true;
    }

    // Helper method for exponentiation with caching
    public long pow(long v, int p, int powr) {
        if (pr[powr] != 0L) {
            return pr[powr];
        }
        
        if (powr == 0) {
            return 1;
        }
        if (powr == 1) {
            return v;
        }

        long v1 = (pow(v, p, powr / 2)) % p;
        long v2 = (v1 * v1) % p;

        if (powr % 2 == 0) {
            return pr[powr] = v2;
        }

        return pr[powr] = (v2 * v) % p;
    }

    // Helper method to map characters to integers
    public int gc(char c) {
        return (c - 'a') + 1;
    }

    // Helper method for modular arithmetic
    public long mod(long n) {
        if (n < 0) {
            return n + Integer.MAX_VALUE;
        }
        return n % Integer.MAX_VALUE;
    }
}
