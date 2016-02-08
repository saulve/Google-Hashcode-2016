

public class Test {
    public static void main(String[] args) {
        PictureGrid logo = new PictureGrid("input/logo.in");

        logo.paintSquare(2, 2, 2);
        logo.eraseCell(0,0);
        logo.paintLine(2, 15, 2, 30);
        logo.writeResults();
        logo.printGrid();

        for (int i=0; i<logo.getHeight(); i++){
            for (int j=0; j<logo.getWidth(); j++){

            }
        }
    }
}
