package Final;

public class Tile {

    public int numberOfWaysToTile ( int boardColumns ) {

        if(boardColumns<=2)
        {
            return boardColumns;
        }
       int result= numberOfWaysToTile(boardColumns-1)+ numberOfWaysToTile(boardColumns-2);
        return result;
    }

    public static void main(String[] args) {
        Tile tile=new Tile();
        int res=tile.numberOfWaysToTile(4);
        System.out.println("Max ways : " +res);
    }
    }
