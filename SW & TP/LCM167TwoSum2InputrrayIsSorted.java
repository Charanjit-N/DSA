// Optimal : TC -> O(n) , SC->O(1)
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int a = -1, b=-1;
        int l = 0;
        int r = n-1;
        while(l <  r){
            int sum = numbers[l] + numbers[r];
            if(sum ==  target){
                a = l+1;
                b = r+1;
                break;
            }
            if(sum >  target) r--;
            else l++;
        }
        return new int[]{a,b};
    }
}

// Using map
// TC -> O(n), SC->O(1)
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int a = -1;
        int b = -1;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i =0;i<n;i++){
            int rem  = target - numbers[i];
            if(map.containsKey(rem)){
                a = i+1;
                b =  map.get(rem)+1;
                break;
            }
            map.put(numbers[i],i);
        }
        if(a<b) return new int[]{a,b};
        return new int[]{b,a};
    }
}