

public class Algorithms {

    public static void bruteForce(PictureGrid picture){
        for (int i=0; i<picture.getHeight(); i++) {
            for (int j = 0; j < picture.getWidth(); j++) {
                int[][] grid = picture.getGrid();
                if(grid[i][j]==0){
                    picture.paintSquare(i,j,0);
                }
            }
        }
        picture.printGrid();
        picture.writeResults();
    }

    public static void kalMethod(PictureGrid picture){
        for (int i=0; i<picture.getHeight(); i++) {
            for (int j = 0; j < picture.getWidth(); j++) {
                int[][] grid = picture.getGrid();
                if(grid[i][j]==0){
                    int horizontal = 0;
                    int vertical = 0;
                    int k = j+1;
                    while(k<picture.getWidth() && grid[i][k]!=-1){
                        horizontal++;
                        k++;
                    }
                    k = i+1;
                    while(k<picture.getHeight() && grid[k][j]!=-1){
                        vertical++;
                        k++;
                    }
                    if(horizontal>=vertical){
                        picture.paintLine(i, j, i, j+horizontal);
                    }
                    else{
                        picture.paintLine(i, j, i+vertical, j);
                    }
                }
            }
        }
        picture.printGrid();
        picture.writeResults();
    }

}
