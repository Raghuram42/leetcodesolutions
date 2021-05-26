class Solution {
    public String toGoatLatin(String S) {
         String vowel = "aeiouAEIOU";//{'a','e','i','o','u'};
        String[] strArr = S.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strArr.length; i ++){

            String cur = strArr[i];
            if(vowel.indexOf(cur.charAt(0)) >= 0){
                sb.append(cur);
                sb.append("ma");
            }else{
                sb.append(cur.substring(1, cur.length()));
                sb.append(cur.charAt(0));
                sb.append("ma");
            }

            for(int j = 0; j < i + 1; j ++){
                sb.append("a");
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}