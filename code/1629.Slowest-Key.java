class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int dur = releaseTimes[0];
        char key = keysPressed.charAt(0);
        int n = keysPressed.length();
        for(int i=1;i<n;i++){
            
            if(dur <= releaseTimes[i]-releaseTimes[i-1])
            {
                if(dur == releaseTimes[i]-releaseTimes[i-1])
                    key = (char)Math.max((int)key, (int)keysPressed.charAt(i));
                else
                key = keysPressed.charAt(i);
                dur = releaseTimes[i]-releaseTimes[i-1];
            }
            
        }
        return key;
    }
}
