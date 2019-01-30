package Final;

public class Island {


        public int numIslands(char[][] grid) {
            if(grid.length ==0) return 0;
            int row=grid.length;
            int col= grid[0].length;
            int count=0;
            for(int i=0;i<row;i++)
            {
                for(int j=0;j<col;j++)
                {
                    if(grid[i][j] =='1') {
                        count=count+1;
                        dependents(i,j,grid);
                    }
                }
            }return count;
        }

        public void dependents(int i,int j,char grid[][])
        {
            grid[i][j]='0';

            if(i-1>=0 && grid[i-1][j]=='1')
                dependents(i-1,j,grid);

            if(j-1>=0 && grid[i][j-1]=='1')
                dependents(i,j-1,grid);

            if(i+1<grid.length && grid[i+1][j]=='1')
                dependents(i+1,j,grid);

            if(j+1< grid[0].length && grid[i][j+1]=='1')
                dependents(i,j+1,grid);
        }

    public static void main(String[] args) {
        Island i=new Island();
        char grid[][]={{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println("Number of Islands: " +i.numIslands(grid));
    }

}

