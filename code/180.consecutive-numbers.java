class Solution {
    public String largestNumber(int[] nums) {
        
        String[] str = new String[nums.length];
        int zers = 0;
        for(int i=0;i<nums.length;i++){
            str[i] = nums[i]+"";
            if(nums[i] == 0)
                zers++;
        }
        if(zers == nums.length)
            return "0";
        Arrays.sort(str, new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                    return (a+b).compareTo(b+a);
            }
        });
        StringBuilder str2 = new StringBuilder();
        for(int i=str.length-1;i>=0;i--)
            str2.append(str[i]);
       //     System.out.println(str[i]);
        
        return str2.toString();
        
    }
}