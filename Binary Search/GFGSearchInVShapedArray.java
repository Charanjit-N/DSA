// TC ->O(log n) , SC->O(1)
class Solution{
    // TC ->O(log n)
    int findMinIndex(int[] arr){
        int low = 0;
        int high = arr.length-1;
        while(low<high){
            int mid = low +(high - low)/2;
            if(arr[mid] >  arr[mid+1]){
                low = mid +1;
            }
            else{
                high = mid;
            }
        }
        return low;
    }
    // TC ->O(log n)
    int BSInDecreasinigArray(int[] arr, int low, int high ,int key){
        while(low <= high){
            int mid =  low +  (high - low)/2;
            if(arr[mid]== key) return mid;
            else if(key > arr[mid]) high = mid-1;
            else low = mid+1;
        }
        return -1;

    }
    // TC ->O(log n)
    int BSInIncreasingArray(int[] arr, int low, int high ,int key){
        while(low <= high){
            int mid =  low +  (high - low)/2;
            if(arr[mid]== key) return mid;
            else if(key > arr[mid]) low  = mid+1;
            else high = mid-1;
        }
        return -1;
    }

    int searchInVshapedArray(int[] arr, int key){
        if (arr.length == 0) return -1;
        if (arr.length == 1) return arr[0] == key ? 0 : -1;

        int minIndex = findMinIndex(arr);

        if(arr[minIndex]==key) return minIndex;

        int left =  (minIndex-1>=0) ? BSInDecreasinigArray(arr, 0, minIndex-1,key) : -1;
        if(left != -1) return left;
        
        int right =  (minIndex+1<arr.length) ? BSInIncreasingArray(arr, minIndex+1, arr.length-1,key) : -1;
        if(right != -1) return right;

        return -1;
    }
}