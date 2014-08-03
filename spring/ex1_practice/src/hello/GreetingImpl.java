/**
 * 
 */
package hello;

import java.sql.Time;

/**
 * @author Ebssa
 *
 */
public class GreetingImpl implements IGreeting {
	
	public GreetingImpl(){
		System.out.println("inside the default costructor of  "+GreetingImpl.class);
	}
	private String greetings;
	public String getGreetings() {
		return greetings;
	}
	public void setGreetings(String greetings) {
		System.out.println("setting the greeting"+GreetingImpl.class+" SetGreetingMethod");
		this.greetings = greetings;
	}
	/* (non-Javadoc)
	 * @see hello.IGreeting#sayHello()
	 */
	@Override
	public void sayHello() {
		System.out.println(getGreetings());

	}
	public void init(){
		System.out.println("@postconstruct called after setting the properties of the bean. after all the properties are done");
	}
	public void destroy(){
		System.out.println("predestroy invoked when we call close method on application context");
	}

}
