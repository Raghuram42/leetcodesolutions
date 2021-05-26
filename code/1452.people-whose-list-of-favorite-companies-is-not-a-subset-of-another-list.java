class Solution {
    public List<Integer> peopleIndexes(List<List<String>> favorites) {
        List<Set<String>> ppl = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int n = favorites.size();
        for(List<String> s : favorites) ppl.add(new HashSet<>(s));
        for(int i=0;i<n;i++) {
            boolean valid = true;
            for(int j=0;j<n && valid;j++) {
                if(i == j) continue;
                if(ppl.get(j).containsAll(ppl.get(i))) valid = false;
            }
            if(valid) res.add(i);
        }
        return res;
    }
}