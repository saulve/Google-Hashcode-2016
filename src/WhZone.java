import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class WhZone {
	private Warehouse warehouse;
	private List<Order> orders = new ArrayList<>();
	
	public WhZone(){
		
	}
	
	public int getWhX(){
		return warehouse.getX();
	}
	
	public int getWhY(){
		return warehouse.getY();
	}
	
	public void assignOrder(Order order){
		
		
	}
	public void sortOrdersByWeight() {
		Collections.sort(orders, Order.OrderWeightComparator);
			
			    	
	}

}
