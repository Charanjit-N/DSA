
// TC->O(V+E): Topological sort + O(K*Avg length of strings in dict) : for preparing adj list, SC->O(3V)=O(V);
class Solution {
    public int[] topoSortBFS(int V, List<List<Integer>> adj) {
        int[] inDegree =  new int[V];
        for(List<Integer> ls : adj){
            for(Integer x : ls){
                inDegree[x]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }
        int index = 0;
        int[] topo =  new int[V];
        while(!q.isEmpty()){
            int nd =  q.poll();
            topo[index++] = nd;
            for(Integer x :  adj.get(nd)){
                inDegree[x]--;
                if(inDegree[x] == 0){
                    q.add(x);
                }
            }
        }
        return topo;
    }
    public String findOrder(String [] dict, int N, int K) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<K;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<dict.length-1;i++){
            String s1 = dict[i];
            String s2 = dict[i+1];
            int len = Math.min(s1.length(), s2.length());
            for(int j=0;j<len;j++){
                if(s1.charAt(j) != s2.charAt(j)){
                    adj.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
                    break;
                }
            }
        }
        int res[] = topoSortBFS(K,adj);
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<K;i++){
            sb.append((char)(res[i] + (int)('a')));
        }
        return sb.toString();
    }
}