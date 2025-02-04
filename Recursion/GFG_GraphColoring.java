/*
You are given an undirected graph consisting of v vertices and a list of edges, along with an integer m. Your task is to determine whether it is possible to color the graph using at most m different colors such that no two adjacent vertices share the same color. Return true if the graph can be colored with at most m colors, otherwise return false.

Note: The graph is indexed with 0-based indexing.

Examples:

Input: v = 4, edges[] = [(0,1),(1,2),(2,3),(3,0),(0,2)], m = 3
Output: true
Explanation: It is possible to color the given graph using 3 colors, for example, one of the possible ways vertices can be colored as follows:
Vertex 0: Color 3
Vertex 1: Color 2
Vertex 2: Color 1
Vertex 3: Color 2
*/


// Intution : We have to apply and check each color of each node 


//TC->O(m^(nodes in graph))
class GFG_GraphColoring {
    boolean graphColoring(int v, List<int[]> edges, int m) {
        // code here
        int[] colors = new int[v];
        return isPossibleToColor(0,v,edges,colors,m);
        
    }
    
    boolean isPossibleToColor(int node, int v, List<int[]> edges,int[] colors,int m){
        if(node==v){
            return true;
        }
        for(int i=1;i<=m;i++){
            if(isSafe(node,edges,colors,i) == true){ 
                colors[node] = i;
                if(isPossibleToColor(node+1,v,edges,colors,m) == true)  return true;
                colors[node]=0;
            }
        }
        return false;
    }
    
    boolean isSafe(int node, List<int[]> edges, int[] colors, int colour){
        for(int[] a : edges){
            if(a[0]==node){
                if(colors[a[1]]==colour) return false;
            }
            if(a[1]==node){
                if(colors[a[0]]==colour) return false;
            }
        }
        return true;
    }
}