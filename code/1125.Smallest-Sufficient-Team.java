class Solution {
    class Pair{
        int c;
        List<Integer> ans;
        Pair(int c, List<Integer> ans){
            this.c = c;
            this.ans = ans;
        }
        @Override
        public String toString(){
            return this.c+" res array "+this.ans;
        }
    }
    int sz;
    Pair[][] dp;
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        HashMap<String, Integer> skilsInt = new HashMap<>();
        sz = req_skills.length;
        int i = 0;
        int n = req_skills.length;
        dp = new Pair[people.size()][65537];
        while( i <  n){
            skilsInt.put(req_skills[i], i++);
        }
        
        int ps = people.size();
        int[] peopleSkills = new int[ps];
        for( i=0;i<ps;i++){
            int skilv = 0;
            for(String next: people.get(i))
                skilv = skilv | (1<<skilsInt.get(next));
            peopleSkills[i] = skilv;
            // System.out.println(i+" "+skilv);
        }
        Pair res = solve(peopleSkills, 0, 0);
        // System.out.println(res);
        // int[] r = new int[res.ans.size()];
        // for(i=0;i<res.ans.size();i++)
        //     r[i] = res.ans.get(i);
        return res.ans.stream().mapToInt(ip->ip).toArray();//res.ans.toArray(new int[0]);
        
    }
    
    public Pair solve(int[] people, int i, int mask){
        if(mask == (1<<sz)-1)
            return new Pair(0, new ArrayList<Integer>());
        if(i>=people.length)
            return new Pair(Integer.MAX_VALUE/2, new ArrayList<Integer>());
        
        if(dp[i][mask] != null)
            return dp[i][mask];
        int nextmask = (people[i]) | mask;
        // System.out.println(i+" i m "+mask+" nm "+nextmask);
        Pair ans = new Pair(1, new ArrayList<Integer>());
        ans.ans.add(i);
        Pair res = null;
        if(nextmask != mask){
            res = solve(people, i+1, nextmask);
        }else 
            return dp[i][mask] =solve(people, i+1, mask);
        
        ans.c += res.c;
        ans.ans.addAll(res.ans);
        Pair WOnext = solve(people, i+1, mask);
        if(ans.c > WOnext.c)
            return dp[i][mask] =WOnext;
        // res = Math.min(res, );
        
        return dp[i][mask]=ans;
        
    }
}
