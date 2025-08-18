// Brute Force : TC ->O(k* n)+O(n), SC->O(n)
class Solution {
    public static double findSmallestMaxDist(int stations[], int k) {
        // code here
        int n = stations.length;
        int gaps = n-1;
        int[] cnt = new int[gaps];
        for(int gasStations=1;gasStations<=k;gasStations++){
            double maxGapLength = -1;
            int maxIndex =-1;
            for(int i=0;i<n-1;i++){
                double diff = stations[i+1]-stations[i];
                double gapLength = diff/((double)cnt[i]+1);
                if(gapLength > maxGapLength){
                    maxGapLength = gapLength;
                    maxIndex = i;
                }
            }
            cnt[maxIndex]++;
        }
        
        double max = -1;
        for(int i=0;i<n-1;i++){
            double diff =  stations[i+1]-stations[i];
            double gapLength =  diff/((double)cnt[i]+1);
            max = Math.max(max, gapLength);
        }
        return max;
        
    }
}



// Better : TC ->O(n*logn + k*logn) , SC->O(n)
class Pair{
    double diff;
    int gapIndex;
    Pair(double diff, int gapIndex){
        this.diff = diff;
        this.gapIndex = gapIndex;
    }
}
class Solution {
    public static double findSmallestMaxDist(int stations[], int k) {
        // code here
        int n = stations.length;
        int gaps = n-1;
        int[] cnt = new int[gaps];
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> Double.compare(y.diff,x.diff));
        for(int i=0;i<n-1;i++){
            pq.add(new Pair(stations[i+1]-stations[i] ,i));
        }
        for(int gasStations=1;gasStations<=k;gasStations++){
            int gapIndex =pq.poll().gapIndex;
            cnt[gapIndex]++;
            double intitialGap = stations[gapIndex+1]-stations[gapIndex];
            double newGap =  intitialGap / ((double)cnt[gapIndex]+1);
            pq.add(new Pair(newGap,gapIndex));
        }
        return pq.poll().diff;
    }
}



// Optimal with no space : TC ->O(n*log(range of binary search))+O(n), SC->O(1)
class Solution {
    static int countStations(int[] stations, double maxDiff){
        int cnt = 0;
        for(int i=0;i<stations.length-1;i++){
            double len =  stations[i+1]-stations[i];
            int gaps = (int)Math.ceil(len/maxDiff);
            int gasStations = gaps-1;
            cnt += gasStations;
        }
        return cnt;
        
    }
    public static double findSmallestMaxDist(int stations[], int k) {
        // code here
        int n = stations.length;
        double low = 0;
        double high =0;
        for(int i=0;i<n-1;i++){
            high = Math.max(high, stations[i+1]-stations[i]);
        }
        double ans = 0;
        while(high - low > 1e-6){
            double mid = (low+high)/2.0;
            int cnt = countStations(stations, mid);
            if(cnt > k) low = mid;
            else{
                high = mid;
            }
        }
        return high;
    }
}
