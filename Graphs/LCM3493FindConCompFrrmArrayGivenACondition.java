
/*
Time Complexity:
Constructing the adjacency list takes (O(n^2), where (n) is the number of nodes, and (m) is the average size of each property list.
BFS/DFS -> (O(n + E)), n -># nodes , E->#edges
TC-> approximately (O(n^2).

Space Complexity:
adjacency list ->(O(n^2)) in the worst case.
vis[] -> (O(n)).
set operations require -> (O(m)) space per function call.
SC -> approximately (O(n^2 + m)).
*/

class LCM3493FindConCompFrrmArrayGivenACondition {
    public int numberOfComponents(int[][] properties, int k) {
        int n = properties.length;
        ArrayList<int[]> edges = findEdges(properties,k);
    

        int cnt = 0;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int vis[] = new int[n];
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                cnt++;
                bfs(i, adj, vis);
            }
        }
        return cnt;
    }
    ArrayList<int[]> findEdges(int[][] properties, int k){
        ArrayList<int[]> edges = new ArrayList<>();
        int n = properties.length;
        for(int i=0;i<n;i++){
            int[]  v1 = properties[i];
            for(int j=i+1;j<n;j++){
                int[] v2 =  properties[j];
                if(findCommon(v1, v2) >= k){
                    edges.add(new int[]{i,j});
                }
            }
        
        }
        return edges;
    }
    int findCommon(int[] arr1, int[] arr2){
        Set<Integer> set1=new HashSet();
        for(int ele : arr1)
         set1.add(ele);
        Set<Integer> set2=new HashSet();
        for(int ele : arr2)
        {
            if(set1.contains(ele))
             set2.add(ele);
        }
        return set2.size();
    }

    void bfs(int i, ArrayList<ArrayList<Integer>> adj, int[] vis){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        vis[i] = 1;
        while(!q.isEmpty()){
            Integer node = q.poll();
            for(Integer x : adj.get(node)){
                if(vis[x]==0){
                    vis[x] = 1;
                    q.add(x);
                }
            }
        }
    }
}

