class Solution {
    HashMap<String, List<String>> graph;
    HashMap<String, Boolean> canMake;
    HashSet<String> sup;
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int n = recipes.length;
        canMake = new HashMap<>();
        
        graph = new HashMap<>();
        
        sup = new HashSet<>();
        for(String s: supplies)
            sup.add(s);
        
        for(int i=0;i<n;i++)
            graph.put(recipes[i], ingredients.get(i));
        // System.out.println(graph);
        for(int i=0;i<n;i++)
            makeRec(recipes[i]);
        List<String> res = new ArrayList<>();
        
        for(int i=0;i<n;i++)
            if(canMake.containsKey(recipes[i]) && canMake.get(recipes[i]))
                res.add(recipes[i]);
        
        return res;
    }
    
    
    public boolean makeRec(String ingre){
        // System.out.println(ingre);
        if(sup.contains(ingre))
            return true;
        if(canMake.containsKey(ingre))
            return canMake.get(ingre) == null ? false: canMake.get(ingre);
        
        canMake.put(ingre, null);
        if(!graph.containsKey(ingre))
            return false;
        boolean canM = true;
        for(String next: graph.get(ingre))
            canM = canM & makeRec(next);
        
        canMake.put(ingre, canM);
        return canM;
    }

}
