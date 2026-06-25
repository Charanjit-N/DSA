//sorting +  Two pointer : TC -->O(n log n + m log m)
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int i = 0, j = 0;
        int ans = 0;
        while (i < houses.length) {
            while (j < heaters.length - 1
                && Math.abs(heaters[j + 1] - houses[i]) <= Math.abs(heaters[j] - houses[i])) {
                j++;
            }
            ans = Math.max(ans, Math.abs(heaters[j] - houses[i]));
            i++;
        }
        
        return ans;
    }
}

// sorting + Binary Search on Answer : TC -->O(n log n + m log m + (m+n)*log(Range))
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);   // O(nlogn)
        Arrays.sort(heaters);   // O(mlogm)
        int low =0;
        int high = Math.max(houses[houses.length-1],heaters[heaters.length-1]);
        int ans = high;
        while(low<=high){         //O((m+n)log(Binary Search Range))
            int mid = low + (high-low)/2;
            if(isPossible(houses,heaters,mid)){  //O(m+n)
                ans = mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }

    public boolean isPossible(int house[], int heater[], int rad){  // O(m+n)
        int n1 = house.length;
        int n2 = heater.length;
        int i=0; //houses
        int j=0; //heaters
        while(i<n1 && j<n2){
            if(house[i]>=heater[j]-rad && house[i]<=heater[j]+rad){
                i++;
            }
            else if(house[i]<heater[j]-rad){ // means radius not sufficient
                return false;
            }
            else if(house[i]>heater[j]+rad){
                j++;
            }
        }
        return (i==n1);
    }
}