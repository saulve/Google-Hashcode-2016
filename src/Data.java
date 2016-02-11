import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Data {
    private String fileIn = "input/test.in";
    private int rows, columns;
    private int droneNum;
    private int turns;
    private int droneMaxLoad;
    private int productTypeNum;
    private int[] productTypeWeights;
    private List<Warehouse> warehouses = new ArrayList<Warehouse>();
    private List<Order> orders = new ArrayList<Order>();

    public Data() {
        readFile();
    }

    private void readFile(){
        try {
            Scanner scanner = new Scanner(new File(fileIn));
            rows = scanner.nextInt();
            columns = scanner.nextInt();
            droneNum = scanner.nextInt();
            turns = scanner.nextInt();
            droneMaxLoad = scanner.nextInt();
            scanner.nextLine();
            productTypeNum = scanner.nextInt();
            scanner.nextLine();

            productTypeWeights = new int[productTypeNum];
            for (int i = 0; i < productTypeNum; i++) {
                productTypeWeights[i] = scanner.nextInt();
            }
            scanner.nextLine();

            int warehouseNum = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < warehouseNum; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                List<Product> products = new ArrayList<Product>();
                scanner.nextLine();
                for (int j = 0; j < productTypeNum; j++) {
                    int n = scanner.nextInt();
                    for (int k = 0; k < n; k++) {
                        products.add(new Product(j));
                    }
                }
                warehouses.add(new Warehouse(i, x, y, products));
                scanner.nextLine();
            }

            int ordersNum = scanner.nextInt(); //3
            for (int i = 0; i < ordersNum; i++) {
                scanner.nextLine();
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                List<Product> products = new ArrayList<Product>();
                scanner.nextLine();
                int items = scanner.nextInt();
                scanner.nextLine();
                for (int j = 0; j < items; j++) {
                    int n = scanner.nextInt();
                    products.add(new Product(n));
                }
                orders.add(new Order(i, x, y, products));
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File reading error!");
        }
        catch(IllegalArgumentException e){
            System.out.println("File corrupted!");
        }
    }

    public int getWeight(int itemName){
        return productTypeWeights[itemName];
    }
}
