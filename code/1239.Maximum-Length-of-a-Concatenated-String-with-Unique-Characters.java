class Solution {
    public int maxLength(List<String> arr) {
        return solve(arr , 0, new int[26]);
    }
    
    public int solve(List<String> arr, int i, int[] map){
        if(i>=arr.size())
           return 0;
           
        int with = 0;
        int k = 0;
        for(k=0;k<arr.get(i).length();k++){
           if(map[arr.get(i).charAt(k)-'a'] == 1) 
               break;
            map[arr.get(i).charAt(k)-'a']++;
        }
        if(k == arr.get(i).length())   
           with = arr.get(i).length()+solve(arr, i+1, map);
          k--;
        for(;k>=0;k--)
            map[arr.get(i).charAt(k)-'a']--;
        
         return Math.max(with, solve(arr, i+1, map));
    }
}
