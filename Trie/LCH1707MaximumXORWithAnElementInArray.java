// Brute force :  TC->O(n*q)
class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int[] ans =  new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int max = -1;
            for(int num : nums){
                if(num <= queries[i][1]){
                    max =  Math.max(max ,  num^queries[i][0]);
                }
            }
            ans[i] = max;
        }
        return ans;
    }
}



// Optimal
// TC-> O(n*logn) + O(q*logq) + O(n + q);
// SC-> O(n + q);

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
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int[] ans =  new int[queries.length];

        Arrays.sort(nums);

        // Need to preserver query order as we sort them in next step
        ArrayList<ArrayList<Integer>> oq = new ArrayList<>();
        for (int i =0;i<queries.length;i++) {
            ArrayList<Integer> ls =  new ArrayList<>();
            ls.add(queries[i][0]);
            ls.add(queries[i][1]);
            ls.add(i);
            oq.add(ls);
        }

        // Sorting queries based on threshold value
        Collections.sort(oq, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                return Integer.compare(a.get(1), b.get(1));
            }
        });

        int i = 0;
        int n = nums.length;
        Trie trie = new Trie();
        for (ArrayList<Integer> ls : oq) {
            while (i < n && nums[i] <= ls.get(1)) {
                trie.insert(nums[i]);
                i++;
            }
            if (i != 0)
                ans[ls.get(2)] = ls.get(0) ^ trie.findMaxXorPair(ls.get(0));
            else
                ans[ls.get(2)] = -1;
        }
        return ans;
    }
}