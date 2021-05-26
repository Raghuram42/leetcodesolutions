class Solution {
    public String largestTimeFromDigits(int[] A) {
//         int[] mapr = new int[10];
        
//         for(int a : A){
//             mapr[a]++;
//         }
        
//         StringBuilder str = new StringBuilder();
        
//         int p = 2;
//         while(p >= 0 && mapr[p] == 0){
//             p--;
//         }
//         if(p < 0)
//             return "";
//         str.append(p);
//            mapr[p]--;
//         p = 3;
//         while(p >= 0 && mapr[p] == 0){
//             p--;
//         }
//          if(p < 0)
//             return "";
//          str.append(p);
//         mapr[p]--;
//          str.append(":");
//           p = 5;
//         while(p >= 0 && mapr[p] == 0){
//             p--;
//         }
//           if(p < 0)
//             return "";
//             str.append(p);
//            mapr[p]--;
//                p = 9;
//         while(p >= 0 && mapr[p] == 0){
//             p--;
//         }
//           if(p < 0)
//             return "";
//             str.append(p);
//            mapr[p]--;
//         return str.toString();
//     }
// }
          for(int h = 23; h >= 0; h--) {
            for(int m = 59; m >= 0; m--) {
                
                boolean flag = true;
                int[] count = new int[10];
                
                count[h < 10 ? 0 : h / 10]++;
                count[h < 10 ? h : h % 10]++;
                count[m < 10 ? 0 : m / 10]++;
                count[m < 10 ? m : m % 10]++;                

                
                for(int e : A) {
                    if(--count[e] < 0) {
                        flag = false;
                        break;
                    }
                }
                
                if(flag) return String.format("%02d:%02d", h, m);
            }
        }
        
        return "";
    }
}