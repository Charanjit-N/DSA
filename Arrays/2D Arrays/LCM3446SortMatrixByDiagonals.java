class LCM3446SortMatrixByDiagonals {
    int[] reverse(int arr[]){
        int n = arr.length;
        int i=0;
        while(i<n/2){
            arr[i]= arr[i]+arr[n-i-1] - (arr[n-i-1]=arr[i]);
            i++;
        }
        return arr;
    }
    
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
    
        // Lower Triangle
        for(int x=0;x<n;x++){
            int[] arr = new int[n-x];
    
            int i = x;
            for(int j=0;j<arr.length;j++){
                arr[j] = grid[i][j];
                i++; 
            }
            Arrays.sort(arr);
            reverse(arr);
            i= x;
            
            for(int j=0;j<arr.length;j++){
                grid[i][j] = arr[j];
                i++; 
            }
        
        }

        // Upper Triangle
        for(int x=1;x<n;x++){
            int[] arr = new int[n-x];
    
            int i = x;
            for(int j=0;j<arr.length;j++){
                arr[j] = grid[j][i];
                i++; 
            }
            Arrays.sort(arr);
            
            i= x;
            
            for(int j=0;j<arr.length;j++){
                grid[j][i] = arr[j];
                i++; 
            }
        
        }

        
        return grid;
        
    }
    
}