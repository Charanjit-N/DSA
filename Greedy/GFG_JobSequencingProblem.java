// TC -->O(n*logn) + O(n* max value in dealine[])
// SC-->O(max value in dealine[]) : hashArr[]
class Pair{
    int id;
    int dl;
    int pft;
    Pair(int id, int pft, int dl){
        this.id =id;
        this.pft = pft;
        this.dl = dl;
    }
}
class Solution {
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
        int n = deadline.length;
        Pair[] p = new Pair[n];
        for(int i=0;i<n;i++){
            p[i] = new Pair(i+1,profit[i], deadline[i]);
        }
        Arrays.sort(p, (x,y) -> y.pft - x.pft);  // O(n * logn)
        int max = 0;
        for(int i=0;i<n;i++) max = Math.max(max, deadline[i]);
        int[] hashArr = new int[max+1];
        int maxProfit = 0;
        int cnt = 0;
        for(int i=0;i<n;i++){     // O(n * max value in dealine[])
            int index = p[i].dl;
            while(index >=1){
                if(hashArr[index] ==0){
                    hashArr[index] = p[i].id;
                    maxProfit += p[i].pft;
                    cnt++;
                    break;
                }
                index--;
            }
            
        }
        return new ArrayList<>(Arrays.asList( cnt,maxProfit));
        
    }
}