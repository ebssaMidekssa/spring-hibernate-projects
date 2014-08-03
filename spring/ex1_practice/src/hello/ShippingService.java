package hello;

import java.util.Iterator;
import java.util.List;

public class ShippingService {
	private List <IShipper> shippers;
	public ShippingService(){
		
		System.out.println("inside the default constructor of "+ShippingService.class);
	}
	public ShippingService(List<IShipper>shippers){
		this.shippers=shippers;
		System.out.println("inside the "+ShippingService.class +" constructor with argument of type  list<IShipper> ");
		
	}
	public void getShippers(){
		Iterator shipperIterator =  shippers.iterator();
		
		while(shipperIterator.hasNext()){
			System.out.println(shipperIterator.next());
		}
	}

}
