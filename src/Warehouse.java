import java.util.ArrayList;
import java.util.List;

public class Warehouse extends Coordinates {
    private List<Integer> stock = new ArrayList<Integer>();

    public Warehouse(int name, int x, int y, List<Integer> stock) {
        super(name, x, y);
        this.stock = stock;
    }

    public void addItem(int item, int quantity){
        for(int i=0; i<quantity; i++) {
            stock.add(item);
        }
    }

    public void removeItem(int item, int quantity) {
        if(availableItem(item, quantity)) {
            int count = quantity;
            for (int i = 0; i < stock.size(); i++) {
                if(count<quantity){

                }else{
                    break;
                }
            }
        }
    }

    public boolean availableItem(int item, int quantity){
        int count=0;
        for(int i=0; i<stock.size(); i++){
            if(stock.get(i)==item){
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
