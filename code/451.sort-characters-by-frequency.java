import java.util.*;
class Solution {
    public String frequencySort(String s) {
        if(s.length() <= 1)
            return s;
        int[] charFre = new int[122];
        HashMap<Character, Integer> hsm = new HashMap<Character, Integer>();
        
        for(int i=0;i<s.length();i++){
            //System.out.println(s.charAt(i)+" "+hsm.containsKey(s.charAt(i)) + " "+(hsm.getOrDefault(hsm.get(s.charAt(i)) ,0)+1));
            if(hsm.containsKey(s.charAt(i)))
                hsm.put(s.charAt(i), hsm.get(s.charAt(i))+1);
            else
                hsm.put(s.charAt(i), 1);
                //hsm.put(s.charAt(i), (int)(hsm.getOrDefault(hsm.get(s.charAt(i)) ,0))+1);
                
        }
   //   System.out.println(hsm);
      List<Map.Entry<Character, Integer>> list = new LinkedList<Map.Entry<Character, Integer>>(hsm.entrySet());

		//sorting the list with a comparator
		Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
			public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});
        StringBuilder str = new StringBuilder();
        for(int i=list.size()-1;i>=0;i--){
            int k = list.get(i).getValue(); 
            while(k != 0){
                str.append(list.get(i).getKey());
                k--;
            }
        }
        
//         int[] Fre = new int[s.length()];
//         int p = 0;
        
        
//         //StringBuilder str = new StringBuilder();
//         for(int i=0;i<122;i++){
//             while(charFre[i] != 0){
//             str.append((char)(i+'A'));
//                 charFre[i]--;
//                 }
            
//         }
        return str.toString();
    }
}