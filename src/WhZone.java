import java.util.ArrayList;

public class WhZone {
	private Warehouse warehouse;
	private ArrayList<Order> orders = new ArrayList<>();
	
	public WhZone(){
		
	}
	
	public int getWhX(){
		return warehouse.getX();
	}
	
	public int getWhY(){
		return warehouse.getY();
	}
	
	public void assignOrder(Order order){
		orders.add(order);
	}

}
