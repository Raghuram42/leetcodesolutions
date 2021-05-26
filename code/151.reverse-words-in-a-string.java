class Solution {
    public String reverseWords(String s) {
        s= s.trim();
        
        if(s.length() == 0)
            return "";
        //StringBuilder str = new StringBuilder();
        
        String[] arr = s.split(" ");
        String res = "";
        
        for(int i=arr.length-1;i>=0;i--){
            //System.out.println(arr[i]);
            if(arr[i].length() !=0)
            res = String.join(" ", res, arr[i]);
            // res = arr[i];
            // arr[i] = arr[arr.length-1-i];
            // arr[arr.length-1-i] = res;
        }
        return res.substring(1, res.length());
    }
}