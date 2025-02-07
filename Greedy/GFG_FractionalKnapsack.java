class GFG_FractionalKnapsack {
    // Function to get the maximum total value in the knapsack.
    // TC-> O(n*logn + n) 
    double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < val.size(); i++) {
            indices.add(i);
        }
        indices.sort((i, j) -> Double.compare(
            (double) val.get(j) / wt.get(j),  
            (double) val.get(i) / wt.get(i)
        ));
        
        List<Integer> sortedVal = new ArrayList<>();
        List<Integer> sortedWt = new ArrayList<>();
        for (int i : indices) {
            sortedVal.add(val.get(i));
            sortedWt.add(wt.get(i));
        }
      
        double ans =0;
        for(int i=0;i<sortedVal.size();i++){
           if(sortedWt.get(i)<=capacity){
               ans += sortedVal.get(i);
               capacity -= sortedWt.get(i);
           }
           else{
               ans +=   (double)capacity * ((double)sortedVal.get(i)/sortedWt.get(i));
               break;
               
           }
       }

       return ans;
        
    }
}