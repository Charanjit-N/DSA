// Brute Force : TC ->O(n^2)
class Solution {
    public int findMaximumXOR(int[] nums) {
        int n = nums.length;
        int max = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                max = Math.max(max , nums[i]^nums[j]);
            }
        }
        return max;
    }
}


// Optimal :  TC-> O(32 * n ) =O(n) , SC->O(32 * n )= O(n)
class TrieNode{
    TrieNode left;
    TrieNode right;
}
class Trie{
    TrieNode root;
    Trie(){
        root  = new TrieNode();
    }
    void insert(int num){
        TrieNode nd = root;
        for(int i=31;i>=0;i--){
            int bit =  (num>>i) & 1;
            if(bit == 0){
                if(nd.left == null){
                    nd.left =  new TrieNode();
                }
                nd = nd.left;
            }
            else{
                if(nd.right == null){
                    nd.right = new TrieNode();
                }
                nd = nd.right;
            }
        }
    }
    int findMaxXorPair(int num){
        TrieNode nd = root;
        int val = 0;
        for(int i=31;i>=0;i--){
            int bit =  (num >> i) & 1;
            if(bit== 0){
                if(nd.right != null){
                    val += Math.pow(2,i);  //val |= (1<<i)
                    nd =  nd.right; 
                } else{
                    nd =  nd.left;
                }
            }
            else{
                if(nd.left != null){
                    nd =  nd.left; 
                } else{
                    val += Math.pow(2,i); //val |= (1<<i)
                    nd =  nd.right;
                }
            }
        }
        return val;
    }              
}
class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie trie =  new Trie();
        for(int num :  nums){
            trie.insert(num);
        }
        int maxXor = 0;
        for(int num : nums){
            int maxXorPair =  trie.findMaxXorPair(num);
            maxXor = Math.max(maxXor , num ^ maxXorPair);
        }
        return maxXor;
    }
}