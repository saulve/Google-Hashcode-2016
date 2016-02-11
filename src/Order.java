import java.util.ArrayList;
import java.util.List;

/**
 * Created by cheloveq on 11/02/2016.
 */
public class Order extends Coordinates {
    private List<Integer> requires = new ArrayList<Integer>();

    public Order(int name, int x, int y, List<Integer> requires) {
        super(name, x, y);
        this.requires = requires;
    }

    public void fulfillOrder(int item){
        requires.remove(item);
    }
}
