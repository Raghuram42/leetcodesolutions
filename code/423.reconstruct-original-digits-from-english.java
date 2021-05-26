class Solution {
    public String originalDigits(String s) {
        int[] mapr = new int[26];
        
        int sz = s.length();
        for(int i=0;i<s.length();i++)
            mapr[s.charAt(i)-'a']++;
        
        String[] digits = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        StringBuilder res = new StringBuilder();
        
        int[] sort = new int[10];
        
        for(int i=0;i<s.length();i++){
        if(s.charAt(i) == 'z')
            sort[0]++;
        if(s.charAt(i) == 'w')
            sort[2]++; 
            if(s.charAt(i) == 'g')
            sort[8]++;
            if(s.charAt(i) == 'x')
            sort[6]++;
            if(s.charAt(i) == 'v')
            sort[5]++;
            if(s.charAt(i) == 'o')
            sort[1]++;
            if(s.charAt(i) == 's')
            sort[7]++;
            if(s.charAt(i) == 'f')
            sort[4]++;
            if(s.charAt(i) == 'h')
            sort[3]++;
            if(s.charAt(i) == 'i')
            sort[9]++;
        
        }
            
        
        sort[7] -= sort[6]; 
        sort[5] -= sort[7]; 
        sort[4] -= sort[5]; 
        sort[1] -= (sort[2]+sort[4]+sort[0]);
        sort[3] -= sort[8]; 
        sort[9] -= (sort[5]+sort[6]+sort[8]);
        
        
        
        
        
        for(int i=0;i<10;i++)
        {
            while(sort[i] > 0){
                res.append(i);
                sort[i]--;
            }
        }
        return res.toString();
    }
}