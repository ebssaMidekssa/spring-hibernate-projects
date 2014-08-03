package httpInvoker;

public class GreetingService implements IGreeting {
	private String greeting;
public GreetingService()
{System.out.println("Greeting service constructor");}
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public String getMessage(Person person) {
		return greeting + " " + person.getFirstName() + " "
				+ person.getLastName();
	}
}