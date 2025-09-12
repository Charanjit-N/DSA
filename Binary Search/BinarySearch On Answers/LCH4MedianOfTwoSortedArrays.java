// Optimal (Applying Binary Search by finding Symmetry) T.C-> O(log (min(n1,n2))), S.C->O(1)
class Solution {
    double findMedian(int[] nums1, int[] nums2) {
        int n1 = nums1.length; // smaller array nums1
        int n2 = nums2.length;
        int eleOnLeft = (n1+n2+1)/2;
        int n = n1+n2;      
        int low = 0, high = n1; 
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
                if(n%2==0) return ((double)Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                else return Math.max(l1,l2);
            }
            else if(l1> r2) high = mid1-1;
            else low = mid1+1;
        }
        return 0; 
   }
   double findMedianSortedArrays(int[] arr1 , int[] arr2){
        int n1 = arr1.length;
        int n2 = arr2.length;
        if(n1<n2) return findMedian(arr1,arr2);
        else return findMedian(arr2,arr1);
   }
}



// Better : (Instead of third array in Brute Force keep track using count) TC->O(n),SC->O(1)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2=nums2.length;
        int i=0,j=0;
        int n= n1+n2;
        int idx2 = n/2;
        int idx1 = idx2-1;
        int ele1 = Integer.MIN_VALUE , ele2 = Integer.MIN_VALUE;
        int count=0;
        while(i<n1 && j<n2){
            if(nums1[i]<=nums2[j]){
                if(count==idx1) ele1 = nums1[i];
                if(count==idx2) ele2 = nums1[i];
                count++;
                i++; 
            }else{
                if(count==idx1) ele1 = nums2[j];
                if(count==idx2) ele2 = nums2[j];
                count++;
                j++;
            }
        }
        while(i<n1){
            if(count==idx1) ele1 = nums1[i];
            if(count==idx2) ele2 = nums1[i];
            count++;
            i++; 
        }
        while(j<n2){
            if(count==idx1) ele1 = nums2[j];
            if(count==idx2) ele2 = nums2[j];
            count++;
            j++;
        }
        return (n%2==0) ? ((double)ele1+ele2)/2 : ele2;
    }
}

//Brute Force (Merging of two sorted arrays concept we use in merge sort): TC->O(n) , SC->O(n)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2=nums2.length;
        int n3 = n1+n2;
        int[] nums3 = new int[n3];
        int i=0,j=0,k=0;
        while(i<n1 && j<n2){
            if(nums1[i]<=nums2[j]){
                nums3[k] = nums1[i];
                i++;
                k++;
            }else{
                nums3[k] = nums2[j];
                j++;
                k++;
            }
        }
        while(i<n1){
            nums3[k] = nums1[i];
            i++;
            k++;
        }
        while(j<n2){
            nums3[k] = nums2[j];
            j++;
            k++;
        }
        return (n3%2==0) ? ((double)nums3[n3/2]+nums3[n3/2 - 1])/2 : nums3[n3/2];
    }
}
