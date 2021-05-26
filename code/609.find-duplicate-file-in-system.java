class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        
        List<List<String>> res = new ArrayList<>();
        
        for(String path: paths){
            
            String[] dismPath = path.split("/");
            
            // System.out.println(dismPath.length+" "+dismPath[0]);
            
            String[] dismPath2 = dismPath[dismPath.length-1].split(" ");
            
            // System.out.println(dismPath2.length+" "+dismPath2[0]+" "+dismPath[dismPath.length-1]);
            StringBuilder filePath = new StringBuilder();
            for(int i=0;i<dismPath.length-1;i++)
                filePath.append(dismPath[i]).append("/");
      
            
            String currFile1 = filePath.toString();
            for(int p= 1;p<dismPath2.length;p++){
            int contentFrontIndex = dismPath2[p].indexOf("(");
            int contentBackIndex = dismPath2[p].indexOf(")");
            
            
                  // System.out.println(contentFrontIndex+" "+contentBackIndex+" ");//+fileContent+" "+fileName+" "+currFile);
            
            if(contentFrontIndex == -1 || contentBackIndex == -1)
                continue;
            String fileName = dismPath2[p].substring(0, contentFrontIndex);
            String fileContent = dismPath2[p].substring(contentFrontIndex+1, contentBackIndex);
            
            String currFile = currFile1+dismPath2[0]+"/"+fileName;
     
            if(!map.containsKey(fileContent))
                map.put(fileContent, new ArrayList<String>());
            
            map.get(fileContent).add(currFile);
            if(map.get(fileContent).size() == 2)
                res.add(map.get(fileContent));
            }
            
        }
        // System.out.println(map);
        return res;
    }
}