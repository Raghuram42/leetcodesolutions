class Solution {
    public int compress(char[] chars) {
        int ans = 0;
        
        int i = 0;
        int n = chars.length;
        int st = 0;
        while(i<n){
            int count = 0;
            char curr = chars[i];
            ans++;
            while(i<n && curr == chars[i]){
                i++;
                count++;
                if(count == 2 || count == 10 || count == 100 || count == 1000)
                    ans++;
            }
            
            chars[st++] = curr;
            int len = 0;
            if(count > 1){
            if(count < 10)
                len = 1;
            else if(count < 100)
                len = 2;
            else if(count < 1000)
                len = 3;
            else
                len = 4;
            int p = st+len-1;
            while(count > 0){
                chars[p--] = (char)((count%10)+'0');
                count = count/10;                
            }
            st = st+len;
            }
        }
        
        
        return ans;
    }
}