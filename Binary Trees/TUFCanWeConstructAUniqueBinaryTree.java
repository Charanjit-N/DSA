class Solution {
    public boolean uniqueBinaryTree(int a, int b) {
        //your code goes here
        if(a==2 || b==2){
            if(b==1 || b==3|| a==1 || a==3) return true;
        }
        return false;
    }
}