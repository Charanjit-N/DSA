
import java.util.*;

class SortArrayUsingRecursion{
    static void insert(ArrayList<Integer> ls , int temp){
        if(ls.size()==0 || ls.get(ls.size()-1)<=temp){
            ls.add(temp);
            return;
        }
        int val = ls.get(ls.size()-1);
        ls.remove(ls.size()-1);
        insert(ls,temp);
        ls.add(val);
        return;
    }
    static void sort(ArrayList<Integer> ls){
        if(ls.size()==1) return;
        int temp = ls.get(ls.size()-1);
        ls.remove(ls.size()-1);
        sort(ls);
        /* we can insert using another temporary array 
        like in merge sort but here implementing insert 
        functionality also using recursion*/
        insert(ls,temp);
    }
    public static void main(String args[]){
        //Insertion sort
        int arr[] = {23, 46 , 3, 17, 89};

        // ArrayList<Integer> ls = new ArrayList<>();
        // for(int i=0;i<arr.length;i++){
        //     ls.add(arr[i]);
        // }
        /* we cannot convert arr of type int[] to list of type Integer using Arrays.asList()
         we can you streams instead. Also the asList() method gives fixed length list we cannot
         remove or add elements other way is using streams we can conver array to list*/
        //  List<Integer> ls = Arrays.stream(arr)     
        //                           .boxed()        
        //                           .collect(Collectors.toList()); 

        // sort(ls);
        // for(int i=0;i<arr.length;i++){
        //     arr[i] =  ls.get(i);
        // }
        // System.out.println(Arrays.toString(arr));

        // Insertion sort but recursion only for outer loop not for insertion/swapping
        sort2(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));

    }

    static void sort2(int arr[], int i, int n){
        if(i==n) return;
        int j=i;
        while(j>0 && arr[j-1] > arr[j]){
            //swapping
            arr[j] = arr[j]+arr[j-1] - (arr[j-1]=arr[j]);
            
            j--;
        }
        sort2(arr,i+1,n);
    }
}
	