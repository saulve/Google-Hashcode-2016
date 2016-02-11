import java.util.ArrayList;
import java.util.List;

public class Warehouse extends Coordinates {
    private List<Product> stock = new ArrayList<Product>();

    public Warehouse(int name, int x, int y, List<Product> stock) {
        super(name, x, y);
        this.stock = stock;
    }

    public void addItem(int item, int quantity){
        for(int i=0; i<quantity; i++) {
            stock.add(new Product(item));
        }
    }

    public void removeItem(int item, int quantity) {
        if(availableItem(item, quantity)) {
            int count = 0;
            for (int i = 0; i < stock.size(); i++) {
                if(count<quantity && stock.get(i).getName()==item){
                    stock.remove(i);
                    count++;
                }
                if(count==quantity) {
                    break;
                }
            }
        }
    }

    public boolean availableItem(int item, int quantity){
        int count=0;
        for(int i=0; i<stock.size(); i++){
            if(stock.get(i).getName()==item && !stock.get(i).isReserved()){
                count++;
            }
        }
        if(count>=quantity){
            return true;
        }else{
            return false;
        }
    }
}
