class Solution {
    class Mapr {
        int a;
        String b;
        Mapr(int aa,String bb){
            this.a = aa;
            this.b = bb;
        }
    }
    class Comp implements Comparator<Mapr>{
 
    @Override
    public int compare(Mapr e1, Mapr e2) {
        if(e1.a >= e2.a){
            return 1;
        } else {
            return -1;
        }
    }
}
    public String arrangeWords(String text) {
        if(text.length() <=1)
            return text;
        String[] arr = text.split(" ");
        
        StringBuilder str = new StringBuilder();
        TreeSet<Mapr> tg = new TreeSet<Mapr>(new Comp());
        
        for(int i=0;i<arr.length;i++)
            tg.add(new Mapr(arr[i].length(), arr[i].toLowerCase()));
        
        for (Mapr s : tg) {
            str.append(s.b+" ");
        }
       str.setCharAt(0, (char)(str.charAt(0)-32));
       //System.out.println(str);
          
        return str.toString().trim();
    }
}