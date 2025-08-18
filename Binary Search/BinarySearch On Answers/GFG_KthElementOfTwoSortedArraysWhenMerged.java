// T.C-> O(log (min(n1,n2))), S.C->O(1)
class Solution {
    int findKth(int[] nums1, int[] nums2,int k) {
        int n1 = nums1.length; // smaller array nums1
        int n2 = nums2.length;
        int eleOnLeft = k;
        int n = n1+n2;      
        int low = Math.max(0,k-n2), high = Math.min(k,n1); 
        while(low<=high){
            int mid1 = low+(high-low)/2;
            int mid2 = eleOnLeft - mid1;
            int l1=Integer.MIN_VALUE,l2=Integer.MIN_VALUE;
            int r1=Integer.MAX_VALUE,r2=Integer.MAX_VALUE;
            if(mid1-1>=0) l1 = nums1[mid1-1];
            if(mid2-1>=0) l2 = nums2[mid2-1];
            if(mid1<n1) r1 = nums1[mid1];
            if(mid2<n2) r2 = nums2[mid2];
            if(l1<=r2 && l2<=r1){
                return Math.max(l1,l2);
            }
            else if(l1> r2) high = mid1-1;
            else low = mid1+1;
        }
        return 0; 
    }
    public int kthElement(int a[], int b[], int k) {
        // code here
        int n1 = a.length;
        int n2 = b.length;
        if(n1<n2) return findKth(a,b,k);
        else return findKth(b,a,k);
        
    }
}