/*
Given an integer n representing number of vertices. Find out how many undirected graphs (not necessarily connected) can be constructed out of a given n number of vertices.
*/
// TC->O(1) , SC->O(1)
class GFG_NumberOfGraphsPossible {
    static long count(int n) {
    // code here
    return (long)Math.pow(2, (n*(n-1))/2);

  }
}
