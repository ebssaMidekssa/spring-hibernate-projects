package hello;

public class UpsPostalShipper implements IShipper {

	public UpsPostalShipper() {
		System.out.println("inside the construtor of UPSPortal Shipper"+UpsPostalShipper.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int calcualteShippingcost() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String shipPackage() {
		// TODO Auto-generated method stub
		return null;
	}

}
