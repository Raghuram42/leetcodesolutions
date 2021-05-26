class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] primes = { 3, 7, 11, 17, 23, 29, 37,
                                                47, 59, 71, 89, 107, 131,
                                                163, 197, 239, 293, 353,
                                                431, 521, 631, 761, 919,
                                                1103, 1327, 1597, 1931,
                                                2333, 2801, 3371, 4049,
                                                4861, 5839, 7013, 8419,
                                                10103, 12143, 14591, 17519,
                                                21023, 25229, 30293, 36353,
                                                43627, 52361, 62851, 75431,
                                                90523, 108631, 130363,
                                                156437, 187751, 225307,
                                                270371, 324449, 389357,
                                                467237, 560689, 672827,
                                                807403, 968897, 1162687,
                                                1395263, 1674319, 2009191,
                                                2411033, 2893249, 3471899,
                                                4166287, 4999559, 5999471,
                                                7199369};
        ArrayList<Integer> res = new ArrayList();
        int curr_sum = 0;
        int curr_len = 0;
        if(p.length() > s.length())
            return new ArrayList();
        int sum = 0;
        for(int i=0;i<p.length();i++){
            sum += primes[p.charAt(i) - 'a'];
            curr_sum += primes[s.charAt(i) - 'a'];
        }
        if(sum == curr_sum){
            res.add(0);
       //     System.out.println(res.get(0));
        }
        System.out.println(curr_sum +" "+sum);
        for(int i=p.length();i<s.length();i++){
            curr_sum += primes[s.charAt(i) - 'a'];
            curr_sum -= primes[s.charAt(i-p.length()) - 'a'];
            //curr_len;
            if(curr_sum == sum){
                //curr_len--;
                res.add(i-p.length()+1);
            }
        }
        
        return res;
        
    }
}