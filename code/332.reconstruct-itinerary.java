// class Solution {
//     List<String> re ;
//     HashMap<String, ArrayList<String>> res;
//     HashSet<String> vis;
//     public List<String> findItinerary(List<List<String>> tickets) {
//         res = new HashMap<String, ArrayList<String>>();
        
//         for(List<String> place: tickets){
//             if(!res.containsKey(place.get(0)))
//             res.put(place.get(0), new ArrayList<String>());
            
//             res.get(place.get(0)).add(place.get(1));
//         }
//         Collections.sort(res.get("JFK"));
//         System.out.println(res);
//         re =  new ArrayList<String>();
//         vis = new HashSet<String>();
//         dfs("JFK");
//         //re.add("JFK");
//         return re;
//     }
    
//     public void dfs(String i){
//         //re.add(i);
//        // System.out.println(i);
//         if(!res.containsKey(i) || vis.contains(i)){
//          //re.add(i);
//             return;
//         }
//         for(String str: res.get(i)){
//             vis.add(i);
//             dfs(str);
//             re.add(str);
//         }
        
        
//     }
// }


public class Solution{
	HashMap<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
	LinkedList<String> result = new LinkedList<String>();
 
	public List<String> findItinerary(List<List<String>> tickets) {
		for (List<String> ticket : tickets) {
			if (!map.containsKey(ticket.get(0))) {
				PriorityQueue<String> q = new PriorityQueue<String>();
				map.put(ticket.get(0), q);
			}
			map.get(ticket.get(0)).offer(ticket.get(1));
		}
 
		dfs("JFK");
		return result;
	}
 
	public void dfs(String s) {
		PriorityQueue<String> q = map.get(s);
 
		while (q != null && !q.isEmpty()) {
			dfs(q.poll());
		}
 
		result.addFirst(s);
	}
}