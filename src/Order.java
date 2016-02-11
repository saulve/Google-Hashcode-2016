import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by cheloveq on 11/02/2016.
 */
public class Order extends Coordinates implements Comparable<Order> {
    private List<Product> requires = new ArrayList<Product>();
    private double weight;
    
    public Order(int name, int x, int y, List<Product> requires) {
        super(name, x, y);
        this.requires = requires;
    }
    
    public double getWeight() {
    	double orderWeight = 0;
    	//Runs through all products and adds their weight
    	for(int i = 0; i < requires.size() - 1; i++) {
    		orderWeight += requires.get(i).getWeight;
    	}
    	return orderWeight;
    }

    public void fulfillOrder(int item){
        for(int i=0; i<requires.size(); i++) {
            if (requires.get(i).getName() == item) {
                requires.remove(i);
                break;
            }
        }
    }

	@Override
	public int compareTo(Order o) {
		// TODO Auto-generated method stub
		double compareWeight= ((Order) o).getWeight();
		return (int) (this.weight - compareWeight);
	}
	
	public static Comparator<Order> OrderWeightComparator 
    = new Comparator<Order>() {

	public int compare(Order o1, Order o2) {

	int orderWeight1 = o1.getWeight();
	int orderWeight2 = o2.getWeight();
	
	//ascending order
	return o2.compareTo(o2);
	
	
	}

};
}
