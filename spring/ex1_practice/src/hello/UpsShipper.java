package hello;

public class UpsShipper implements IShipper{
	private IGreeting greeting;

	public void setGreeting(IGreeting greeting) {
		System.out.println("inside the "+UpsShipper.class +  " setGreeting(IGreeting greeting)");
		this.greeting = greeting;
	}

	public UpsShipper() {
		System.out.println("inside the construtor of UPsShipper class"+UpsShipper.class);
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
