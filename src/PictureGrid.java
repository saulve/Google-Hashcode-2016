import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class PictureGrid {
    private int[][] grid;       // | -1 = Don't paint | 0 = Paint | 1 = Painted |
    private int height, width;
    private String fileIn;
    private List<String> ops = new LinkedList<String>();

    PictureGrid(String file){
        this.fileIn = file;
        System.out.println(file);
        readFile();
    }

    private void readFile(){
        try{
            Scanner scanner = new Scanner(new File(fileIn));
            height = scanner.nextInt();
            width = scanner.nextInt();
            grid = new int[height][width];
            scanner.nextLine();
            for(int i=0; i<height; i++) {
                if (scanner.hasNextLine()) {
                    String[] line = scanner.nextLine().split("");
                    for (int j = 0; j < width; j++) {
                        switch(line[j]){
                            case ".":
                                grid[i][j]=-1;
                                break;
                            case "#":
                                grid[i][j]=0;
                                break;
                            default:
                                throw new IllegalArgumentException();
                        }
                    }
                }
            }
            scanner.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File reading error!");
        }
        catch(IllegalArgumentException e){
            System.out.println("File corrupted!");
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void paintSquare(int r, int c, int s){
        ops.add("PAINT_SQUARE "+r+" "+c+" "+s);
        for(int i=r-s; i<=r+s; i++){
            for(int j=c-s; j<=c+s; j++){
                grid[i][j]=1;
            }
        }
        //works right when the center is S away from all edges
    }

    public void paintLine(int r1, int c1, int r2, int c2){
        ops.add("PAINT_LINE "+r1+" "+c1+" "+r2+" "+c2);
        for(int i=r1; i<=r2; i++){
            for(int j=c1; j<=c2; j++){
                grid[i][j]=1;
            }
        }
        //works right when indexes are inside the grid
    }

    public void eraseCell(int r, int c){
        ops.add("ERASE_CELL "+r+" "+c);
        grid[r][c]=-1;
        //works right only if erasing an empty cell painted over
    }

    public int[][] getGrid(){
        return grid;
    }

    public void printGrid(){
        for (int i=0; i<height; i++){
            for (int j=0; j<width; j++){
                switch (grid[i][j]){
                    case -1:
                        System.out.print(".");
                        break;
                    case 0:
                        System.out.print("#");
                        break;
                    case 1:
                        System.out.print("@");
                        break;
                    default:
                        break;
                }
            }
            System.out.println();
        }
    }

    public void writeResults(){
        String fileOut = "output/" + fileIn.substring(6, fileIn.length()-2) + "out";
        try {
            PrintWriter printer = new PrintWriter(fileOut);
            printer.write(ops.size()+"\n");
            for(String op: ops){
                printer.write(op+"\n");
            }
            printer.flush();
        }
        catch(FileNotFoundException e){
            System.out.println("Problem with writing to file!");
        }
    }
}
