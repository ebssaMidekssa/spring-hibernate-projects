package hello;

public class TestReferer {
	private TestImpl testimpl;
	public TestReferer(TestImpl testImpl){
		this.testimpl = testImpl;
		System.out.println("inside the constructor of " +TestReferer.class + " DI "+TestImpl.class+"using constructor arguments");
		
	}
	public TestReferer() {
		System.out.println("inside default "+TestReferer.class + " class constructor");
	}
	public void setTestimpl(TestImpl testimpl) {
		System.out.println("inside setTestimpl()  in " +TestReferer.class+" class" );
		this.testimpl = testimpl;
	}
	public void test(){
		System.out.println("tracer should trace before and after this method call");
	}

}
