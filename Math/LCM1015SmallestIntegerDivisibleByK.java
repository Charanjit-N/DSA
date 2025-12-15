// TC ->O(k) , SC->O(k)
class Solution {
    public int smallestRepunitDivByK(int k) {
        int rem =1;
        int len =1;
        Set<Integer> set = new HashSet<>();
        while(rem % k != 0){
            rem = (10 * rem +1) % k;
            len++;
            if(set.contains(rem)) return -1;
            else set.add(rem);
        }
        return len;
    }
}

// TC ->O(k) , SC->O(1)
class Solution {
    public int smallestRepunitDivByK(int K) {
        int rem = 0;
        for (int len = 1; len <= K; len++) {
            rem = (rem * 10 + 1) % K;
            if (rem == 0) {
                return len;
            }
        }
        return -1;
    }
}

