import java.util.ArrayList;
import java.lang.Math;

public class Init {
	private ArrayList<Order> orders = new ArrayList<>();
	private ArrayList<WhZone> AreaOfServices = new ArrayList<>();
	
	public Init(){
		
	}
	
	private void allocateOrders(){
		for (Order order: orders){
			double min = calculateDistance(order, AreaOfServices.get(0));
			int warehouseIndex=0;
			for (int i = 1; i< AreaOfServices.size(); i++){
				double distance = calculateDistance(order, AreaOfServices.get(i));
				if (distance <= min){
					min = distance;
					warehouseIndex = i;
				}
			}
			AreaOfServices.get(warehouseIndex).assignOrder(order);
		}
	}
	
	private double calculateDistance(Order order, WhZone warehouse){
		int xDistance = Math.abs(order.getX() - warehouse.getWhX());
		int yDistance = Math.abs(order.getY() - warehouse.getWhY());
		return Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
	}
}
