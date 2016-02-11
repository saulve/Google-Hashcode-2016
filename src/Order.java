import java.util.ArrayList;
import java.util.List;

/**
 * Created by cheloveq on 11/02/2016.
 */
public class Order extends Coordinates {
    private List<Product> requires = new ArrayList<Product>();

    public Order(int name, int x, int y, List<Product> requires) {
        super(name, x, y);
        this.requires = requires;
    }

    public void fulfillOrder(int item){
        for(int i=0; i<requires.size(); i++) {
            if (requires.get(i).getName() == item) {
                requires.remove(i);
                break;
            }
        }
    }
}
