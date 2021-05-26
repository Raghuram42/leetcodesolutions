class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        //int[] mapr = new int[];
        //ArrayList<Integer> sums = new ArrayList<Integer>();
        
       HashMap<String, List<String>> hsm = new HashMap<String,List<String>>();
        for(String i : strs){
        int[] checkr = new int[26];
            for(char c : i.toCharArray() )
                checkr[c - 'a']++;
            StringBuilder str = new StringBuilder("");
            for(int k=0;k<26;k++)
                str.append(checkr[k]);
            String t = str.toString();
            System.out.println(t);
            if(!hsm.containsKey(t)) hsm.put(t, new ArrayList());
            hsm.get(t).add(i);
        }
        for (Map.Entry<String, List<String>> entry : hsm.entrySet()) 
            res.add(entry.getValue());

        return res;
        
    }
}