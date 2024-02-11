class Solution {
    public int maxPalindromesAfterOperations(String[] words) {
        Integer[] map = new Integer[26];
        Arrays.fill(map, 0);
        int n = words.length;
        List<Integer> li = new ArrayList<>();
        
        for(int i=0;i<n;i++){
                            String s = words[i];
            for(int j=0;j<words[i].length();j++){
                map[s.charAt(j)-'a']++;
            }
            li.add(words[i].length());
        }
        
        Collections.sort(li);
        
        int ans = 0;
        Arrays.sort(map);
        // int j = 0;
        // while(map[j] == 0)
        //     j++;
        
        // System.out.println(li+" "+Arrays.toString(map));
        int even = 0;
        int odd = 0;
        
        
        // for(int i=0;i)
        for(int next: map){
            if(next%2 == 1 )
                odd++;
            even += (next-next%2);
        }
        
        int i =0;
        
        n = li.size();
        // System.out.println(even +" "+odd);
        while(i<n){
            int val = li.get(i);
            int j = 0;
          
            if(val%2 == 1){
                if(odd > 0){
                odd--;
                val--;
            }
            }
            if(val <= even){
                ans++;
                even -= val;
            }else{
                break;
            }
            i++;
        }
           
        
        
        return ans;
        
        
    }
}