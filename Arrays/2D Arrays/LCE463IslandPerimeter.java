class LCE463IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        //TC- >O(rxc)
        int r = grid.length;
        int c = grid[0].length;
        int p=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j] ==1){
                    peri+=4;
                    
                    if(i-1>= 0 && grid[i-1][j]==1) p--;
                    if(i+1 <r && grid[i+1][j]==1) p--;
                    
                  
                    if(j-1>=0 && grid[i][j-1]==1) p--;
                    if(j+1<c && grid[i][j+1]==1) p--;
                }
                
            }
        }
        return peri;
    }
}